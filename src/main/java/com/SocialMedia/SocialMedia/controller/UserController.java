package com.SocialMedia.SocialMedia.controller;


import com.SocialMedia.SocialMedia.model.User;
import com.SocialMedia.SocialMedia.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getUsers(){

        List<User> users=userRepository.findAll();
        return users;
    }

    @GetMapping("/users/{userId}")
    public User getUserById(@PathVariable("userId")Integer id) throws Exception {
        Optional <User> user = userRepository.findById(id);
        if(user.isPresent()){
            return user.get();
        }
        throw new Exception("invalid user id");
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user){
        User newUser =new User();
        newUser.setEmail(user.getEmail());
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setPassword(user.getPassword());
        newUser.setId(user.getId());

        User savedUser = userRepository.save(newUser);

        return savedUser;
    }


    @PutMapping("/users/{userId}")
    public User updateUser(@RequestBody User user,@PathVariable Integer userId) throws Exception {
        Optional <User> user1=userRepository.findById(userId);

        if(user1.isEmpty()){
            throw new Exception("invalid user");
        }

        User oldUser = user1.get();

        if(user.getFirstName()!= null){
            oldUser.setFirstName(user.getFirstName());
        }

        if(user.getLastName()!= null){
            oldUser.setLastName(user.getLastName());
        }

        if(user.getEmail()!= null){
            oldUser.setEmail(user.getEmail());
        }


        User updateUser =userRepository.save(oldUser);
        return updateUser;
    }



    @DeleteMapping("/users/{userId}")
    public String deleteUser(@PathVariable("userId") Integer userId) throws Exception {
        Optional <User> user1=userRepository.findById(userId);

        if(user1.isEmpty()){
            throw new Exception("invalid user");
        }
        userRepository.delete(user1.get());

        return "user get deleted with id "+userId;
    }

}
