package com.example.quanlynghesi.repository;

import com.example.quanlynghesi.model.Artist;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IArtistRepository extends PagingAndSortingRepository<Artist, Long> {
}
