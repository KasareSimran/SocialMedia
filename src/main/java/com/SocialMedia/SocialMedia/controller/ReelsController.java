package com.SocialMedia.SocialMedia.controller;

import com.SocialMedia.SocialMedia.model.Reels;
import com.SocialMedia.SocialMedia.model.User;
import com.SocialMedia.SocialMedia.service.ReelsService;
import com.SocialMedia.SocialMedia.service.UserService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReelsController {

    @Autowired
    private ReelsService reelsService;

    @Autowired
    private UserService userService;


    @PostMapping("/api/reels")
    public Reels createreels(@RequestBody Reels reel, @RequestHeader("Authorization") String jwt){

        User reqUser=userService.findUserByJwt(jwt);
        Reels createdReels=reelsService.createReel(reel,reqUser);
        return createdReels;
    }

    @GetMapping("/api/reels")
    public List<Reels> findAllReels(){
       List<Reels> reels=reelsService.findAllReels();
        return reels;
    }


    @GetMapping("/api/reels/user/{userId}")
    public List<Reels> findUserReels(@PathVariable Integer userId) throws Exception {
        List<Reels> reels=reelsService.findUserReel(userId);
        return reels;
    }



}
