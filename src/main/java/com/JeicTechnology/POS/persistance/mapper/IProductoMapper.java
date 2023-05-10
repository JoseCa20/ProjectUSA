package com.JeicTechnology.POS.persistance.mapper;

import com.JeicTechnology.POS.domain.dto.ProductoDto;
import com.JeicTechnology.POS.persistance.entity.ProductoEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IProductoMapper {

    /**
     * convierte una entidad a un pojo de producto
     * @param productoEntity entidad a convertir
     * @return pojo convertido
     */
    @Mapping(source = "id", target = "id")
    @Mapping(source = "code", target = "code")
    ProductoDto toProductoPojo(ProductoEntity productoEntity);

    /**
     * convierte un pojo a una entidad de producto
     * @param productoDto pojo a convertir
     * @return entidad convertida
     */
    @InheritInverseConfiguration
    ProductoEntity toProductoEntity(ProductoDto productoDto);

    /**
     * retorna una lista de productos transformada a pojo de una lista de entidades
     * @param productosEntity entidad a transformar
     * @return lista transformada
     */
    List<ProductoDto> toProductosPojo(List<ProductoEntity> productosEntity);
}
