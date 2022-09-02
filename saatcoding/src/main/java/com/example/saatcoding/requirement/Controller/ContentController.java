package com.example.saatcoding.requirement.Controller;

import com.example.saatcoding.requirement.main.Content;
import com.example.saatcoding.requirement.services.ContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/content")
@RequiredArgsConstructor
public class ContentController {
    private final ContentService contentService;

    @GetMapping
    public List<Content> getContent() {
        return contentService.getContent();
    }

    @PostMapping
    public void registerNewContent(@RequestBody Content content) {
        contentService.addNewContent(content);
    }

    @DeleteMapping(path = "{contentId}")
    public void deleteContent(@PathVariable("contentId") Long contentId) {
        contentService.deleteContent(contentId);
    }

    @PutMapping(path = "{contentId}")
    public void updateContent(
            @PathVariable("contentId") Long contentId,
            @RequestParam(required = false) String videoUrl) {
        contentService.updateContent(contentId, videoUrl);
    }

}
