package org.example.spring.data.repositories;

import java.util.List;

import org.example.spring.data.entities.Article;
import org.example.spring.data.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findAllByCategorie(Categorie categorie);
}
