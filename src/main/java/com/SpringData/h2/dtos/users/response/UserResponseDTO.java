package com.SpringData.h2.dtos.users.response;

import java.util.List;

public class UserResponseDTO {
    private String name;
    private String email;
    List<UserPostResponseDTO>posts;

    public UserResponseDTO(String name, String email,List<UserPostResponseDTO> posts) {
        this.name = name;
        this.posts = posts;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<UserPostResponseDTO> getPosts() {
        return posts;
    }

    public void setPosts(List<UserPostResponseDTO> posts) {
        this.posts = posts;
    }
}
