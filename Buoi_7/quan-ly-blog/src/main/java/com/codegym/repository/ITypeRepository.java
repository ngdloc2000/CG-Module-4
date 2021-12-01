package com.codegym.repository;

import com.codegym.model.Type;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITypeRepository extends PagingAndSortingRepository<Type, Long> {
}
