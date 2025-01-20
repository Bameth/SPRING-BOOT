package org.example.spring.web.dto.response;

import org.example.spring.data.entities.Categorie;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CategorieAllResponse {
    private Long id;
    private String code;
    private String nom;
    
    public CategorieAllResponse(Categorie categorie) {
        this.id = categorie.getId();
        this.code = categorie.getCode();
        this.nom = categorie.getNom();
    }
}
