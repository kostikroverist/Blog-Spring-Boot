package com.example.demo.article.service.impl;

import com.example.demo.article.repository.ArticalsRepository;
import com.example.demo.article.domain.ArticleEntity;
import com.example.demo.article.domain.Color;
import com.example.demo.article.service.ArticalsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticalsServiceImpl implements ArticalsService {
    @Autowired
    private ArticalsRepository articalsCrud;


    @Override
    public ArticleEntity save(ArticleEntity articals) {
        return  articalsCrud.save(articals);
    }

    @Override
    public ArticleEntity findById(Long id) {
        return articalsCrud.getOne(id);
    }

    @Override
    public List<ArticleEntity> findByColor(Color color) {
        return articalsCrud.findAllByColor(color);
    }
}
