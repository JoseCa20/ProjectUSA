package com.JeicTechnology.TCB.domain.repository;

import com.JeicTechnology.TCB.domain.dto.EstadoEnvioDto;

import java.util.List;
import java.util.Optional;

public interface IEstadoEnvioRepository {

    List<EstadoEnvioDto> getAll();

    Optional<EstadoEnvioDto> getEstadoEnvio(Integer id);

    EstadoEnvioDto save(EstadoEnvioDto newEstadoEnvio);

    void delete(Integer idEstadoEnvio);
}
