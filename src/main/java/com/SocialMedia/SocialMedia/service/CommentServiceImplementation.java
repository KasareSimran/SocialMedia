package com.SocialMedia.SocialMedia.service;

import com.SocialMedia.SocialMedia.model.Comment;
import com.SocialMedia.SocialMedia.model.Post;
import com.SocialMedia.SocialMedia.model.User;
import com.SocialMedia.SocialMedia.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImplementation implements CommentService{

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @Autowired
    private CommentRepository commentRepository;


    @Override
    public Comment createComment(Comment comment, Integer postId, Integer userId) throws Exception {
        User user =userService.findUserById(userId);
        Post post=postService.findPostById(postId);
        comment.setUser(user);
        comment.setContent(comment.getContent());
        comment.se

        return null;
    }

    @Override
    public Comment findCommentById(Integer commentId) {
        return null;
    }

    @Override
    public Comment likeComment(Integer commentId, Integer userId) {
        return null;
    }
}
