package com.codegym.artist.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ModelAndView exception(Exception e) {
        System.out.println(e.getMessage());
        ModelAndView modelAndView = new ModelAndView("artist/error");
        return modelAndView;
    }
}
