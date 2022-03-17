package com.reto.blog.services.impl;

import com.reto.blog.entities.Author;
import com.reto.blog.entities.Blog;
import com.reto.blog.entities.Post;
import com.reto.blog.repositories.AuthorRepository;
import com.reto.blog.repositories.BlogRepository;
import com.reto.blog.repositories.PostRepository;
import com.reto.blog.services.PostService;
import com.reto.blog.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public List<Post> findAll() {
        return this.postRepository.findAll();
    }

    @Override
    public Post findById(Long id) {
        return this.postRepository.findById(id).get();
    }

    @Override
    public List<Post> findByDate(Post post) {
        Blog blog = this.blogRepository.findById(post.getBlog().getId()).get();
        Author author = this.authorRepository.findById(blog.getAuthor().getId()).get();

        return this.postRepository.findAll()
                .stream()
                .filter(item ->
                        item.getBlog()
                                .equals(blog))
                .filter(item ->
                        item.getBlog().getAuthor()
                                .equals(author))
                .filter(item ->
                        DateUtils.isSameDay(item.getDate(), new Date()))
                .collect(Collectors.toList());
    }

    @Override
    public Post save(Post post) {
        Blog blog = this.blogRepository.findById(post.getBlog().getId()).get();
        post.setBlog(blog);
        post.setDate(new Date());

        return this.postRepository.save(post);
    }

    @Override
    public Post update(Long id, Post post) {
        Post expectedPost = this.postRepository.findById(id).get();
        Blog blog = this.blogRepository.findById(post.getBlog().getId()).get();

        expectedPost.setTitle(post.getTitle());
        expectedPost.setDate(new Date());
        expectedPost.setStatus(post.getStatus());
        expectedPost.setContent(post.getContent());
        expectedPost.setBlog(blog);

        return this.postRepository.save(expectedPost);
    }

    @Override
    public void deleteById(Long id) {
        this.postRepository.deleteById(id);
    }

}
