package com.SocialMedia.SocialMedia.service;

import com.SocialMedia.SocialMedia.exceptions.StoryException;
import com.SocialMedia.SocialMedia.exceptions.UserException;
import com.SocialMedia.SocialMedia.model.Reels;
import com.SocialMedia.SocialMedia.model.Story;
import com.SocialMedia.SocialMedia.model.User;
import com.SocialMedia.SocialMedia.repository.StoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StoryServiceImplementation implements StoryService{
    @Autowired
    private StoryRepository storyRepository;

    @Autowired
    private UserService userService;

    @Override
    public Story createStory(Story story, User user) {
        Story createdStory=new Story();
        createdStory.setCaption(story.getCaption());
        createdStory.setImage(story.getImage());
        createdStory.setUser(user);
        createdStory.setTimeStamp(LocalDateTime.now());
        return storyRepository.save(createdStory);
    }

    @Override
    public List<Story> findStoryByUserId(Integer userId) throws StoryException, UserException {
        User user=userService.findUserById(userId);
        return storyRepository.findByUserId(userId);
    }

}
