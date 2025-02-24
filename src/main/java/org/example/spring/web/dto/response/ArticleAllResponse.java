package org.example.spring.web.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ArticleAllResponse {
    private Long id;
    private String code;
    private String name;
    private double prix;
    private Integer qteStock;
    private String categorieName;
}
