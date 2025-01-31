package com.SocialMedia.SocialMedia.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class AppConfig {

    SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{

        http.authorizeHttpRequests(Authorize -> Authorize
                .requestMatchers("api/**").authenticated()
                .anyRequest().permitAll())
                .csrf(csrf -> csrf.disable());

        return http.build();
    }

}
