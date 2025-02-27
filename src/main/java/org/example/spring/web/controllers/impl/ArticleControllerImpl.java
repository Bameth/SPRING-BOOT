package org.example.spring.web.controllers.impl;

import java.util.List;
import java.util.Map;

import org.example.spring.services.ArticleService;
import org.example.spring.utils.mappers.ArticleMapper;
import org.example.spring.web.controllers.ArticleController;
import org.example.spring.web.dto.RestResponse;
import org.example.spring.web.dto.request.ArticleCreateRequest;
import org.example.spring.web.dto.response.ArticleAllResponse;
import org.example.spring.web.dto.response.ArticleOneResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Tag(name = "Articles", description = "Gestion des articles")
public class ArticleControllerImpl implements ArticleController {
    private final ArticleService articleService;
    private final ArticleMapper articleMapper;

    @Override
    public ResponseEntity<List<ArticleAllResponse>> getAllArticles() {
        var articles = articleService.getAllArticles();
        var articleResponse = articles.stream()
                .map(articleMapper::toDto)
                .toList();
        return ResponseEntity.ok(articleResponse);
    }

    @Override
    public ResponseEntity<Map<String, Object>> getOne(Long id) {
        var article = articleService.getById(id);
        if (article == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(
                RestResponse.response(HttpStatus.OK, articleMapper.toDto2(article), "ArticleOneResponse"));
    }

    @Override
    public ResponseEntity<ArticleOneResponse> createArticle(@RequestBody ArticleCreateRequest request) {
        var article = articleService.create(articleMapper.toEntity(request));
        return new ResponseEntity<>(articleMapper.toDto2(article), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ArticleOneResponse> updateArticle(Long id, @RequestBody ArticleOneResponse request) {
        var article = articleService.update(id, articleMapper.toEntity(request));
        return ResponseEntity.accepted().body(articleMapper.toDto2(article));
    }

    @Override
    public ResponseEntity<String> deleteArticle(Long id) {
        var isDeleted = articleService.delete(id);
        return ResponseEntity.ok(isDeleted ? "Article deleted" : "Article not found");
    }
}
