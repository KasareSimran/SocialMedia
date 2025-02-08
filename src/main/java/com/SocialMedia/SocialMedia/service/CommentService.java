package com.SocialMedia.SocialMedia.service;


import com.SocialMedia.SocialMedia.exceptions.CommentException;
import com.SocialMedia.SocialMedia.exceptions.PostException;
import com.SocialMedia.SocialMedia.exceptions.UserException;
import com.SocialMedia.SocialMedia.model.Comment;

public interface CommentService {

     Comment createComment(Comment comment, Integer postId, Integer userId) throws CommentException, UserException, PostException;
     Comment findCommentById(Integer commentId) throws CommentException;
     Comment likeComment(Integer commentId,Integer userId) throws CommentException,UserException;
}
