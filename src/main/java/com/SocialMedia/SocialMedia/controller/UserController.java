package com.SocialMedia.SocialMedia.controller;


import com.SocialMedia.SocialMedia.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @GetMapping("/users")
    public List<User> getUsers(){
        List<User> users =new ArrayList<>();
        User user1 =new User(1,"Simran","Kasare","simrankasare5@gmail.com","1234");
        users.add(user1);
        return users;
    }

}
