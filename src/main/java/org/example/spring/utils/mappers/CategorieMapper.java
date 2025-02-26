package org.example.spring.utils.mappers;

import org.example.spring.data.entities.Categorie;
import org.example.spring.web.dto.response.CategorieAllResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CategorieMapper {
    CategorieMapper INSTANCE = Mappers.getMapper(CategorieMapper.class);

    CategorieAllResponse toDto(Categorie categorie);
}
