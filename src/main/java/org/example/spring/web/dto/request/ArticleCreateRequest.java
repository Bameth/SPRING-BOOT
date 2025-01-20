package org.example.spring.web.dto.request;

import org.example.spring.data.entities.Article;
import org.example.spring.data.entities.Categorie;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ArticleCreateRequest {
    private String code;
    private String name;
    private double prix;
    private Integer qteStock;
    private Long categorieId;

    public Article toEntity() {
        var entity = new Article();
        entity.setCode(code);
        entity.setName(name);
        entity.setPrix(prix);
        entity.setQteStock(qteStock);

        if (categorieId != null) { 
            var categorie = new Categorie();
            categorie.setId(categorieId); 
            entity.setCategorie(categorie);
        }

        return entity;
    }

}
