package com.SocialMedia.SocialMedia.service;

import com.SocialMedia.SocialMedia.model.Chat;
import com.SocialMedia.SocialMedia.model.Message;
import com.SocialMedia.SocialMedia.model.User;

import java.util.List;

public interface MessageService {

    Message createMessage(User user, Integer chatId, Message req) throws Exception;
    List<Message> findChatsMessages(Integer chatId) throws Exception;
}
