package com.reto.blog.services;

import com.reto.blog.entities.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> findAll();
    Comment findById(Long id);
    Comment save(Comment comment);
    Comment update(Long id, Comment comment);
    void deleteById(Long id);

}
