package com.codegym.blog.repository;

import com.codegym.blog.model.Blog;

import java.util.List;

public interface IBlogRepository {
    List<Blog> findAll();

    Blog findById(Long id);

    void save(Blog t);

    void remove(Long id);
}
