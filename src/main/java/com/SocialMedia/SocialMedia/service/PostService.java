package com.SocialMedia.SocialMedia.service;

import com.SocialMedia.SocialMedia.model.Post;


import java.util.List;


public interface PostService {

    Post createNewPost(Post post, Integer userId) throws Exception;
    String deletePost(Integer postId,Integer userId) throws Exception;
    List<Post> findPostByUserId(Integer userId);
    Post findPostById(Integer postId) throws Exception;
    List<Post> findAllPost();
    Post savedPost(Integer postId, Integer userId);
    Post likePost(Integer postId,Integer userId);
}
