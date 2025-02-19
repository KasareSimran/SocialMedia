package com.SocialMedia.SocialMedia.service;

import com.SocialMedia.SocialMedia.exceptions.CommentException;
import com.SocialMedia.SocialMedia.exceptions.PostException;
import com.SocialMedia.SocialMedia.exceptions.UserException;
import com.SocialMedia.SocialMedia.model.Comment;
import com.SocialMedia.SocialMedia.model.Post;
import com.SocialMedia.SocialMedia.model.User;
import com.SocialMedia.SocialMedia.repository.CommentRepository;
import com.SocialMedia.SocialMedia.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CommentServiceImplementation implements CommentService{

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;


    @Override
    public Comment createComment(Comment comment, Integer postId, Integer userId) throws CommentException, UserException, PostException {
        User user =userService.findUserById(userId);
        Post post=postService.findPostById(postId);

        comment.setUser(user);
        comment.setContent(comment.getContent());
        comment.setCreatedAt(LocalDateTime.now());

        Comment savedComment =commentRepository.save(comment);
        post.getComments().add(savedComment);

        postRepository.save(post);

        return savedComment;
    }

    @Override
    public Comment findCommentById(Integer commentId) throws CommentException {
        Optional<Comment> opt=commentRepository.findById(commentId);
        if(opt.isEmpty()){
            throw new CommentException("Comment not exist");
        }
        return opt.get();
    }

    @Override
    public Comment likeComment(Integer commentId, Integer userId) throws CommentException, UserException {
        Comment comment=findCommentById(commentId);
        User user=userService.findUserById(userId);
        if(!comment.getLiked().contains(user)){
            comment.getLiked().add(user);
        }
        else {
            comment.getLiked().remove(user);
        }
        return commentRepository.save(comment);
    }
}
