package com.JeicTechnology.POS.persistance.mapper;

import com.JeicTechnology.POS.domain.dto.CompraRequestDto;
import com.JeicTechnology.POS.persistance.entity.CompraEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ICompraMapper {

    CompraRequestDto toCompraRequestDto(CompraEntity compraEntity);

    @Mapping(target = "proveedorEntity", ignore = true)
    CompraEntity toCompraEntity(CompraRequestDto compraRequestDto);

    List<CompraRequestDto> toComprasRequestDto(List<CompraEntity> comprasEntityList);
}
