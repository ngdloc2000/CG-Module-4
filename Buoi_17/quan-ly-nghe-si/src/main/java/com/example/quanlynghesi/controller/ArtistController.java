package com.example.quanlynghesi.controller;

import com.example.quanlynghesi.model.Artist;
import com.example.quanlynghesi.model.Job;
import com.example.quanlynghesi.service.artist.IArtistService;
import com.example.quanlynghesi.service.job.IJobService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/artists")
public class ArtistController {
    @Autowired
    Environment env;

    @Autowired
    private IArtistService artistService;

    //    ------------------------ REST ------------------------------------
    @GetMapping("/list")
    public ResponseEntity<Iterable<Artist>> findAllArtists() {
        List<Artist> artists = (List<Artist>) artistService.findAll();
        if (artists.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(artists, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Artist> findArtistById(@PathVariable Long id) {
        Optional<Artist> artistOptional = artistService.findById(id);
        if (!artistOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(artistOptional.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Artist> saveArtist(@RequestPart("file") MultipartFile file, @RequestPart("newArtist") String artist) {
        MultipartFile multipartFile = file;
        String file1 = multipartFile.getOriginalFilename();
        try {
            Artist artist1 = new ObjectMapper().readValue(artist, Artist.class);
            artist1.setImage(file1);
            artistService.save(artist1);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        String fileUpload = env.getProperty("upload.path");
        try {
            FileCopyUtils.copy(multipartFile.getBytes(), new File(fileUpload + file1));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Artist> updateArtist(@PathVariable("id") Long id, @RequestBody Artist artist) {
        Optional<Artist> artistOptional = artistService.findById(id);
        if (!artistOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        artist.setId(artistOptional.get().getId());
        artistService.save(artist);
        return new ResponseEntity<>(HttpStatus.OK);
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
}
