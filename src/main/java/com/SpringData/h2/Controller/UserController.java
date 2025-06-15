package com.SpringData.h2.Controller;

import com.SpringData.h2.dtos.users.response.UserResponseDTO;
import com.SpringData.h2.model.User;
import com.SpringData.h2.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;


@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> criarUser(@RequestBody User userRequest) {
        User user = this.userService.criarUser(userRequest);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizarUser(@PathVariable Long id, @RequestBody User userRequest) {
        this.userService.alterarUser(id, userRequest);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<Page<UserResponseDTO>> listarUsers(Pageable pageable) {
        return ResponseEntity.ok().body(this.userService.listarUsers(pageable));
    }


    @GetMapping("/{id}")
    public ResponseEntity<User> listarUserPorId(@PathVariable Long id) {
        return ResponseEntity.ok().body(this.userService.buscarUserPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deletarUser(@PathVariable Long id) {
        this.userService.excluirUser(id);
        return ResponseEntity.ok().build();
    }
}


