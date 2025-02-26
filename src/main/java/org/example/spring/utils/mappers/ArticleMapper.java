package org.example.spring.utils.mappers;

import org.example.spring.data.entities.Article;
import org.example.spring.web.dto.request.ArticleCreateRequest;
import org.example.spring.web.dto.response.ArticleAllResponse;
import org.example.spring.web.dto.response.ArticleOneResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = { CategorieMapper.class })
public interface ArticleMapper {
    ArticleMapper INSTANCE = Mappers.getMapper(ArticleMapper.class);

    @Mapping(source = "categorie.nom", target = "categorieName")
    ArticleAllResponse toDto(Article article);

    @Mapping(source = "categorie", target = "category")
    ArticleOneResponse toDto2(Article article);

    @Mapping(source = "category.id", target = "categorie.id")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "categorie.articles", ignore = true)
    Article toEntity(ArticleOneResponse dto);

    @Mapping(source = "categorieId", target = "categorie.id")
    @Mapping(target = "id", ignore = true)
    Article toEntity(ArticleCreateRequest dto);
}
