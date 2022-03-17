package com.reto.blog.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "status")
    private String status;

    @Column(name = "content")
    private String content;

    @ManyToOne
    @JoinColumn(name = "blog_id")
    @JsonIgnoreProperties(value = "posts")
    @NotNull
    private Blog blog;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = "post")
    private List<Comment> comments;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", date=" + date +
                ", status='" + status + '\'' +
                ", content='" + content + '\'' +
                ", blog=" + blog +
                ", comments=" + comments +
                '}';
    }

}
