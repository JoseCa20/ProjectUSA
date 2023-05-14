package com.JeicTechnology.POS.domain.useCase;

import com.JeicTechnology.POS.domain.dto.ClienteDto;
import com.JeicTechnology.POS.domain.dto.ProductoDto;

import java.util.List;
import java.util.Optional;

public interface IProductoUseCase {

    List<ProductoDto> getAll();

    Optional<ProductoDto> getProducto(Integer id);

    ProductoDto save(ProductoDto newProducto);

    Optional<ProductoDto> update(ProductoDto newProducto);

    Boolean delete(Integer idProducto);
}
