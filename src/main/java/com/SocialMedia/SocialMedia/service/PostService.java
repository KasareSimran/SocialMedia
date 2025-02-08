package com.SocialMedia.SocialMedia.service;

import com.SocialMedia.SocialMedia.exceptions.PostException;
import com.SocialMedia.SocialMedia.exceptions.UserException;
import com.SocialMedia.SocialMedia.model.Post;

import java.util.List;

public interface PostService {

    Post createNewPost(Post post, Integer userId) throws PostException, UserException;
    String deletePost(Integer postId,Integer userId) throws PostException,UserException;
    List<Post> findPostByUserId(Integer userId);
    Post findPostById(Integer postId) throws PostException;
    List<Post> findAllPost();
    Post savedPost(Integer postId, Integer userId) throws PostException, UserException;
    Post likePost(Integer postId,Integer userId) throws PostException, UserException;
}
