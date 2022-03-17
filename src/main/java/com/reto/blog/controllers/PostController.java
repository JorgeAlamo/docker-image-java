package com.reto.blog.controllers;

import com.reto.blog.entities.Post;
import com.reto.blog.services.BlogService;
import com.reto.blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("posts")
public class PostController {

    static final String BLOG_STATUS_ERROR = "Solo se puede registrar posts en blogs en estado activo.";
    static final String POST_DAY_ERROR = "Solo se puede publicar un post por día.";

    @Autowired
    private PostService postService;

    @Autowired
    private BlogService blogService;

    @GetMapping
    public ResponseEntity<List<Post>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(this.postService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> findById(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.postService.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Post post) {
        return this.blogService.findById(post.getBlog().getId()).getStatus().equals("activo")
                ? this.postService.findByDate(post).size() == 0
                    ? ResponseEntity.status(HttpStatus.OK).body(this.postService.save(post))
                    : ResponseEntity.status(HttpStatus.FORBIDDEN).body(POST_DAY_ERROR)
                : ResponseEntity.status(HttpStatus.FORBIDDEN).body(BLOG_STATUS_ERROR);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Post post) {
        return this.blogService.findById(post.getBlog().getId()).getStatus().equals("activo")
                ? ResponseEntity.status(HttpStatus.OK).body(this.postService.update(id, post))
                : ResponseEntity.status(HttpStatus.FORBIDDEN).body(BLOG_STATUS_ERROR);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id) {
        this.postService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
