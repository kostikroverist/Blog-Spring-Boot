package com.example.demo.article.service;


import com.example.demo.article.domain.ArticleEntity;
import com.example.demo.article.domain.Color;

import java.util.List;

public interface ArticalsService {

    ArticleEntity save (ArticleEntity articals);

    ArticleEntity findById(Long id);

    List<ArticleEntity> findByColor(Color color);
}
