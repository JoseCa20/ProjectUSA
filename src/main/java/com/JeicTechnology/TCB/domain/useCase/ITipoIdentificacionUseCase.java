package com.JeicTechnology.TCB.domain.useCase;

import com.JeicTechnology.TCB.domain.dto.TipoIdentificacionDto;

import java.util.List;
import java.util.Optional;

public interface ITipoIdentificacionUseCase {

    List<TipoIdentificacionDto> getAll();

    Optional<TipoIdentificacionDto> getTipoIdentificacion(Integer id);

    TipoIdentificacionDto save(TipoIdentificacionDto newTipoIdentificacion);

    Optional<TipoIdentificacionDto> update(TipoIdentificacionDto newTipoIdentificacion);

    boolean delete(Integer idTipoIdentificacion);

}
