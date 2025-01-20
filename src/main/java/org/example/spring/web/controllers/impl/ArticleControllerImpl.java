package org.example.spring.web.controllers.impl;

import java.util.List;

import org.example.spring.data.entities.Article;
import org.example.spring.services.ArticleService;
import org.example.spring.web.controllers.ArticleController;
import org.example.spring.web.dto.request.ArticleCreateRequest;
import org.example.spring.web.dto.response.ArticleAllResponse;
import org.example.spring.web.dto.response.ArticleOneResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ArticleControllerImpl implements ArticleController {
    private final ArticleService articleService;

    @Override
    public ResponseEntity<List<ArticleAllResponse>> getAllArticles() {
        var articles = articleService.getAllArticles();
        var articleResponse=articles.stream().map(entity -> new ArticleAllResponse(entity))
                .toList();
        return new ResponseEntity<>(articleResponse,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ArticleOneResponse> getOne(Long id) {
       var article = articleService.getById(id);
       return new ResponseEntity<>(new ArticleOneResponse(article),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ArticleOneResponse> createArticle(@RequestBody() ArticleCreateRequest article) {
       var articles = articleService.create(article.toEntity());
       return new ResponseEntity<>(new ArticleOneResponse(articles),HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Article> updateArticle(Long id, @RequestBody() Article article) {
        var articles = articleService.update(id, article);
        return new ResponseEntity<>(articles,HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<String> deleteArticle(Long id) {
        var isDeleted = articleService.delete(id);
       return new ResponseEntity<>(isDeleted ? "Article deleted" : "Article not found",HttpStatus.OK);
    }

}
