package org.example.spring.web.dto.response;

import org.example.spring.data.entities.Article;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ArticleAllResponse {
    private Long id;
    private String code;
    private String name;
    private double prix;
    private Integer qteStock;
    private String categorieName;

    public ArticleAllResponse(Article article) {
        this.id = article.getId();
        this.code = article.getCode();
        this.name = article.getName();
        this.prix = article.getPrix();
        this.qteStock = article.getQteStock();
        this.categorieName = article.getCategorie().getNom();
    }
}
