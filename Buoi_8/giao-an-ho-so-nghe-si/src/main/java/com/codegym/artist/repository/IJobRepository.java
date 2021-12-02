package com.codegym.artist.repository;

import com.codegym.artist.model.Job;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJobRepository extends PagingAndSortingRepository<Job, Long> {
}
