package com.example.quanlynghesi.service.job;

import com.example.quanlynghesi.model.Job;
import com.example.quanlynghesi.repository.IJobRepository;
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
