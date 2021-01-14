package com.example.demo.article.repository;

import com.example.demo.article.domain.ArticleEntity;
import com.example.demo.article.domain.Color;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticalsRepository extends JpaRepository<ArticleEntity,Long> {

    List<ArticleEntity>findAllByColor(Color color);
}
