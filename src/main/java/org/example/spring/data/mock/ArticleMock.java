package org.example.spring.data.mock;

import java.util.ArrayList;
import java.util.List;

import org.example.spring.data.entities.Article;
import org.example.spring.data.entities.Categorie;
import org.example.spring.data.repositories.ArticleRepository;
import org.example.spring.data.repositories.CategorieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
@Order(2)
public class ArticleMock implements CommandLineRunner {
    private final ArticleRepository articleRepository;
    private final CategorieRepository categorieRepository;

    @Override
    public void run(String... args) throws Exception {
        var categories = categorieRepository.findAll();
        List<Article> articles = new ArrayList<Article>();
        for (Categorie categorie : categories) {
            for (int i = 1; i < 5; i++) {
                Article article = new Article();
                article.setCode("code"+categorie.getNom() + i);
                article.setName("name"+categorie.getNom() + i);
                article.setPrix(10000.0 * i);
                article.setQteStock(5 * i);
                article.setCategorie(categorie);
                articles.add(article);
            }
        }
        articleRepository.saveAllAndFlush(articles);
    }
}
