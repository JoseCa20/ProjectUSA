package com.JeicTechnology.TCB.domain.service;

import com.JeicTechnology.TCB.domain.dto.ProductoDto;
import com.JeicTechnology.TCB.domain.repository.IProductoRepository;
import com.JeicTechnology.TCB.domain.useCase.IProductoUseCase;
import com.JeicTechnology.TCB.exception.UnauthorizedException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductoService implements IProductoUseCase {

    private final IProductoRepository iProductoRepository;

    @Override
    public List<ProductoDto> getAll() {

        var listaRoles = SecurityContextHolder.getContext().getAuthentication().getAuthorities();

        if(listaRoles.stream().noneMatch(rol -> String.valueOf(rol).equals("Usuario"))){
            throw new UnauthorizedException();
        }

        if(listaRoles.stream().anyMatch(rol -> String.valueOf(rol).equals("Admin"))){
            throw new UnauthorizedException();
        }

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
