package com.example.saatcoding.requirement.services;

import com.example.saatcoding.requirement.Repository.ContentRepository;
import com.example.saatcoding.requirement.main.Content;
import com.example.saatcoding.requirement.main.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ContentService {
    private final ContentRepository contentRepository;
    public List<Content> getContent() {
        return contentRepository.findAll();
    }
    public void addNewContent(Content content) {
        Optional<Content> contentOptional = contentRepository.
                findContentByName(content.getName());
        if (contentOptional.isPresent()) {
            throw new IllegalStateException("name taken");
        }
        contentRepository.save(content);
    }

    public void deleteContent(Long contentId) {
        boolean exists = contentRepository.existsById(contentId);
        if (!exists) {
            throw new IllegalStateException("content with id " +
                    contentId + " does not exists");
        }
        contentRepository.deleteById(contentId);
    }
    @Transactional
    public void updateContent(Long contentId,
                               String videoUrl) {
        Content content = contentRepository.findById(contentId).orElseThrow(() -> new IllegalStateException(
                "content with id" + contentId + " does not exists"));
        if (videoUrl != null &&
                videoUrl.length() > 0 &&
                !Objects.equals(content.getVideoUrl(), videoUrl)) {
            Optional<Content> contentOptional = contentRepository.findContentByVideoUrl(videoUrl);
            if (contentOptional.isPresent()) {
                throw new IllegalStateException("videoUrl used");

            }
            content.setVideoUrl(videoUrl);
        }
        contentRepository.save(content);
    }
}
