package com.SocialMedia.SocialMedia.controller;


import com.SocialMedia.SocialMedia.exceptions.UserException;
import com.SocialMedia.SocialMedia.model.User;
import com.SocialMedia.SocialMedia.repository.UserRepository;
import com.SocialMedia.SocialMedia.service.UserService;
import jakarta.transaction.Transactional;
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

    @GetMapping("/api/users")
    public List<User> getUsers(){

        List<User> users=userRepository.findAll();
        return users;
    }

    @GetMapping("/api/users/{userId}")
    public User getUserById(@PathVariable("userId")Integer userId) throws UserException {
        User getUserById =userService.findUserById(userId);
        return getUserById ;
    }




    @PutMapping("/api/users")
    public User updateUser(@RequestBody User user,@RequestHeader("Authorization")String jwt) throws UserException {
        User reqUser=userService.findUserByJwt(jwt);
        User updateUser =userService.updateUser( user,reqUser.getId());
        return updateUser ;
    }


    @PutMapping("/api/users/follow/{userId2}")
    public User followUser( @RequestHeader("Authorization")String jwt,@PathVariable Integer userId2) throws UserException {
        User reqUser=userService.findUserByJwt(jwt);

        User user = userService.followUser(reqUser.getId(), userId2);
        return user;
    }


    @GetMapping("/api/users/search")
    public List<User> searchUser(@RequestParam("query") String query){
        List<User> users=userService.searchUser(query);
        return users;
    }


    @GetMapping("/api/users/profile")
    public  User getUserByToken(@RequestHeader("Authorization")String jwt){

//        System.out.println("jwt----"+jwt);
        User user=userService.findUserByJwt(jwt);
        user.setPassword(null);
        return user;

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
