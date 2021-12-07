package com.codegym.artist.controller.restful;

import com.codegym.artist.model.Artist;
import com.codegym.artist.model.Job;
import com.codegym.artist.service.artist.IArtistService;
import com.codegym.artist.service.job.IJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/artists")
public class ArtistRestController {
    @Autowired
    private IArtistService artistService;

    @Autowired
    private IJobService jobService;

    @GetMapping
    public ResponseEntity<Iterable<Artist>> findAllArtists() {
        List<Artist> artists = (List<Artist>) artistService.findAll();
        if (artists.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(artists, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Artist> findArtistById(@PathVariable Long id) {
        Optional<Artist> artist = artistService.findById(id);
        if (!artist.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(artist.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Artist> saveArtist(@RequestBody Artist artist) {
        artistService.save(artist);
        return new ResponseEntity<>(artist, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Artist> updateArtist(@PathVariable Long id, @RequestBody Artist artist) {
        Optional<Artist> artistOptional = artistService.findById(id);
        if (!artistOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        artist.setId(artistOptional.get().getId());
        artistService.save(artist);
        return new ResponseEntity<>(artist, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Artist> deleteCustomer(@PathVariable Long id) {
        Optional<Artist> artistOptional = artistService.findById(id);
        if (!artistOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        artistService.remove(id);
        return new ResponseEntity<>(artistOptional.get(), HttpStatus.NO_CONTENT);
    }

    @GetMapping("/job/{id}")
    public ResponseEntity<Iterable<Artist>> listArtistByJob(@PathVariable Long id) {
        Optional<Job> jobOptional = jobService.findById(id);
        List<Artist> artists = (List<Artist>) artistService.findAllByJob_Name(jobOptional.get().getName());
        return new ResponseEntity<>(artists, HttpStatus.OK);
    }
}
