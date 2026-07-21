package com.femcoders.pildora.service;

import com.femcoders.pildora.entity.Article;
import com.femcoders.pildora.repository.ArticleRepository;
import com.femcoders.pildora.repository.specification.ArticleSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;

    public List<Article> search(String status, String category, String author) {
        SSpecification<Article> spec =
                ArticleSpecification.hasStatus(status)
                        .and(ArticleSpecification.hasCategory(category))
                        .and(ArticleSpecification.hasAuthor(author));

        return articleRepository.findAll(spec);
    }
}
