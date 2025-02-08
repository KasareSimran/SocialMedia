package com.SocialMedia.SocialMedia.service;

import com.SocialMedia.SocialMedia.exceptions.UserException;
import com.SocialMedia.SocialMedia.model.User;

import java.util.List;

public interface UserService {

     User registerUser(User user);
     User findUserById(Integer userId) throws UserException;
     User findUserByEmail(String email);
     User followUser(Integer user1,Integer user2) throws UserException;
     User updateUser(User user,Integer userId) throws UserException;
     List<User> searchUser(String query);
     User findUserByJwt(String jwt);

}
