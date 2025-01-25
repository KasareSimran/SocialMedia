package com.SocialMedia.SocialMedia.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping
    public String home(){
        return "this is home controller";
    }

    @GetMapping("/home")
    public String home2(){
        return "this is home controller2";
    }
}
