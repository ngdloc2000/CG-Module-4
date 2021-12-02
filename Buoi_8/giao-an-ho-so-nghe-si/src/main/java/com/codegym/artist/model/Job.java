package com.codegym.artist.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "job")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(targetEntity = Artist.class, mappedBy = "job")
    private List<Artist> artists;

    public Job() {
    }

    public Job(Long id, String name, List<Artist> artists) {
        this.id = id;
        this.name = name;
        this.artists = artists;
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

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }
}
