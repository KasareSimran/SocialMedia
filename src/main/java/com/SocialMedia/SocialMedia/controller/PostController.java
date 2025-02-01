package com.SocialMedia.SocialMedia.controller;


import com.SocialMedia.SocialMedia.model.Post;
import com.SocialMedia.SocialMedia.model.User;
import com.SocialMedia.SocialMedia.response.ApiResponse;
import com.SocialMedia.SocialMedia.service.PostService;
import com.SocialMedia.SocialMedia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;


    @PostMapping("/api/posts")
    public ResponseEntity<Post> createPost(@RequestBody Post post,@RequestHeader("Authorization")String jwt) throws Exception {
        User reqUser=userService.findUserByJwt(jwt);

        Post createdPost=postService.createNewPost(post,reqUser.getId());
        return new ResponseEntity<>(createdPost, HttpStatus.ACCEPTED);
    }


    @DeleteMapping("/api/posts/{postId}")
    public ResponseEntity<ApiResponse> deletePost(@PathVariable Integer postId,@RequestHeader("Authorization")String jwt) throws Exception {
        User reqUser=userService.findUserByJwt(jwt);
        String msg=postService.deletePost(postId,reqUser.getId());
        ApiResponse res =new ApiResponse(msg,true);
        return new ResponseEntity<ApiResponse>(res,HttpStatus.OK);
    }


    @GetMapping("/api/posts/user/{userId}")
    public ResponseEntity<List<Post>> findUsersPost(@PathVariable Integer userId){
        List<Post> posts=postService.findPostByUserId(userId);
        return new ResponseEntity<List<Post>>(posts,HttpStatus.OK);

    }

    @GetMapping("/api/posts/{postId}")
    public ResponseEntity<Post> findPostByIdHandler(@PathVariable Integer postId) throws Exception {
        Post post = postService.findPostById(postId);
        return new ResponseEntity<>(post,HttpStatus.ACCEPTED);
    }

    @GetMapping("/api/posts")
    public ResponseEntity<List<Post>> findPosts(){
        List<Post> AllPosts=postService.findAllPost();
        return new ResponseEntity<List<Post>>(AllPosts,HttpStatus.OK);
    }



    @PutMapping("/api/posts/save/{postId}")
    public ResponseEntity<Post> savedPostHandler(@PathVariable Integer postId,@RequestHeader("Authorization")String jwt) throws Exception {
        User reqUser=userService.findUserByJwt(jwt);
        Post post = postService.savedPost(postId, reqUser.getId());
        return new ResponseEntity<>(post,HttpStatus.ACCEPTED);
    }



    @PutMapping("/api/posts/like/{postId}")
    public ResponseEntity<Post> likePostHandler(@PathVariable Integer postId,@RequestHeader("Authorization")String jwt) throws Exception {
        User reqUser=userService.findUserByJwt(jwt);
        Post post = postService.likePost(postId, reqUser.getId())   ;
        return new ResponseEntity<>(post,HttpStatus.ACCEPTED);
    }






}
