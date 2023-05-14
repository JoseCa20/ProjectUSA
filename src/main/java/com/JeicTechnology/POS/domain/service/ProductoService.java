package com.JeicTechnology.POS.domain.service;

import com.JeicTechnology.POS.domain.dto.ProductoDto;
import com.JeicTechnology.POS.domain.repository.IProductoRepository;
import com.JeicTechnology.POS.domain.useCase.IProductoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductoService implements IProductoUseCase {

    private final IProductoRepository iProductoRepository;

    @Override
    public List<ProductoDto> getAll() {
        return iProductoRepository.getAll();
    }

    @Override
    public Optional<ProductoDto> getProducto(Integer id) {
        return iProductoRepository.getProducto(id);
    }

    @Override
    public ProductoDto save(ProductoDto newProducto) {
        return iProductoRepository.save(newProducto);
    }

    @Override
    public Optional<ProductoDto> update(ProductoDto modificarProducto) {
        if (iProductoRepository.getProducto(modificarProducto.getId()).isEmpty()){
            return Optional.empty();
        }
        return Optional.of(iProductoRepository.save(modificarProducto));
    }

    @Override
    public Boolean delete(Integer idProducto) {
        if (iProductoRepository.getProducto(idProducto).isEmpty()){
            return false;
        }
        iProductoRepository.delete(idProducto);
        return true;
    }
}
