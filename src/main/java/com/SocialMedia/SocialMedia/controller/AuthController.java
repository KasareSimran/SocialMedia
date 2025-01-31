package com.SocialMedia.SocialMedia.controller;

import com.SocialMedia.SocialMedia.config.JwtProvider;
import com.SocialMedia.SocialMedia.model.User;
import com.SocialMedia.SocialMedia.repository.UserRepository;
import com.SocialMedia.SocialMedia.request.LoginRequest;
import com.SocialMedia.SocialMedia.response.AuthResponse;
import com.SocialMedia.SocialMedia.service.CustomeUserDetailsService;
import com.SocialMedia.SocialMedia.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CustomeUserDetailsService customeUserDetailsService;

    @Transactional
    @PostMapping("/signup")
    public AuthResponse createUser(@RequestBody User user) throws Exception {

        User isExist = userRepository.findByEmail(user.getEmail());
        if(isExist != null ){
            throw new Exception("this email already used with another account");
        }

        User newUser =new User();
        newUser.setEmail(user.getEmail());
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        User savedUser = userRepository.save(newUser);
        Authentication authentication=new UsernamePasswordAuthenticationToken(savedUser.getEmail(),savedUser.getPassword());
        String token = JwtProvider.generateToken(authentication);

        AuthResponse res =new AuthResponse(token,"Resister Success");

        return res;
    }

    @PostMapping("/signin")
    public AuthResponse signin (@RequestBody  LoginRequest loginRequest){
        Authentication authentication=authenticate(loginRequest.getEmail(),loginRequest.getPassword());
        String token = JwtProvider.generateToken(authentication);

        AuthResponse res =new AuthResponse(token,"Login Success");

        return res;
    }

    private Authentication authenticate(String email, String password) {
        UserDetails userDetails=customeUserDetailsService.loadUserByUsername(email);
        if(userDetails==null){
            throw new BadCredentialsException("invalid username");
        }
        if(!passwordEncoder.matches(password,userDetails.getPassword())){
            throw new BadCredentialsException("password not matched");
        }
        return new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());

    }


}
