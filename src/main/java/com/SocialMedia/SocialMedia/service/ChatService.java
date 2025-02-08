package com.SocialMedia.SocialMedia.service;

import com.SocialMedia.SocialMedia.exceptions.ChatException;
import com.SocialMedia.SocialMedia.model.Chat;
import com.SocialMedia.SocialMedia.model.User;

import java.util.List;

public interface ChatService {

    Chat createChat(User reqUser,User user2);
    Chat findChatById(Integer chatId) throws ChatException;
    List<Chat> findUsersChat(Integer userId);
}
