package com.codegym.artist.service.artist_prize;

import com.codegym.artist.model.Artist;
import com.codegym.artist.model.ArtistPrize;
import com.codegym.artist.repository.IArtistPrizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ArtistPrizeService implements IAritstPrizeService {
    @Autowired
    private IArtistPrizeRepository artistPrizeRepository;

    @Override
    public Iterable<ArtistPrize> findAll() {
        return artistPrizeRepository.findAll();
    }

    @Override
    public Optional<ArtistPrize> findById(Long id) {
        return artistPrizeRepository.findById(id);
    }

    @Override
    public void save(ArtistPrize artistPrize) {
        artistPrizeRepository.save(artistPrize);
    }

    @Override
    public void remove(Long id) {
        artistPrizeRepository.deleteById(id);
    }

    @Override
    public Iterable<ArtistPrize> findByPrize(String name) {
        return artistPrizeRepository.findByPrize(name);
    }
}
