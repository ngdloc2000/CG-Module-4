package com.codegym.artist.repository;

import com.codegym.artist.model.Artist;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IArtistRepository extends PagingAndSortingRepository<Artist, Long> {
    Iterable<Artist> findAllByJob_Name(String name);
}
