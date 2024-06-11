package com.JeicTechnology.TCB.domain.repository;


import com.JeicTechnology.TCB.domain.dto.TipoIdentificacionDto;

import java.util.List;
import java.util.Optional;

public interface ITipoIdentificacionRepository {

    List<TipoIdentificacionDto> getAll();

    Optional<TipoIdentificacionDto> getTipoIdentificacion(Integer id);

    TipoIdentificacionDto save(TipoIdentificacionDto newTipoIdentificacion);

    void delete(Integer idTipoIdentificacion);
}
