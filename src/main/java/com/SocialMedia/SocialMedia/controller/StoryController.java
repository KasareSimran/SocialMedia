package com.SocialMedia.SocialMedia.controller;


import com.SocialMedia.SocialMedia.model.Reels;
import com.SocialMedia.SocialMedia.model.Story;
import com.SocialMedia.SocialMedia.model.User;
import com.SocialMedia.SocialMedia.service.StoryService;
import com.SocialMedia.SocialMedia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StoryController {

    @Autowired
    private StoryService storyService;

    @Autowired
    private UserService userService;

    @PostMapping("/api/story")
    public Story createStory(@RequestBody Story story, @RequestHeader("Authorization") String jwt){
        User reqUser=userService.findUserByJwt(jwt);
        Story createdStory=storyService.createStory(story,reqUser);
        return createdStory;
    }

    @GetMapping("/api/story/user/{userId}")
    public List<Story> findUserStory(@PathVariable Integer userId) throws Exception {
        List<Story> story=storyService.findStoryByUserId(userId);
        return story;
    }


}
