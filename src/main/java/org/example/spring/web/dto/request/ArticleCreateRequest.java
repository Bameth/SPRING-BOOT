package org.example.spring.web.dto.request;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Ceci est un DTO request pour la creation d'un article")
public class ArticleCreateRequest {
    private String code;
    private String name;
    private double prix;
    private Integer qteStock;
    @Schema(description = "Id de la categorie de l'article", example = "15")
    private Long categorieId;
}
