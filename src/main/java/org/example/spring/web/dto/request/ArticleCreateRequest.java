package org.example.spring.web.dto.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ArticleCreateRequest {
    private String code;
    private String name;
    private double prix;
    private Integer qteStock;
    private Long categorieId;
}
