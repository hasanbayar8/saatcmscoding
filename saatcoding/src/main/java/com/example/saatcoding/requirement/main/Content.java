package com.example.saatcoding.requirement.main;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table
public class Content {
    @Id
    Long id;

    @ManyToMany
    @JoinTable(
            name = "licence_content" ,
            joinColumns = @JoinColumn(name = "content_id"),
            inverseJoinColumns = @JoinColumn(name = "licence_id"))
    Set<Licence> licences;

    @SequenceGenerator(
            name= "content_sequence",
            sequenceName= "content_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "contentSequence"
    )
    private String name;
    @Enumerated(EnumType.STRING)
    private Status status;
    private String posterUrl;
    private String videoUrl;

    public Content(Long id,
                   String name,
                   Status status,
                   String posterUrl,
                   String videoUrl) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.posterUrl = posterUrl;
        this.videoUrl = videoUrl;
    }

    public Content(String name,
                   Status status,
                   String posterUrl,
                   String videoUrl) {
        this.name = name;
        this.status = status;
        this.posterUrl = posterUrl;
        this.videoUrl = videoUrl;

    }

    public Content() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    @Override
    public String toString() {
        return "Content{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", posterUrl='" + posterUrl + '\'' +
                ", videoUrl='" + videoUrl + '\'' +
                '}';
    }
}
