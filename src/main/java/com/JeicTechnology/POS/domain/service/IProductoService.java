package com.JeicTechnology.POS.domain.service;

import com.JeicTechnology.POS.domain.dto.ProductoDto;

import java.util.List;
import java.util.Optional;

public interface IProductoService {

    /**
     * devuelve una lista de productos
     * @return lista con productos
     */
    List<ProductoDto> getAll();

    /**
     * devuelve un producto dado su id
     * @param id del producto
     * @return Optional del producto encontrado
     */
    Optional<ProductoDto> getProducto(Integer id);

    /**
     * guarda un producto
     * @param newProducto producto a guardar
     * @return coche guardado
     */
    ProductoDto save(ProductoDto newProducto);

    Optional<ProductoDto> update(ProductoDto newProducto);

    /**
     * elimina un producto dado su id
     * @param idProducto id del producto
     */
    boolean delete(Integer idProducto);
}
