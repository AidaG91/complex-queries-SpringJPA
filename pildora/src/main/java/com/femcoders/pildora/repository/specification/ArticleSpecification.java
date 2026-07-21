package com.femcoders.pildora.repository.specification;

import com.femcoders.pildora.entity.Article;
import org.springframework.data.jpa.domain.Specification;

public class ArticleSpecification {

    public static Specification<Article> hasStatus(String status) {
        return (root, query, cb) -> cb.equal(root.get("status"), status);
    }

    public static Specification<Article> hasCategory(String category) {
        return (root, query, cb) -> cb.equal(root.get("category"), category);
    }

    public static Specification<Article> hasAuthor(String author) {
        return (root, query, cb) -> cb.equal(root.get("author"), author);
    }

    public static Specification<Article> build(String status, String category, String author) {
        Specification<Article> spec = Specification.allOf();

        if (status != null) {
            spec = spec.and(hasStatus(status));
        }

        if (category != null) {
            spec = spec.and(hasCategory(category));
        }

        if (author != null) {
            spec = spec.and(hasAuthor(author));
        }

        return spec;
    }
}
