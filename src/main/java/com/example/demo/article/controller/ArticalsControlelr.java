package com.example.demo.article.controller;

import com.example.demo.article.domain.ArticleEntity;
import com.example.demo.article.repository.ArticalsRepository;
import com.example.demo.article.service.ArticalsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class ArticalsControlelr {

    @Autowired
    private ArticalsRepository articalsRepository;

    private ArticalsService articalsService;

    public ArticalsControlelr(ArticalsService articalsService) {
        this.articalsService = articalsService;
    }

    @PostMapping("/articals")
    public ArticleEntity save (@RequestBody ArticleEntity articals){
        return articalsService.save(articals);
    }

    @GetMapping("/articals")
    public List<ArticleEntity> getalls (){
        return articalsRepository.findAll();
    }

}
