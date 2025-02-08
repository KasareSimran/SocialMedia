package com.SocialMedia.SocialMedia.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String Content;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToMany
    private List<User> liked = new ArrayList<>();
    private LocalDateTime createdAt;

    public Comment() {
    }

    public Comment(Integer id, String content, User user, List<User> liked, LocalDateTime createdAt) {
        this.id = id;
        Content = content;
        this.user = user;
        this.liked = liked;
        this.createdAt = createdAt;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getLiked() {
        return liked;
    }

    public void setLiked(List<User> liked) {
        this.liked = liked;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
