package org.example.spring.services;

import org.example.spring.data.entities.Categorie;

import java.util.List;

public interface CategorieService {
    Categorie create(Categorie categorieRequest);

    Categorie update(Long id, Categorie categorieRequest);

    Categorie getById(Long id);

    boolean delete(Long id);

    List<Categorie> getAllCategories();
}
