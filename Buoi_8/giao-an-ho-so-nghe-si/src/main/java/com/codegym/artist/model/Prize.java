package com.codegym.artist.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "prize")
public class Prize {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "prize")
    private List<ArtistPrize> artistPrizes;

    public Prize() {
    }

    public Prize(Long id, String name, List<ArtistPrize> artistPrizes) {
        this.id = id;
        this.name = name;
        this.artistPrizes = artistPrizes;
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

    public List<ArtistPrize> getArtistPrizes() {
        return artistPrizes;
    }

    public void setArtistPrizes(List<ArtistPrize> artistPrizes) {
        this.artistPrizes = artistPrizes;
    }
}
