package com.codegym.artist.service.artist;

import com.codegym.artist.model.Artist;
import com.codegym.artist.repository.IArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ArtistService implements IArtistService {
    @Autowired
    private IArtistRepository artistRepository;

    @Override
    public Iterable<Artist> findAll() {
        return artistRepository.findAll();
    }

    @Override
    public Optional<Artist> findById(Long id) {
        return artistRepository.findById(id);
    }

    @Override
    public void save(Artist artist) {
        artistRepository.save(artist);
    }

    @Override
    public void remove(Long id) {
        artistRepository.deleteById(id);
    }

    @Override
    public Iterable<Artist> findAllByJob_Name(String name) {
        return artistRepository.findAllByJob_Name(name);
    }
}
