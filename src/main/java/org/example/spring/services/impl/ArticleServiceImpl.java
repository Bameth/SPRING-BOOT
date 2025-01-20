package org.example.spring.services.impl;

import java.util.List;
import java.util.Optional;

import org.example.spring.data.entities.Article;
import org.example.spring.data.entities.Categorie;
import org.example.spring.data.repositories.ArticleRepository;
import org.example.spring.data.repositories.CategorieRepository;
import org.example.spring.services.ArticleService;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;
    private final CategorieRepository categorieRepository;

    @Override
    public Article create(Article articleRequest) {
        var category = categorieRepository.findById(articleRequest.getCategorie().getId()).orElse(null);
        if (category == null)
            return null;
        articleRequest.setCategorie(category);
        return articleRepository.save(articleRequest);
    }

    @Override
    public Article update(Long id, Article articleRequest) {
        Optional<Article> optionalData = articleRepository
                .findById(id);
        var category = categorieRepository.findById(articleRequest.getCategorie().getId()).orElse(null);
        if (optionalData.isPresent() && category != null) {
            if (optionalData.isPresent()) {
                var data = optionalData.get();
                data.setCode(articleRequest.getCode());
                data.setName(articleRequest.getName());
                data.setPrix(articleRequest.getPrix());
                data.setQteStock(articleRequest.getQteStock());
                data.setCategorie(category);
                return articleRepository.save(data);
            }
        }
        return null;
    }

    @Override
    public Article getById(Long id) {
        return articleRepository
                .findById(id)
                .orElse(null);
    }

    @Override
    public boolean delete(Long id) {
        Optional<Article> optionalData = articleRepository
                .findById(id);
        if (optionalData.isPresent()) {
            var data = optionalData.get();
            articleRepository.delete(data);
            return true;
        }
        return false;
    }

    @Override
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    @Override
    public List<Article> getAllArticlesByCategorie(Long categorieId) {
       var categorie=categorieRepository.findById(categorieId).orElse(null);
       if(categorie==null) return null;
       return articleRepository.findAllByCategorie(categorie);
    }

}
