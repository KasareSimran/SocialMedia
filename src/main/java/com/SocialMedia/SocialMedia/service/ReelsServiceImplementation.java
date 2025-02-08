package com.SocialMedia.SocialMedia.service;

import com.SocialMedia.SocialMedia.exceptions.ReelsException;
import com.SocialMedia.SocialMedia.exceptions.UserException;
import com.SocialMedia.SocialMedia.model.Reels;
import com.SocialMedia.SocialMedia.model.User;
import com.SocialMedia.SocialMedia.repository.ReelsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReelsServiceImplementation implements ReelsService{

    @Autowired
    private ReelsRepository reelsRepository;

    @Autowired
    private UserService userService;


    @Override
    public Reels createReel(Reels reel, User user) {
        Reels createReel=new Reels();
        createReel.setTitle(reel.getTitle());
        createReel.setUser(user);
        createReel.setVideo(reel.getVideo());
        return reelsRepository.save(createReel);
    }

    @Override
    public List<Reels> findAllReels() {
        return reelsRepository.findAll();
    }

    @Override
    public List<Reels> findUserReel(Integer userId) throws ReelsException, UserException {
        userService.findUserById(userId);
        return reelsRepository.findByUserId(userId);
    }
}
