package org.example.spring.web.controllers;

import org.example.spring.data.entities.Categorie;
import org.example.spring.web.dto.response.ArticleAllResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface CategorieController {
    @GetMapping("categorie/list")
    ResponseEntity<List<Categorie>> getAllCategories();

    @GetMapping("categorie/one/{id}")
    ResponseEntity<Categorie> getOne(@PathVariable() Long id);

    @PostMapping("categorie/create")
    ResponseEntity<Categorie> createCategorie(@RequestBody Categorie categorie);

    @PutMapping("categorie/update/{id}")
    ResponseEntity<Categorie> updateCategorie(@PathVariable() Long id, @RequestBody Categorie categorie);

    @DeleteMapping("categorie/delete/{id}")
    ResponseEntity<Boolean> deleteCategorie(@PathVariable() Long id);

    @GetMapping("categorie/{id}/articles")
    ResponseEntity<List<ArticleAllResponse>> getAllArticlesByCategorie(@PathVariable(name = "id") Long idCategorie);
}
