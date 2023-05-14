package com.JeicTechnology.POS.domain.repository;


import com.JeicTechnology.POS.domain.dto.ProveedorDto;

import java.util.List;
import java.util.Optional;

public interface IProveedorRepository {

    List<ProveedorDto> getAll();

    Optional<ProveedorDto> getProveedor(Integer id);

    ProveedorDto save(ProveedorDto newProveedor);

    void delete(Integer idProveedor);
}
