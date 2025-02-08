package com.SocialMedia.SocialMedia.service;

import com.SocialMedia.SocialMedia.exceptions.ChatException;
import com.SocialMedia.SocialMedia.exceptions.MessageException;
import com.SocialMedia.SocialMedia.model.Chat;
import com.SocialMedia.SocialMedia.model.Message;
import com.SocialMedia.SocialMedia.model.User;
import com.SocialMedia.SocialMedia.repository.ChatRepository;
import com.SocialMedia.SocialMedia.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessageServiceImplementation implements MessageService{
    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private ChatService chatService;

    @Autowired
    private ChatRepository chatRepository;


    @Override
    public Message createMessage(User user, Integer chatId, Message req) throws MessageException, ChatException {
        Message message=new Message();

        Chat chat=chatService.findChatById(chatId);

        message.setChat(chat);
        message.setContent(req.getContent());
        message.setImage(req.getImage());
        message.setUser(user);
        message.setTimestamp(LocalDateTime.now());
        Message savedMessage=messageRepository.save(message);
        chat.getMessages().add(savedMessage);
        chatRepository.save(chat);
        return savedMessage;
    }

    @Override
    public List<Message> findChatsMessages(Integer chatId) throws MessageException, ChatException {
        Chat chat=chatService.findChatById(chatId);
        return messageRepository.findByChatId(chatId);
    }
}
