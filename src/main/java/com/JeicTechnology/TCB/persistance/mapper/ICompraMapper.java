package com.JeicTechnology.TCB.persistance.mapper;

import com.JeicTechnology.TCB.domain.dto.CompraRequestDto;
import com.JeicTechnology.TCB.persistance.entity.CompraEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ICompraMapper {

    @Mapping(target = "detalleCompraRequestDtoList", ignore = true)
    CompraRequestDto toCompraRequestDto(CompraEntity compraEntity);

    @Mapping(target = "proveedorEntity", ignore = true)
    @Mapping(target = "detalleCompraEntityList", ignore = true)
    CompraEntity toCompraEntity(CompraRequestDto compraRequestDto);

    List<CompraRequestDto> toComprasRequestDto(List<CompraEntity> comprasEntityList);
}
