package com.JeicTechnology.POS.persistance.repository;

import com.JeicTechnology.POS.domain.dto.ProductoDto;
import com.JeicTechnology.POS.domain.repository.IProductoRepository;
import com.JeicTechnology.POS.persistance.entity.ProductoEntity;
import com.JeicTechnology.POS.persistance.mapper.IProductoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor // crea constructor con los atributos de final
@Repository

public class ProductoRepository implements IProductoRepository {

    /**
     * crud de producto
     */
    private final IProductoCrudRepository iProductoCrudRepository;

    /**
     * mapper de producto
     */
    private final IProductoMapper iProductoMapper;


    /**
     * devuelve una lista de productos
     * @return lista de productos
     */
    @Override
    public List<ProductoDto> getAll() {
        return iProductoMapper.toProductosPojo(iProductoCrudRepository.findAll());
    }

    /**
     *Devuelve un producto por su id
     * @param id del producto
     * @return optional del producto encontrado
     */
    @Override
    public Optional<ProductoDto> getProducto(Integer id) {
        return iProductoCrudRepository.findById(id).map(iProductoMapper::toProductoPojo);
        //productoEntity -> iProductoMapper.toProductoPojo(productoEntity) ----metodo labda
        //iProductoMapper::toProductoPojo ----metodo por REFERENCIA
    }

    /**
     *guarda un nuevo producto
     * @param newProducto producto a guardar
     * @return producto guardado
     */
    @Override
    public ProductoDto save(ProductoDto newProducto) {
        ProductoEntity productoEntity = iProductoMapper.toProductoEntity(newProducto);
        return iProductoMapper.toProductoPojo(iProductoCrudRepository.save(productoEntity));
    }

    /**
     * eliminar producto por id
     * @param idProducto id del producto
     */
    @Override
    public void delete(Integer idProducto) {
        iProductoCrudRepository.deleteById(idProducto);
    }
}
