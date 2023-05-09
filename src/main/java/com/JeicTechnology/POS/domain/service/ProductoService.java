package com.JeicTechnology.POS.domain.service;

import com.JeicTechnology.POS.domain.pojo.ProductoPojo;
import com.JeicTechnology.POS.domain.repository.IProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * servicio de producto
 */
@RequiredArgsConstructor
@Service
public class ProductoService implements IProductoService{

    private final IProductoRepository iProductoRepository;

    @Override
    public List<ProductoPojo> getAll() {
        return iProductoRepository.getAll();
    }

    @Override
    public Optional<ProductoPojo> getProducto(Integer id) {
        return iProductoRepository.getProducto(id);
    }

    @Override
    public ProductoPojo save(ProductoPojo newProducto) {
        return iProductoRepository.save(newProducto);
    }

    @Override
    public Optional<ProductoPojo> update(ProductoPojo newProducto) {
        if (iProductoRepository.getProducto(newProducto.getId()).isEmpty()){
            return Optional.empty();
        }
        return Optional.of(iProductoRepository.save(newProducto));
    }

    @Override
    public boolean delete(Integer idProducto) {
       if (iProductoRepository.getProducto(idProducto).isEmpty()){
           return false;
       }
       iProductoRepository.delete(idProducto);
       return true;
    }
}
