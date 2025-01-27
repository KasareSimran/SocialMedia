package com.SocialMedia.SocialMedia.controller;


import com.SocialMedia.SocialMedia.model.User;
import com.SocialMedia.SocialMedia.repository.UserRepository;
import com.SocialMedia.SocialMedia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getUsers(){

        List<User> users=userRepository.findAll();
        return users;
    }

    @GetMapping("/users/{userId}")
    public User getUserById(@PathVariable("userId")Integer userId) throws Exception {
        User getUserById =userService.findUserById(userId);
        return getUserById ;
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user){

        User savedUser =userService.registerUser(user);
        return savedUser;
    }


    @PutMapping("/users/{userId}")
    public User updateUser(@RequestBody User user,@PathVariable Integer userId) throws Exception {
        User updateUser =userService.updateUser( user,userId);
        return updateUser ;
    }


    @PutMapping("/users/{userId1}/{userId2}")
    public User followUser(@PathVariable Integer userId1 , @PathVariable Integer userId2) throws Exception {

        User user = userService.followUser(userId1, userId2);
        return user;
    }


    @GetMapping("/users/search")
    public List<User> searchUser(@RequestParam("query") String query){
        List<User> users=userService.searchUser(query);
        return users;
    }


//    @DeleteMapping("/users/{userId}")
//    public String deleteUser(@PathVariable("userId") Integer userId) throws Exception {
//        Optional <User> user1=userRepository.findById(userId);
//
//        if(user1.isEmpty()){
//            throw new Exception("invalid user");
//        }
//        userRepository.delete(user1.get());
//
//        return "user get deleted with id "+userId;
//    }

}
