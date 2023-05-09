package com.JeicTechnology.POS.domain.service;

import com.JeicTechnology.POS.domain.pojo.ProductoPojo;

import java.util.List;
import java.util.Optional;

public interface IProductoService {

    /**
     * devuelve una lista de productos
     * @return lista con productos
     */
    List<ProductoPojo> getAll();

    /**
     * devuelve un producto dado su id
     * @param id del producto
     * @return Optional del producto encontrado
     */
    Optional<ProductoPojo> getProducto(Integer id);

    /**
     * guarda un producto
     * @param newProducto producto a guardar
     * @return coche guardado
     */
    ProductoPojo save(ProductoPojo newProducto);

    Optional<ProductoPojo> update(ProductoPojo newProducto);

    /**
     * elimina un producto dado su id
     * @param idProducto id del producto
     */
    boolean delete(Integer idProducto);
}
