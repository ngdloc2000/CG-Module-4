package com.codegym.artist.model;

import javax.persistence.*;

@Entity
public class ArtistPrize {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "artist_id")
    private Artist artist;
    @ManyToOne
    @JoinColumn(name = "prize_id")
    private Prize prize;
    private String year;

    public ArtistPrize() {
    }

    public ArtistPrize(Long id, Artist artist, Prize prize, String year) {
        this.id = id;
        this.artist = artist;
        this.prize = prize;
        this.year = year;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Prize getPrize() {
        return prize;
    }

    public void setPrize(Prize prize) {
        this.prize = prize;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
