package com.SocialMedia.SocialMedia.controller;


import com.SocialMedia.SocialMedia.model.Comment;
import com.SocialMedia.SocialMedia.model.User;
import com.SocialMedia.SocialMedia.service.CommentService;
import com.SocialMedia.SocialMedia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;

    @PostMapping("/api/comments/post/{postId}")
    public Comment createComment(@RequestBody Comment comment, @RequestHeader("Authorization")String jwt, @PathVariable Integer postId) throws Exception {
        User user=userService.findUserByJwt(jwt);
        Comment comment1=commentService.createComment(comment,postId, user.getId());
        return comment1;
    }

    @PutMapping("/api/comments/like/{commentId}")
    public Comment likedComment( @RequestHeader("Authorization")String jwt, @PathVariable Integer commentId) throws Exception {
        User user=userService.findUserByJwt(jwt);
        Comment comment2=commentService.likeComment(commentId, user.getId());
        return comment2;
    }


}
