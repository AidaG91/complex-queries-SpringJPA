package com.femcoders.pildora.controller;

import com.femcoders.pildora.entity.Article;
import com.femcoders.pildora.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/articles")
public class ArticleController {

    private final ArticleService service;

    @GetMapping
    public List<Article> getAll() {
        return service.findAll();
    }

    @GetMapping("/search")
    public List<Article> search(

            @RequestParam(required = false)
            String status,

            @RequestParam(required = false)
            String category,

            @RequestParam(required = false)
            String author
    ) {
        return service.search(
                status,
                category,
                author
        );
    }
}