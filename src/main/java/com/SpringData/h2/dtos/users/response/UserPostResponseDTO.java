package com.SpringData.h2.dtos.users.response;

public class UserPostResponseDTO {
    private String content;

    public UserPostResponseDTO(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
