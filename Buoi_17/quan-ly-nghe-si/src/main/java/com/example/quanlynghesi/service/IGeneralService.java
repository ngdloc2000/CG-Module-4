package com.example.quanlynghesi.service;

import com.example.quanlynghesi.model.Job;

import java.util.Optional;

public interface IGeneralService<T> {
    Iterable<T> findAll();

    Optional<T> findById(Long id);

    void save(T t);

    void remove(Long id);
}
