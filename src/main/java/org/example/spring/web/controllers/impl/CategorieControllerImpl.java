package org.example.spring.web.controllers.impl;

import lombok.RequiredArgsConstructor;
import org.example.spring.data.entities.Categorie;
import org.example.spring.services.ArticleService;
import org.example.spring.services.CategorieService;
import org.example.spring.web.controllers.CategorieController;
import org.example.spring.web.dto.response.ArticleAllResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CategorieControllerImpl implements CategorieController {
    private final CategorieService categorieService;
    private final ArticleService articleService;

    @Override
    public ResponseEntity<List<Categorie>> getAllCategories() {
        var categories = categorieService.getAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Categorie> getOne(Long id) {
        var categorie = categorieService.getById(id);
        return new ResponseEntity<>(categorie, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Categorie> createCategorie(@RequestBody() Categorie categorie) {
        var category = categorieService.create(categorie);
        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Categorie> updateCategorie(Long id, @RequestBody() Categorie categorie) {
        var category = categorieService.update(id, categorie);
        return new ResponseEntity<>(category, HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<Boolean> deleteCategorie(Long id) {
        var category = categorieService.delete(id);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ArticleAllResponse>> getAllArticlesByCategorie(Long idCategorie) {
        var articles = articleService.getAllArticlesByCategorie(idCategorie);
        var articleResponse = articles.stream().map(ArticleAllResponse::new).toList();
        return new ResponseEntity<>(articleResponse, HttpStatus.OK);
    }
}
