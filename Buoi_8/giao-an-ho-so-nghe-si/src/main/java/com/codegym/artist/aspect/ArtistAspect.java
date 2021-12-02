package com.codegym.artist.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ArtistAspect {
    @Before(value = "executeController()")
    public void beforeExecuteController() {
        System.out.println("Before Controller");
    }

    @After(value = "executeController()")
    public void afterExecuteController() {
        System.out.println("After Controller");
    }

    @Pointcut(value = "within(com.codegym.artist.controller.*)")
    public void executeController() {}
}
