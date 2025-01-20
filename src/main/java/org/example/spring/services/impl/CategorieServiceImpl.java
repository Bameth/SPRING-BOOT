package org.example.spring.services.impl;

import lombok.RequiredArgsConstructor;
import org.example.spring.data.entities.Categorie;
import org.example.spring.data.repositories.CategorieRepository;
import org.example.spring.services.CategorieService;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class CategorieServiceImpl implements CategorieService {
    private final CategorieRepository categorieRepository;
    @Override
    public Categorie create(Categorie categorieRequest) {
        return categorieRepository.save(categorieRequest);
    }

    @Override
    public Categorie update(Long id,Categorie categorieRequest) {
        Categorie cat= categorieRepository
                .findById(id)
                .orElse(null);
        if (cat != null) {
            cat.setCode(categorieRequest.getCode());
            cat.setNom(categorieRequest.getNom());
            categorieRepository.save(cat);
        }
    return cat;
    }

    @Override
    public Categorie getById(Long id) {
        return categorieRepository
                .findById(id)
                .orElse(null);
    }

    @Override
    public boolean delete(Long id) {
        Categorie cat = categorieRepository
                .findById(id)
                .orElse(null);
        if (cat != null) {
            categorieRepository.delete(cat);
            return true;
        }
        return false;
    }

    @Override
    public List<Categorie> getAllCategories() {
        return categorieRepository.findAll();
    }
}
