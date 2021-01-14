package com.example.demo;

import com.example.demo.article.repository.ArticalsRepository;
import com.example.demo.article.domain.ArticleEntity;
import com.example.demo.article.domain.Color;
import com.example.demo.user.domain.UserEntity;
import com.example.demo.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DBInitializer implements ApplicationListener<ContextRefreshedEvent> {

    int countOfArticle = 1;

    private final UserRepository userRepository;
    private final ArticalsRepository articalsRepository;

    @Autowired
    public DBInitializer(UserRepository userRepository, ArticalsRepository articalsRepository) {
        this.userRepository = userRepository;
        this.articalsRepository = articalsRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        userRepository.deleteAll();
        articalsRepository.deleteAll();

        List<UserEntity> users = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            users.add(createUniqueUser(i));
            countOfArticle++;
        }
        userRepository.saveAll(users);

    }

    private UserEntity createUniqueUser(int index) {
        UserEntity user = new UserEntity("Kostya" + index,20 + index);


        List<ArticleEntity> arrayList = new ArrayList<>();

        for (int i = 0; i < this.countOfArticle; i++) {
            arrayList.add(createArticle(i,user));
        }


        user.setArticles(arrayList);

        return user;
    }

    private static ArticleEntity createArticle(int index, UserEntity user) {

        return new ArticleEntity("Article " + index, Color.BLUE, user);
    }
}
