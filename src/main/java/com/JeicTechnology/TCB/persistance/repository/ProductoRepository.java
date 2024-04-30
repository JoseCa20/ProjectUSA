package com.JeicTechnology.TCB.persistance.repository;

import com.JeicTechnology.TCB.domain.dto.ProductoDto;
import com.JeicTechnology.TCB.domain.repository.IProductoRepository;
import com.JeicTechnology.TCB.persistance.crud.IProductoCrudRepository;
import com.JeicTechnology.TCB.persistance.entity.ProductoEntity;
import com.JeicTechnology.TCB.persistance.mapper.IProductoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class ProductoRepository implements IProductoRepository {

    private final IProductoCrudRepository iProductoCrudRepository;

    private final IProductoMapper iProductoMapper;

    @Override
    public List<ProductoDto> getAll() {
        return iProductoMapper.toProductosDto(iProductoCrudRepository.findAll());
    }

    @Override
    public Optional<ProductoDto> getProducto(Integer id) {
        return iProductoCrudRepository.findById(id).map(iProductoMapper::toProductoDto);
    }

    @Override
    public ProductoDto save(ProductoDto newProducto) {
        ProductoEntity productoEntity = iProductoMapper.toProductoEntity(newProducto);
        return iProductoMapper.toProductoDto(iProductoCrudRepository.save(productoEntity));
    }

    @Override
    public void delete(Integer idProducto) {
        iProductoCrudRepository.deleteById(idProducto);
    }
}
