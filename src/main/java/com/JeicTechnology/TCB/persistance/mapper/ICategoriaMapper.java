package com.JeicTechnology.TCB.persistance.mapper;

import com.JeicTechnology.TCB.domain.dto.CategoriaDto;
import com.JeicTechnology.TCB.persistance.entity.CategoriaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ICategoriaMapper {

    CategoriaDto toCategoriaDto(CategoriaEntity categoriaEntity);

    @Mapping(target = "productoEntityList", ignore = true)
    CategoriaEntity toCategoriaEntity(CategoriaDto categoriaDto);

    List<CategoriaDto> toCategoriasDto(List<CategoriaEntity> categoriasEntity);
}
