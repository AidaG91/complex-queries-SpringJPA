package com.femcoders.pildora.service;

import com.femcoders.pildora.entity.Article;
import com.femcoders.pildora.repository.ArticleRepository;
import com.femcoders.pildora.specification.ArticleSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository repository;

    public List<Article> search(
            String status,
            String category,
            String author
    ) {

        Specification<Article> spec =
                Specification.allOf();

        if (status != null && !status.isBlank()) {
            spec = spec.and(
                    ArticleSpecification.hasStatus(status)
            );
        }

        if (category != null && !category.isBlank()) {
            spec = spec.and(
                    ArticleSpecification.hasCategory(category)
            );
        }

        if (author != null && !author.isBlank()) {
            spec = spec.and(
                    ArticleSpecification.hasAuthor(author)
            );
        }

        return repository.findAll(spec);
    }

    public List<Article> findAll() {
        return repository.findAll();
    }
}