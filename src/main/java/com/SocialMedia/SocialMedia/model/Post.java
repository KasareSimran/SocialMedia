package com.SocialMedia.SocialMedia.model;


import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String caption;
    private String image;
    private String video;
    private User user;
    private LocalDateTime createdAt;





}
