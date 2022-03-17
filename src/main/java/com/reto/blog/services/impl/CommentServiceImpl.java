package com.reto.blog.services.impl;

import com.reto.blog.entities.Comment;
import com.reto.blog.entities.Post;
import com.reto.blog.repositories.CommentRepository;
import com.reto.blog.repositories.PostRepository;
import com.reto.blog.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Comment> findAll() {
        return this.commentRepository.findAll();
    }

    @Override
    public Comment findById(Long id) {
        return this.commentRepository.findById(id).get();
    }

    @Override
    public Comment save(Comment comment) {
        Post post = this.postRepository.findById(comment.getPost().getId()).get();
        comment.setPost(post);
        comment.setDate(new Date());

        return this.commentRepository.save(comment);
    }

    @Override
    public Comment update(Long id, Comment comment) {
        Comment expectedComment = this.commentRepository.findById(id).get();
        Post post = this.postRepository.findById(comment.getPost().getId()).get();

        expectedComment.setDate(new Date());
        expectedComment.setName(comment.getName());
        expectedComment.setState(comment.getState());
        expectedComment.setPost(post);

        return this.commentRepository.save(expectedComment);
    }

    @Override
    public void deleteById(Long id) {
        this.commentRepository.deleteById(id);
    }

}
