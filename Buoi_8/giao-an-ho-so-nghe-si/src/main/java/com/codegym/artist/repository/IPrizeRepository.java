package com.codegym.artist.repository;

import com.codegym.artist.model.Prize;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPrizeRepository extends PagingAndSortingRepository<Prize, Long> {
}
