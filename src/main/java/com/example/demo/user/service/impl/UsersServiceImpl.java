package com.example.demo.user.service.impl;

import com.example.demo.article.service.ArticalsService;
import com.example.demo.article.domain.ArticleEntity;
import com.example.demo.article.domain.Color;
import com.example.demo.user.repository.UserRepository;
import com.example.demo.user.domain.UserEntity;
import com.example.demo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class UsersServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Autowired
    private ArticalsService articalsService;

    @Autowired
    public UsersServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserEntity> save(Collection<UserEntity> users) {
        return userRepository.saveAll(users);
    }

    @Override
    public List<String> findMoreThreeArticles() {
        return userRepository.findUniqueNamesWhereArticlesMoreThan(3);
    }

    @Override
    public List<UserEntity> findByColor(String color) {
        try {
            Color value = Color.valueOf(color.toUpperCase());
            List<ArticleEntity> byColor = articalsService.findByColor(value);
            return userRepository.findAllByArticlesIn(byColor);

        }catch (IllegalArgumentException e){
            e.printStackTrace();
            return Collections.EMPTY_LIST;
        }



    }

    @Override
    public List<UserEntity> getAll() {
         return userRepository.findAll();
    }

    @Override
    public List<UserEntity> findOlderUser(int age) {
        return userRepository.findAllOlderThan(age);
    }

    @Override
    public List<UserEntity> findByName(String name) {
        UserEntity user = new UserEntity();
        user.setName(name);

        return userRepository.findAll(Example.of(user));
    }
}
