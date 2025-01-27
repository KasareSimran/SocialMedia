package com.SocialMedia.SocialMedia.service;

import com.SocialMedia.SocialMedia.model.Post;
import com.SocialMedia.SocialMedia.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class PostServiceImplementation implements PostService{

    @Autowired
    private PostRepository postRepository;

    @Override
    public Post createNewPost(Post post, Integer userId) {
        return null;
    }

    @Override
    public String deletePost(Integer postId, Integer userId) {
        return null;
    }

    @Override
    public List<Post> findPostByUserId(Integer userId) {
        return null;
    }

    @Override
    public Post findPostById(Integer postId) {
        return null;
    }

    @Override
    public List<Post> findAllPost() {
        return null;
    }

    @Override
    public Post savedPost(Integer postId, Integer userId) {
        return null;
    }

    @Override
    public Post likePost(Integer postId, Integer userId) {
        return null;
    }
}
