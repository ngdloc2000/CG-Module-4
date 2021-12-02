package com.codegym.artist.service.job;

import com.codegym.artist.model.Job;
import com.codegym.artist.repository.IJobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JobService implements IJobService {
    @Autowired
    private IJobRepository jobRepository;

    @Override
    public Iterable<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public Optional<Job> findById(Long id) {
        return jobRepository.findById(id);
    }

    @Override
    public void save(Job job) {
        jobRepository.save(job);
    }

    @Override
    public void remove(Long id) {
        jobRepository.deleteById(id);
    }
}
