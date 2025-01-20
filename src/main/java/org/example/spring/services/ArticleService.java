package org.example.spring.services;

import java.util.List;

import org.example.spring.data.entities.Article;

public interface ArticleService {
    Article create(Article articleRequest);

    Article update(Long id, Article articleRequest);

    Article getById(Long id);

    boolean delete(Long id);

    List<Article> getAllArticles();

    List<Article> getAllArticlesByCategorie(Long categorieId);
}
