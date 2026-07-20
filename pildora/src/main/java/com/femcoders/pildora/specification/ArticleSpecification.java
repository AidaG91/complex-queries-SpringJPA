package com.femcoders.pildora.specification;

import com.femcoders.pildora.entity.Article;
import org.springframework.data.jpa.domain.Specification;

public class ArticleSpecification {

    public static Specification<Article> hasStatus(String status) {

        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(
                        root.get("status"),
                        status
                );
    }

    public static Specification<Article> hasCategory(String category) {

        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(
                        root.get("category"),
                        category
                );
    }

    public static Specification<Article> hasAuthor(String author) {

        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(
                        root.get("author"),
                        author
                );
    }
}
