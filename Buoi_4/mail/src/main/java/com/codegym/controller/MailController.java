package com.codegym.controller;

import com.codegym.model.Mail;
import com.codegym.service.IMailService;
import com.codegym.service.MailService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/mail")
public class MailController {
    IMailService iMailService = new MailService();
    @GetMapping("/showCreate")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("mail", new Mail());
        modelAndView.addObject("languagesList", new String[]{"English", "Vietnamese", "Japanese", "Chinese"});
        modelAndView.addObject("pageSizeList", new int[]{5, 10, 15, 25, 50, 100});
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView createMail(@ModelAttribute("mail") Mail mail) {
        ModelAndView modelAndView = new ModelAndView("view");
        modelAndView.addObject("mail", mail);
        iMailService.save(mail);
        modelAndView.addObject("mailList", iMailService.findAll());
        return modelAndView;
    }
}
