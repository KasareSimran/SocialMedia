package com.SocialMedia.SocialMedia.service;

import com.SocialMedia.SocialMedia.config.JwtProvider;
import com.SocialMedia.SocialMedia.exceptions.UserException;
import com.SocialMedia.SocialMedia.model.User;
import com.SocialMedia.SocialMedia.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    @Transactional
    public User registerUser(User user) {
        User newUser =new User();
        newUser.setEmail(user.getEmail());
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setPassword(user.getPassword());
        User savedUser = userRepository.save(newUser);

        return savedUser;

    }

    @Override
    public User findUserById(Integer userId) throws UserException {
        Optional<User> user = userRepository.findById(userId);
        if(user.isPresent()){
            return user.get();
        }
        throw new UserException("invalid user id");
    }

    @Override
    public User findUserByEmail(String email) {
        User user =userRepository.findByEmail(email);
        return user;
    }

    @Override
    public User followUser(Integer reqUserId, Integer userId2) throws UserException {

        User reqUser = findUserById(reqUserId);
        User user2= findUserById(userId2);

        user2.getFollower().add(reqUser.getId());
        reqUser.getFollowing().add(user2.getId());

        userRepository.save(reqUser);
        userRepository.save(user2);

        return reqUser;
    }

    @Override
    @Transactional
    public User updateUser(User user,Integer userId) throws UserException {
        Optional <User> user1=userRepository.findById(userId);

        if(user1.isEmpty()){
            throw new UserException("invalid user");
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

        if(user.getGender()!= null){
            oldUser.setGender(user.getGender());
        }

        User updateUser =userRepository.save(oldUser);
        return updateUser;
    }

    @Override
    public List<User> searchUser(String query) {
        return userRepository.searchUser(query);
    }

    @Override
    public User findUserByJwt(String jwt) {
            String email= JwtProvider.getEmailFromJwtToken(jwt);
            User user=userRepository.findByEmail(email);

        return user;
    }
}
