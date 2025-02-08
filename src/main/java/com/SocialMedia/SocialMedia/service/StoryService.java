package com.SocialMedia.SocialMedia.service;


import com.SocialMedia.SocialMedia.exceptions.StoryException;
import com.SocialMedia.SocialMedia.exceptions.UserException;
import com.SocialMedia.SocialMedia.model.Story;
import com.SocialMedia.SocialMedia.model.User;

import java.util.List;

public interface StoryService {

    Story createStory(Story story, User user);
    List<Story> findStoryByUserId(Integer userId) throws StoryException, UserException;
}
