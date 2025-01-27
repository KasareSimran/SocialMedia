package com.SocialMedia.SocialMedia.model;

import jakarta.persistence.*;

import lombok.Data;

import java.util.List;

@Entity
@Data
public class User {

    @Id
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String gender;
    private List<Integer> follower;
    private List<Integer> following;

    public User() {
    }

    public User(Integer id, String firstName, String lastName, String email, String password, String gender, List<Integer> follower, List<Integer> following) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.follower = follower;
        this.following = following;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<Integer> getFollower() {
        return follower;
    }

    public void setFollower(List<Integer> follower) {
        this.follower = follower;
    }

    public List<Integer> getFollowing() {
        return following;
    }

    public void setFollowing(List<Integer> following) {
        this.following = following;
    }
}
