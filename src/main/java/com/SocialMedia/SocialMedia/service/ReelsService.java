package com.SocialMedia.SocialMedia.service;

import com.SocialMedia.SocialMedia.exceptions.ReelsException;
import com.SocialMedia.SocialMedia.exceptions.UserException;
import com.SocialMedia.SocialMedia.model.Reels;
import com.SocialMedia.SocialMedia.model.User;

import java.util.List;

public interface ReelsService {

     Reels createReel(Reels reel, User user);
     List<Reels> findAllReels();
     List<Reels> findUserReel(Integer userId) throws ReelsException, UserException;
}
