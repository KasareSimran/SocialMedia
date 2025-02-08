package com.SocialMedia.SocialMedia.controller;

import com.SocialMedia.SocialMedia.exceptions.ChatException;
import com.SocialMedia.SocialMedia.exceptions.MessageException;
import com.SocialMedia.SocialMedia.model.Message;
import com.SocialMedia.SocialMedia.model.User;
import com.SocialMedia.SocialMedia.service.MessageService;
import com.SocialMedia.SocialMedia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MessageController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private UserService userService;


    @PostMapping("/api/messages/chat/{chatId}")
    public Message createMessage(@PathVariable Integer chatId, @RequestBody Message req, @RequestHeader("Authorization") String jwt) throws MessageException, ChatException {
        User user=userService.findUserByJwt(jwt);
        Message message=messageService.createMessage(user,chatId,req);
        return message;
    }

    @GetMapping("/api/messages/chat/{chatId}")
    public List<Message> findChatsMessage(@PathVariable Integer chatId,  @RequestHeader("Authorization") String jwt) throws MessageException, ChatException {
        User user=userService.findUserByJwt(jwt);
        List<Message>messages=messageService.findChatsMessages(chatId);
        return messages;
    }

}
