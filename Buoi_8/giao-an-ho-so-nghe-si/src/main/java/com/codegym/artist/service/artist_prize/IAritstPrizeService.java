package com.codegym.artist.service.artist_prize;

import com.codegym.artist.model.Artist;
import com.codegym.artist.model.ArtistPrize;
import com.codegym.artist.service.IGeneralService;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IAritstPrizeService extends IGeneralService<ArtistPrize> {
    Iterable<ArtistPrize> findByPrize(String name);
}
