package com.reto.blog.services;

import com.reto.blog.entities.Blog;

import java.util.List;

public interface BlogService {

    List<Blog> findAll();
    Blog findById(Long id);
    List<Blog> findByAuthor(Blog blog);
    Blog save(Blog blog);
    Blog update(Long id, Blog blog);
    void deleteById(Long id);

}
