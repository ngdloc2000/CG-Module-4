package com.codegym.artist.service.artist;

import com.codegym.artist.model.Artist;
import com.codegym.artist.service.IGeneralService;

public interface IArtistService extends IGeneralService<Artist> {
    Iterable<Artist> findAllByJob_Name(String name);
}
