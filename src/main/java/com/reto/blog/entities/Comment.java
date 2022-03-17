package com.reto.blog.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "name")
    private String name;

    @Column(name = "state")
    private String state;

    @ManyToOne
    @JoinColumn(name = "post_id")
    @JsonIgnoreProperties(value = "comments")
    @NotNull
    private Post post;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", date=" + date +
                ", name='" + name + '\'' +
                ", state='" + state + '\'' +
                ", post=" + post +
                '}';
    }

}
