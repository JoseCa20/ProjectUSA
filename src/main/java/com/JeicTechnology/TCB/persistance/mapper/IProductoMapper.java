package com.JeicTechnology.TCB.persistance.mapper;

import com.JeicTechnology.TCB.domain.dto.ProductoDto;
import com.JeicTechnology.TCB.persistance.entity.ProductoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IProductoMapper {

    ProductoDto toProductoDto(ProductoEntity productoEntity);

    @Mapping(target = "categoriaEntity", ignore = true)
    @Mapping(target = "detalleCompraEntity", ignore = true)
    @Mapping(target = "proveedorEntityList", ignore = true)
    ProductoEntity toProductoEntity(ProductoDto productoDto);

    List<ProductoDto> toProductosDto(List<ProductoEntity> productoEntityList);
}
