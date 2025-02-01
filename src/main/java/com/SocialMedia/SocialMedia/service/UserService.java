package com.SocialMedia.SocialMedia.service;

import com.SocialMedia.SocialMedia.model.User;

import java.util.List;

public interface UserService {

     User registerUser(User user);
     User findUserById(Integer userId) throws Exception;
     User findUserByEmail(String email);
     User followUser(Integer user1,Integer user2) throws Exception;
     User updateUser(User user,Integer userId) throws Exception;
     List<User> searchUser(String query);
     User findUserByJwt(String jwt);

}
