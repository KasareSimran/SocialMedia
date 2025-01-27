package com.SocialMedia.SocialMedia.service;

import com.SocialMedia.SocialMedia.model.Post;
import com.SocialMedia.SocialMedia.model.User;
import com.SocialMedia.SocialMedia.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class PostServiceImplementation implements PostService{

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserService userService;



    @Override
    public Post createNewPost(Post post, Integer userId) throws Exception {

        Post newPost=new Post();
        newPost.setCaption(post.getCaption());
        newPost.setImage(post.getImage());
        newPost.setVideo(post.getVideo());

        User user = userService.findUserById(userId);
        newPost.setUser(user);
        return null;
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
        return postRepository.findPostByUserId(userId);
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
    public Post savedPost(Integer postId, Integer userId) {
        return null;
    }

    @Override
    public Post likePost(Integer postId, Integer userId) {
        return null;
    }
}
