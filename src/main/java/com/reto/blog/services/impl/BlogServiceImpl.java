package com.reto.blog.services.impl;

import com.reto.blog.entities.Author;
import com.reto.blog.entities.Blog;
import com.reto.blog.repositories.AuthorRepository;
import com.reto.blog.repositories.BlogRepository;
import com.reto.blog.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public List<Blog> findAll() {
        return this.blogRepository.findAll();
    }

    @Override
    public Blog findById(Long id) {
        return this.blogRepository.findById(id).get();
    }

    @Override
    public List<Blog> findByAuthor(Blog blog) {
        Author author = this.authorRepository.findById(blog.getAuthor().getId()).get();
        return this.blogRepository.findAll()
                .stream()
                .filter(item ->
                        item.getAuthor().equals(author))
                .collect(Collectors.toList());
    }

    @Override
    public Blog save(Blog blog) {
        Author author = this.authorRepository.findById(blog.getAuthor().getId()).get();
        blog.setAuthor(author);

        return this.blogRepository.save(blog);
    }

    @Override
    public Blog update(Long id, Blog blog) {
        Blog expectedBlog = this.blogRepository.findById(id).get();
        Author author = this.authorRepository.findById(blog.getAuthor().getId()).get();

        expectedBlog.setName(blog.getName());
        expectedBlog.setDescription(blog.getDescription());
        expectedBlog.setUrl(blog.getUrl());
        expectedBlog.setStatus(blog.getStatus());
        expectedBlog.setAuthor(author);

        return this.blogRepository.save(expectedBlog);
    }

    @Override
    public void deleteById(Long id) {
        this.blogRepository.deleteById(id);
    }

}
