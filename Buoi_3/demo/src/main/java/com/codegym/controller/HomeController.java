package com.codegym.controller;

import com.codegym.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    @GetMapping("/home")
    public ModelAndView showForm() {
        List<Product> list = new ArrayList<>();
        list.add(new Product("Keo", "keo ngon"));
        list.add(new Product("Banh", "Banh thoi"));
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("list",list);
        return mav;
    }
    @GetMapping("/create")
    public ModelAndView formCreate(){
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("product",new Product());
        return modelAndView;
    }
    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute Product product){
        ModelAndView modelAndView = new ModelAndView("/");
        return modelAndView;
    }

    @GetMapping("/submit")
    public ModelAndView showFormSubmit(){
        ModelAndView modelAndView = new ModelAndView("/submit");
        Product product = new Product("Keo", "keo ngon");
        modelAndView.addObject("product", product);
        return modelAndView;
    }
    @PostMapping("/submit")
    public ModelAndView Submit(@ModelAttribute Product product){
        ModelAndView modelAndView = new ModelAndView("/");
        return modelAndView;
    }

}
