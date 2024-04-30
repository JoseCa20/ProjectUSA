package com.JeicTechnology.TCB.domain.useCase;

import com.JeicTechnology.TCB.domain.dto.ProductoDto;

import java.util.List;
import java.util.Optional;

public interface IProductoUseCase {

    List<ProductoDto> getAll();

    Optional<ProductoDto> getProducto(Integer id);

    ProductoDto save(ProductoDto newProducto);

    Optional<ProductoDto> update(ProductoDto newProducto);

    Boolean delete(Integer idProducto);
}
