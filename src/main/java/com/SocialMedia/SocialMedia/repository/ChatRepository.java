package com.SocialMedia.SocialMedia.repository;

import com.SocialMedia.SocialMedia.model.Chat;
import com.SocialMedia.SocialMedia.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatRepository extends JpaRepository<Chat,Integer> {

    List<Chat> findByUsersId( Integer userId);

    @Query("select c from Chat c Where :user Member of c.users And :reqUser Member of c.users")
    Chat findChatByUsersId(@Param("user")User user,@Param("reqUser")User reqUser);
}
