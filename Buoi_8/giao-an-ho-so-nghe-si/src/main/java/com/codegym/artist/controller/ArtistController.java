package com.codegym.artist.controller;

import com.codegym.artist.model.Artist;
import com.codegym.artist.model.ArtistForm;
import com.codegym.artist.model.Job;
import com.codegym.artist.service.artist.IArtistService;
import com.codegym.artist.service.job.IJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Controller
public class ArtistController {
    @Autowired
    private IArtistService artistService;

    @Value("${file-upload}")
    private String fileUpload;

    @Autowired
    private IJobService jobService;

    @ModelAttribute("jobs")
    public Iterable<Job> jobs() {
        return jobService.findAll();
    }

    @GetMapping("/artist")
    public ModelAndView listArtist() {
        System.out.println("Controller");
        Iterable<Artist> artists = artistService.findAll();
        ModelAndView modelAndView = new ModelAndView("artist/list");
        modelAndView.addObject("artists", artists);
        return modelAndView;
    }

    @GetMapping("/create-artist")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("artist/create");
        modelAndView.addObject("artistForm", new ArtistForm());
        return modelAndView;
    }

    @PostMapping("/create-artist")
    public ModelAndView saveProduct(@ModelAttribute ArtistForm artistForm) {
        MultipartFile multipartFile = artistForm.getImage();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(artistForm.getImage().getBytes(), new File(fileUpload + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Artist artist = new Artist(artistForm.getId(), artistForm.getName(),
                artistForm.getDob(), artistForm.getCountryside(), artistForm.getFanpage(), fileName, artistForm.getJob());
        artistService.save(artist);
        ModelAndView modelAndView = new ModelAndView("artist/create");
        modelAndView.addObject("artistForm", artistForm);
        return modelAndView;
    }

    @GetMapping("/delete-artist/{id}")
    public ModelAndView showDeleteForm(@PathVariable("id") Long id) {
        Optional<Artist> artist = artistService.findById(id);
        ModelAndView modelAndView = new ModelAndView("artist/delete");
        modelAndView.addObject("artist", artist.get());
        return modelAndView;
    }

    @PostMapping("/delete-artist")
    public String delete(@ModelAttribute Artist artist) {
        artistService.remove(artist.getId());
        return "redirect:artist";
    }
}
