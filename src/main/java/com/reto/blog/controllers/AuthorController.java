package com.reto.blog.controllers;

import com.reto.blog.entities.Author;
import com.reto.blog.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping
    public ResponseEntity<List<Author>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(this.authorService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> findById(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.authorService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Author> save(@RequestBody Author author) {
        return ResponseEntity.status(HttpStatus.OK).body(this.authorService.save(author));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Author> update(@PathVariable("id") Long id, @RequestBody Author author) {
        return ResponseEntity.status(HttpStatus.OK).body(this.authorService.update(id, author));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id) {
        this.authorService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
