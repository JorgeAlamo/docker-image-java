package com.reto.blog.controllers;

import com.reto.blog.entities.Author;
import com.reto.blog.entities.Blog;
import com.reto.blog.services.AuthorService;
import com.reto.blog.services.BlogService;
import com.reto.blog.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("blogs")
public class BlogController {

    static final String AUTHOR_AGE_ERROR = "Solo pueden tener blogs los autores mayores de 18 años.";
    static final String NRO_BLOGS_ERROR = "Un autor puede tener máximo 03 blogs.";

    @Autowired
    private BlogService blogService;

    @Autowired
    private AuthorService authorService;

    @GetMapping
    public ResponseEntity<List<Blog>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(this.blogService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> findById(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.blogService.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Blog blog) {
        Author author = this.authorService.findById(blog.getAuthor().getId());

        return DateUtils.calculateAge(author.getBirthDate()) > 18
                ? this.blogService.findByAuthor(blog).size() < 3
                ? ResponseEntity.status(HttpStatus.OK).body(this.blogService.save(blog))
                : ResponseEntity.status(HttpStatus.FORBIDDEN).body(NRO_BLOGS_ERROR)
                : ResponseEntity.status(HttpStatus.FORBIDDEN).body(AUTHOR_AGE_ERROR);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Blog blog) {
        Author author = this.authorService.findById(blog.getAuthor().getId());

        return DateUtils.calculateAge(author.getBirthDate()) > 18
                ? this.blogService.findByAuthor(blog).size() < 3
                    ? ResponseEntity.status(HttpStatus.OK).body(this.blogService.update(id, blog))
                    : ResponseEntity.status(HttpStatus.FORBIDDEN).body(NRO_BLOGS_ERROR)
                : ResponseEntity.status(HttpStatus.FORBIDDEN).body(AUTHOR_AGE_ERROR);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id) {
        this.blogService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
