package com.JeicTechnology.TCB.domain.repository;

import com.JeicTechnology.TCB.domain.dto.ProductoDto;

import java.util.List;
import java.util.Optional;

public interface IProductoRepository {

    List<ProductoDto> getAll();

    Optional<ProductoDto> getProducto(Integer id);

    ProductoDto save(ProductoDto newProducto);

    void delete(Integer idProducto);
}
