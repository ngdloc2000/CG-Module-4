package com.codegym.artist.formatter;

import com.codegym.artist.model.Job;
import com.codegym.artist.service.job.IJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;

@Component
public class JobFormatter implements Formatter<Job> {
    private IJobService jobService;

    @Autowired
    public JobFormatter(IJobService jobService) {
        this.jobService = jobService;
    }

    @Override
    public Job parse(String text, Locale locale) throws ParseException {
        Optional<Job> jobOptional = jobService.findById(Long.parseLong(text));
        return jobOptional.orElse(null);
    }

    @Override
    public String print(Job object, Locale locale) {
        return "[" + object.getId() + ", " +object.getName() + "]";
    }
}
