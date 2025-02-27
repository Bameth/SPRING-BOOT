package org.example.spring.web.controllers;

import java.util.List;
import java.util.Map;

import org.example.spring.web.dto.request.ArticleCreateRequest;
import org.example.spring.web.dto.response.ArticleAllResponse;
import org.example.spring.web.dto.response.ArticleOneResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RequestMapping("/article")
public interface ArticleController {
    @GetMapping("/list")
    ResponseEntity<List<ArticleAllResponse>> getAllArticles();

    @GetMapping("/one/{id}")
    @Operation(summary = "Récuperation d'une Article par son Id", description = "Retourne un article ainsi que sa catégorie")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Article trouvé"),
            @ApiResponse(responseCode = "404", description = "Article non trouvé")
    })
    ResponseEntity<Map<String, Object>> getOne(
            @Parameter(description = "Id de l'article", required = true) @PathVariable() Long id);

    @PostMapping("/create")
    ResponseEntity<ArticleOneResponse> createArticle(@RequestBody() ArticleCreateRequest article);

    @PutMapping("/update/{id}")
    ResponseEntity<ArticleOneResponse> updateArticle(@PathVariable() Long id,
            @RequestBody() ArticleOneResponse article);

    @DeleteMapping("/delete/{id}")
    ResponseEntity<String> deleteArticle(@PathVariable() Long id);
}
