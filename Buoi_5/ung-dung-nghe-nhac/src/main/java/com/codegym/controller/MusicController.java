package com.codegym.controller;

import com.codegym.model.Music;
import com.codegym.model.MusicForm;
import com.codegym.service.IMusicService;
import com.codegym.service.MusicServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/music")
public class MusicController {
    @Autowired
    private IMusicService iMusicService;

    @Value("${file-upload}")
    private String fileUpload;

    @GetMapping("")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView("index");
        List<Music> musicList = iMusicService.findAll();
        modelAndView.addObject("list", musicList);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("musicForm", new MusicForm());
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute MusicForm musicForm) {
        MultipartFile multipartFile = musicForm.getLink();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(musicForm.getLink().getBytes(), new File(fileUpload + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Music music = new Music(musicForm.getId(), musicForm.getActor(), musicForm.getType(), fileName);
        iMusicService.save(music);
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("musicForm", musicForm);
        return new ModelAndView("redirect:" + "/music");
    }

//    @GetMapping("/edit/{id}")
//    public ModelAndView showEditForm(@PathVariable long id) {
//        Music music = iMusicService.findById(id);
//        ModelAndView modelAndView = new ModelAndView("edit");
//        modelAndView.addObject("music", music);
//        return modelAndView;
//    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Music music = iMusicService.findById(id);
//        MusicForm musicForm = new MusicForm(music.getId(), music.getActor(), music.getType());
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("music", music);
        return modelAndView;
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute MusicForm musicForm) {
        MultipartFile multipartFile = musicForm.getLink();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(musicForm.getLink().getBytes(), new File(fileUpload + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Music music = new Music(musicForm.getId(), musicForm.getActor(), musicForm.getType(), fileName);
        iMusicService.update(music);
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("musicForm", musicForm);
        return new ModelAndView("redirect:" + "/music");
    }
}
