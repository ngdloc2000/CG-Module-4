package com.example.quanlynghesi.controller;

import com.example.quanlynghesi.model.Artist;
import com.example.quanlynghesi.model.Job;
import com.example.quanlynghesi.service.job.IJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/jobs")
public class JobController {
    @Autowired
    private IJobService jobService;

    @GetMapping("/list")
    public ResponseEntity<Iterable<Job>> findAllJobs() {
        List<Job> jobs = (List<Job>) jobService.findAll();
        if (jobs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(jobs, HttpStatus.OK);
    }
}
