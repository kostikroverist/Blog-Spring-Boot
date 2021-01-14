package com.example.demo.article.domain;


import com.example.demo.user.domain.UserEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity(name = "articles")
public class ArticleEntity {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private Long id;
    @Column
    private String text;

    @Enumerated(EnumType.STRING)
    private Color color;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "users_id")
    private UserEntity users;


    public ArticleEntity() {
    }

    public ArticleEntity(String text, Color color, UserEntity users) {
        this.text = text;
        this.color = color;
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public UserEntity getUsers() {
        return users;
    }

    public void setUsers(UserEntity users) {
        this.users = users;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
