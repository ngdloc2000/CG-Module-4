package com.codegym.model;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class MusicForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String actor;
    private String type;
    private MultipartFile link;

    public MusicForm() {
    }

    public MusicForm(Long id, String actor, String type) {
        this.id = id;
        this.actor = actor;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public MultipartFile getLink() {
        return link;
    }

    public void setLink(MultipartFile link) {
        this.link = link;
    }

    public MusicForm(Long id, String actor, String type, MultipartFile link) {
        this.id = id;
        this.actor = actor;
        this.type = type;
        this.link = link;
    }
}
