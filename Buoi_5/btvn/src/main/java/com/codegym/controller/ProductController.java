package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import com.codegym.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    IProductService iProductService = new ProductService();

    @GetMapping("")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView("list");
        List<Product> products = iProductService.findAll();
        modelAndView.addObject("list", products);
        return modelAndView;
    }
}
