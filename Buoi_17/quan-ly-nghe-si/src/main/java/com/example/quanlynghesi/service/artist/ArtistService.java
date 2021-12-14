package com.example.quanlynghesi.service.artist;

import com.example.quanlynghesi.model.Artist;
import com.example.quanlynghesi.repository.IArtistRepository;
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
}
