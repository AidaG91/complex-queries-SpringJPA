package com.femcoders.pildora.repository.specification;

import com.femcoders.pildora.entity.Article;
import org.springframework.data.jpa.domain.Specification;

public class ArticleSpecification {

    public static Specification<Article> hasStatus(String status) {
        return (root, query, cb) -> {
            if (status == null || status.isBlank()) return null;
            return cb.equal(root.get("status"), status);
        };
    }

    public static Specification<Article> hasCategory(String category) {
        return (root, query, cb) -> {
            if (category == null || category.isBlank()) return null;
            return cb.equal(root.get("category"), category);
        };
    }

    public static Specification<Article> hasAuthor(String author) {
        return (root, query, cb) -> {
            if (author == null || author.isBlank()) return null;
            return cb.equal(root.get("author"), author);
        };
    }
}
