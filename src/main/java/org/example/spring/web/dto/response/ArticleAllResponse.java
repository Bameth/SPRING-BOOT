package org.example.spring.web.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Ceci est un DTO response d'article avec sa categorie en chaine de caractere")
public class ArticleAllResponse {
    @Schema(description = "Id unique de l'article", example = "15")
    private Long id;
    private String code;
    private String name;
    private double prix;
    private Integer qteStock;
    private String categorieName;
}
