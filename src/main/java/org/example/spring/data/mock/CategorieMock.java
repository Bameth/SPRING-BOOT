package org.example.spring.data.mock;

import lombok.RequiredArgsConstructor;
import org.example.spring.data.entities.Categorie;
import org.example.spring.data.repositories.CategorieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Order(1)
@Component
public class CategorieMock implements CommandLineRunner {
    private final CategorieRepository categorieRepository;
    @Override
    public void run(String... args) throws Exception {
        List<Categorie> categories =  new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Categorie categorie = new Categorie();
            categorie.setCode("code" + i);
            categorie.setNom("nom" + i);
            categories.add(categorie);
        }
        categorieRepository.saveAllAndFlush(categories);
    }
}
