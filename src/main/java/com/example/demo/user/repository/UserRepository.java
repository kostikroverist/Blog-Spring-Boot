package com.example.demo.user.repository;


import com.example.demo.article.domain.ArticleEntity;
import com.example.demo.user.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @Query("SELECT u FROM users u WHERE u.age > ?1")
    List<UserEntity> findAllOlderThan(int age);

    @Query("SELECT DISTINCT u.name FROM users u WHERE u.articles.size > ?1")
    List<String> findUniqueNamesWhereArticlesMoreThan(int articlesNumber);


    List<UserEntity> findAllByArticlesIn(List<ArticleEntity> entity);


}
