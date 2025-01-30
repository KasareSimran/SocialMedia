package com.SocialMedia.SocialMedia.service;

import com.SocialMedia.SocialMedia.model.Post;
import com.SocialMedia.SocialMedia.model.User;
import com.SocialMedia.SocialMedia.repository.PostRepository;
import com.SocialMedia.SocialMedia.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class PostServiceImplementation implements PostService{

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;



    @Override
    public Post createNewPost(Post post, Integer userId) throws Exception {
        User user = userService.findUserById(userId);
        Post newPost=new Post();
        newPost.setCaption(post.getCaption());
        newPost.setImage(post.getImage());
        newPost.setVideo(post.getVideo());
        newPost.setCreatedAt(LocalDateTime.now());
        newPost.setUser(user);
        return postRepository.save(newPost);
    }

    @Override
    public String deletePost(Integer postId, Integer userId) throws Exception {

        Post post =findPostById(postId);
        User user =userService.findUserById(userId);

        if(post.getUser().getId() != user.getId()){
            throw new Exception("You dont have access to others account");
        }

        postRepository.delete(post);
        return "Successfully deleted post";
    }

    @Override
    public List<Post> findPostByUserId(Integer userId) {
        List<Post> posts= postRepository.findPostByUserId(userId);
        return posts;

    }

    @Override
    public Post findPostById(Integer postId) throws Exception {

        Optional<Post> opt=postRepository.findById(postId);
        if(opt.isEmpty()){
            throw new Exception("Post not found");
        }
        return opt.get();
    }


    @Override
    public List<Post> findAllPost() {
        return postRepository.findAll();
    }

    @Override
    public Post savedPost(Integer postId, Integer userId) throws Exception {
        Post post =findPostById(postId);
        User user =userService.findUserById(userId);

        //like button add and remove
        if(user.getSavedPost().contains(post)){
            user.getSavedPost().remove(post);
        }
        else{
            user.getSavedPost().add(post);
        }
        userRepository.save(user);
        return post;
    }

    @Override
    public Post likePost(Integer postId, Integer userId) throws Exception {
        Post post =findPostById(postId);
        User user =userService.findUserById(userId);

        //like button add and remove
        if(post.getLiked().contains(user)){
            post.getLiked().remove(user);
        }
        else{
            post.getLiked().add(user);
        }

        return postRepository.save(post);
    }
}
