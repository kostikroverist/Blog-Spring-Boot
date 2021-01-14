package com.example.demo.user.service;

import com.example.demo.user.domain.UserEntity;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public interface UserService {

     List<UserEntity> getAll();

     List<UserEntity> findOlderUser(int age);

    List<UserEntity> findByName(String name);

    List<UserEntity> save(Collection<UserEntity> users);

    List<String> findMoreThreeArticles();

   List<UserEntity> findByColor( String color );

    default UserEntity save(UserEntity user) {
        return save(Collections.singleton(user)).get(0);
    }
}
