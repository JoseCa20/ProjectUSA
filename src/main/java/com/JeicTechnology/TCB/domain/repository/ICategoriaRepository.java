package com.JeicTechnology.TCB.domain.repository;

import com.JeicTechnology.TCB.domain.dto.CategoriaDto;

import java.util.List;
import java.util.Optional;

public interface ICategoriaRepository {

    List<CategoriaDto> getAll();

    Optional<CategoriaDto> getCategoria(Integer id);

    CategoriaDto save(CategoriaDto newCategoria);

    void delete(Integer idCategoria);
}
