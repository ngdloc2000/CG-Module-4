package com.codegym.artist.controller;

import com.codegym.artist.model.Artist;
import com.codegym.artist.model.ArtistPrize;
import com.codegym.artist.model.Prize;
import com.codegym.artist.service.artist.IArtistService;
import com.codegym.artist.service.artist_prize.IAritstPrizeService;
import com.codegym.artist.service.prize.IPrizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/artistprize")
public class ArtistPrizeController {
    @Autowired
    private IAritstPrizeService aritstPrizeService;

    @Autowired
    private IArtistService artistService;

    @Autowired
    private IPrizeService prizeService;

    @ModelAttribute("artists")
    public Iterable<Artist> artists() {
        return artistService.findAll();
    }

    @ModelAttribute("prizes")
    public Iterable<Prize> prizes() {
        return prizeService.findAll();
    }

    @GetMapping("")
    public ModelAndView listArtistPrize() {
        Iterable<ArtistPrize> artistPrizes = aritstPrizeService.findAll();
        ModelAndView modelAndView = new ModelAndView("artist_prize/list");
        modelAndView.addObject("artistprizes", artistPrizes);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("artist_prize/create");
        modelAndView.addObject("artistprize", new ArtistPrize());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView save(@ModelAttribute("artistprize") ArtistPrize artistPrize) {
        aritstPrizeService.save(artistPrize);
        return new ModelAndView("artist_prize/create");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable("id") Long id) {
        Optional<ArtistPrize> artistPrize = aritstPrizeService.findById(id);
        ModelAndView modelAndView = new ModelAndView("artist_prize/edit");
        modelAndView.addObject("artistprize", artistPrize.get());
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView updateArtistPrize(@ModelAttribute("artistprize") ArtistPrize artistPrize) {
        aritstPrizeService.save(artistPrize);
        return new ModelAndView("redirect:/artistprize");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {
        aritstPrizeService.remove(id);
        return new ModelAndView("redirect:/artistprize");
    }
}
