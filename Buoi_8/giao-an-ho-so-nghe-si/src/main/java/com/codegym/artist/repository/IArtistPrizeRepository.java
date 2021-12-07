package com.codegym.artist.repository;

import com.codegym.artist.model.Artist;
import com.codegym.artist.model.ArtistPrize;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IArtistPrizeRepository extends PagingAndSortingRepository<ArtistPrize, Long> {
    @Query(value = "select a.name, p.name, count(ap.year) from artistprize ap join artist a on a.id = ap.artist_id join prize p on p.id = ap.prize_id group by a.name, p.name having a.name = :name", nativeQuery = true)
    Iterable<ArtistPrize> findByPrize(@Param("name") String name);
}
