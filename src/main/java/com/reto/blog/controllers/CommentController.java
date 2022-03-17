package com.reto.blog.controllers;

import com.reto.blog.entities.Comment;
import com.reto.blog.entities.Post;
import com.reto.blog.services.CommentService;
import com.reto.blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("comments")
public class CommentController {

    static final String POST_STATUS_ERROR = "Solo se pueden registrar comentarios en post de estado publicado.";

    @Autowired
    private CommentService commentService;

    @Autowired
    private PostService postService;

    @GetMapping
    public ResponseEntity<List<Comment>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(this.commentService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comment> findById(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.commentService.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Comment comment) {
        return this.postService.findById(comment.getPost().getId()).getStatus().equals("publicado")
                ? ResponseEntity.status(HttpStatus.OK).body(this.commentService.save(comment))
                : ResponseEntity.status(HttpStatus.FORBIDDEN).body(POST_STATUS_ERROR);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Comment comment) {
        return this.postService.findById(comment.getPost().getId()).getStatus().equals("publicado")
                ? ResponseEntity.status(HttpStatus.OK).body(this.commentService.update(id, comment))
                : ResponseEntity.status(HttpStatus.FORBIDDEN).body(POST_STATUS_ERROR);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id) {
        this.commentService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
