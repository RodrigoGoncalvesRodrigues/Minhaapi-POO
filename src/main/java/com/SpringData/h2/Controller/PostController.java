package com.SpringData.h2.Controller;

import com.SpringData.h2.dtos.posts.requests.PostRequestDTO;
import com.SpringData.h2.dtos.posts.response.PostResponseDTO;
import com.SpringData.h2.model.Post;
import com.SpringData.h2.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;
    public PostController(PostService postService) {
        this.postService = postService;
    }
    @GetMapping
    public List<PostResponseDTO> getAllPosts(){
        return this.postService.getAllPosts();
    }
    @PostMapping
    public ResponseEntity<Post> criarNovoUsuario(@RequestBody PostRequestDTO postRequest) {
        Post post = this.postService.createPost(postRequest);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(post.getId()).toUri();
        return ResponseEntity.created(uri).body(post);
    }
}
