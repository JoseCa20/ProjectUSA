package com.JeicTechnology.POS.domain.useCase;

import com.JeicTechnology.POS.domain.dto.ProductoDto;
import com.JeicTechnology.POS.domain.dto.ProveedorDto;

import java.util.List;
import java.util.Optional;

public interface IProveedorUseCase {

    List<ProveedorDto> getAll();

    Optional<ProveedorDto> getProveedor(Integer id);

    ProveedorDto save(ProveedorDto newProveedor);

    Optional<ProveedorDto> update(ProveedorDto newProveedor);

    Boolean delete(Integer idProveedor);

}
