package com.JeicTechnology.TCB.domain.useCase;

import com.JeicTechnology.TCB.domain.dto.CategoriaDto;

import java.util.List;
import java.util.Optional;

public interface ICategoriaUseCase {

    List<CategoriaDto> getAll();

    Optional<CategoriaDto> getCategoria(Integer id);

    CategoriaDto save(CategoriaDto newCategoria);

    Optional<CategoriaDto> update(CategoriaDto newCategoria);

    Boolean delete(Integer idCategoria);
}
