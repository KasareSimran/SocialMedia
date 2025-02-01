package com.SocialMedia.SocialMedia.service;


import com.SocialMedia.SocialMedia.model.Comment;

public interface CommentService {

     Comment createComment(Comment comment, Integer postId, Integer userId);
     Comment findCommentById(Integer commentId);
     Comment likeComment(Integer commentId,Integer userId);
}
