package com.codegym.artist.service.prize;

import com.codegym.artist.model.Prize;
import com.codegym.artist.repository.IArtistRepository;
import com.codegym.artist.repository.IPrizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PrizeService implements IPrizeService{
    @Autowired
    private IPrizeRepository prizeRepository;

    @Override
    public Iterable<Prize> findAll() {
        return prizeRepository.findAll();
    }

    @Override
    public Optional<Prize> findById(Long id) {
        return prizeRepository.findById(id);
    }

    @Override
    public void save(Prize prize) {

    }

    @Override
    public void remove(Long id) {

    }
}
