package com.codegym.artist.controller.restful;

import com.codegym.artist.model.Artist;
import com.codegym.artist.model.ArtistPrize;
import com.codegym.artist.service.artist_prize.IAritstPrizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/artistprizes")
public class ArtistPrizeRestController {
    @Autowired
    private IAritstPrizeService aritstPrizeService;

    @GetMapping
    public ResponseEntity<Iterable<ArtistPrize>> findAllArtistPrizes() {
        List<ArtistPrize> artistPrizes = (List<ArtistPrize>) aritstPrizeService.findAll();
        if (artistPrizes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(artistPrizes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArtistPrize> findArtistPrizeById(@PathVariable Long id) {
        Optional<ArtistPrize> artistPrize = aritstPrizeService.findById(id);
        if (!artistPrize.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(artistPrize.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ArtistPrize> saveArtistPrize(@RequestBody ArtistPrize artistPrize) {
        aritstPrizeService.save(artistPrize);
        return new ResponseEntity<>(artistPrize, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArtistPrize> updateArtistPrize(@PathVariable Long id, @RequestBody ArtistPrize artistPrize) {
        Optional<ArtistPrize> artistPrizeOptional = aritstPrizeService.findById(id);
        if (!artistPrizeOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        artistPrize.setId(artistPrizeOptional.get().getId());
        aritstPrizeService.save(artistPrize);
        return new ResponseEntity<>(artistPrize, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ArtistPrize> deleteArtistPrize(@PathVariable Long id) {
        Optional<ArtistPrize> artistPrizeOptional = aritstPrizeService.findById(id);
        if (!artistPrizeOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        aritstPrizeService.remove(id);
        return new ResponseEntity<>(artistPrizeOptional.get(), HttpStatus.NO_CONTENT);
    }
}
