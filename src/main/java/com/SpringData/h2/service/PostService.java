package com.SpringData.h2.service;

import com.SpringData.h2.Repository.PostRepository;
import com.SpringData.h2.Repository.UserRepository;
import com.SpringData.h2.dtos.posts.requests.PostRequestDTO;
import com.SpringData.h2.dtos.posts.response.PostResponseDTO;
import com.SpringData.h2.dtos.posts.response.PostUserResponseDTO;
import com.SpringData.h2.model.Post;
import com.SpringData.h2.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private  final PostRepository postRepository;
    private  final UserRepository userRepository;
    public PostService(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }
    public Post createPost(PostRequestDTO postRequest){
        User user = userRepository.findById(postRequest.getUserId()).orElseThrow();
        Post post = new Post();
        post.setContent(postRequest.getContent());
        post.setUser(user);
        return this.postRepository.save(post);
    }
    public List<PostResponseDTO> getAllPosts(){
        return this.postRepository.findAll()
                .stream()
                .map(item ->
                        new PostResponseDTO(item.getId(),item.getContent(),
                                new PostUserResponseDTO(item.getUser().getNome(),item.getUser().getEmail()))).toList();
    }
}
