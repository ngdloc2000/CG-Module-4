package com.codegym.model;

import javax.persistence.*;

@Entity
@Table(name = "music")
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String actor;
    private String type;
    private String link;

    public Music() {
    }

    public Music(Long id, String actor, String type, String link) {
        this.id = id;
        this.actor = actor;
        this.type = type;
        this.link = link;
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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}