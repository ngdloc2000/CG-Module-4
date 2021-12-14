package com.example.quanlynghesi.repository;

import com.example.quanlynghesi.model.Job;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJobRepository extends PagingAndSortingRepository<Job, Long> {
}
