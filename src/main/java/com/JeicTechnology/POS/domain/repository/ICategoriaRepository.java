package com.JeicTechnology.POS.domain.repository;

import com.JeicTechnology.POS.domain.dto.CategoriaDto;

import java.util.List;
import java.util.Optional;

public interface ICategoriaRepository {

    List<CategoriaDto> getAll();

    Optional<CategoriaDto> getCategoria(Integer id);

    CategoriaDto save(CategoriaDto newCategoria);

    void delete(Integer idCategoria);
}
