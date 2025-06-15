package com.SpringData.h2.service;

import com.SpringData.h2.Repository.PostRepository;
import com.SpringData.h2.Repository.UserRepository;
import com.SpringData.h2.dtos.users.response.UserPostResponseDTO;
import com.SpringData.h2.dtos.users.response.UserResponseDTO;
import com.SpringData.h2.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository UserRepository;
    private PostRepository postRepository;

    public UserService(UserRepository userRepository, PostRepository postRepository) {
        this.UserRepository = userRepository;

    }

    public User criarUser(User user){
        return this.UserRepository.save(user);
    }

    public void  alterarUser(Long id, User userRequest){
        User user = this.UserRepository.getReferenceById(id);
        user.setNome(userRequest.getNome());
        this.UserRepository.save(user);
    }

    public void excluirUser(Long id){
        User user = this.UserRepository.getReferenceById(id);
        this.UserRepository.delete(user);
    }

    public Page<UserResponseDTO> listarUsers(Pageable pageable){
        return this.UserRepository.findAll(pageable).map(
                user -> new UserResponseDTO(user.getNome(),user.getEmail(),user.getPosts().stream().map(
                        post -> new UserPostResponseDTO(post.getContent())).toList()
                ));
    }

    public User buscarUserPorId(Long id){
        return this.UserRepository.findById(id).orElseThrow();
    }
}

