package com.codegym.artist.repository;

import com.codegym.artist.model.ArtistPrize;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IArtistPrizeRepository extends PagingAndSortingRepository<ArtistPrize, Long> {
}
