package com.codegym.service;

import com.codegym.model.Music;
import com.codegym.model.MusicForm;

import java.util.List;

public interface IMusicService {
    List<Music> findAll();

    Music findById(Long id);

    Music update(Music music);

    Music save(Music music);

    void remove(Integer id);
}
