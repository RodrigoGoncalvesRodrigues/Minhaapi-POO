package com.SpringData.h2.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "tb_users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nome;
    private String email;
    @OneToMany(mappedBy = "user")
    private List<Post> posts = new ArrayList<>();

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User(long id, String nome, List<Post> posts, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.posts = posts;
    }
    public User(){

    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

