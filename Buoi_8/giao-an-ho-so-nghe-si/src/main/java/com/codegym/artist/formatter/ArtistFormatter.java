package com.codegym.artist.formatter;

import com.codegym.artist.model.Artist;
import com.codegym.artist.service.artist.IArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;

@Component
public class ArtistFormatter implements Formatter<Artist> {
    private IArtistService artistService;

    @Autowired
    public ArtistFormatter(IArtistService artistService) {
        this.artistService = artistService;
    }

    @Override
    public Artist parse(String text, Locale locale) throws ParseException {
        Optional<Artist> artistOptional = artistService.findById(Long.parseLong(text));
        return artistOptional.orElse(null);
    }

    @Override
    public String print(Artist object, Locale locale) {
        return "[" + object.getId() + ", " +object.getName() + "]";
    }
}
