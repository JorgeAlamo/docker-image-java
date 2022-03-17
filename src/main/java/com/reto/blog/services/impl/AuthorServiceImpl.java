package com.reto.blog.services.impl;

import com.reto.blog.entities.Author;
import com.reto.blog.repositories.AuthorRepository;
import com.reto.blog.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public List<Author> findAll() {
        return this.authorRepository.findAll();
    }

    @Override
    public Author findById(Long id) {
        return this.authorRepository.findById(id).get();
    }

    @Override
    public Author save(Author author) {
        return this.authorRepository.save(author);
    }

    @Override
    public Author update(Long id, Author author) {
        Author expectedAuthor = this.authorRepository.findById(id).get();

        expectedAuthor.setName(author.getName());
        expectedAuthor.setEmail(author.getEmail());
        expectedAuthor.setPhone(author.getPhone());
        expectedAuthor.setBirthDate(author.getBirthDate());

        return this.authorRepository.save(expectedAuthor);
    }

    @Override
    public void deleteById(Long id) {
        this.authorRepository.deleteById(id);
    }

}
