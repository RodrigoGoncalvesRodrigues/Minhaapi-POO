package com.SpringData.h2.dtos.posts.response;

public class PostResponseDTO {
    private Long id;
    private String content;
    private PostUserResponseDTO user;



    public PostResponseDTO(Long id, String content, PostUserResponseDTO user) {
        this.content = content;
        this.user = user;
        this.id = id;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public PostUserResponseDTO getUser() {
        return user;
    }

    public void setUser(PostUserResponseDTO user) {
        this.user = user;
    }
}
