package com.reto.blog.services;

import com.reto.blog.entities.Post;

import java.util.List;

public interface PostService {

    List<Post> findAll();
    Post findById(Long id);
    List<Post> findByDate(Post post);
    Post save(Post post);
    Post update(Long id, Post post);
    void deleteById(Long id);

}
