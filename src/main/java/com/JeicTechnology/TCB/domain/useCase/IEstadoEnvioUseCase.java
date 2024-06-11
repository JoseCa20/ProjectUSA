package com.JeicTechnology.TCB.domain.useCase;

import com.JeicTechnology.TCB.domain.dto.EstadoEnvioDto;

import java.util.List;
import java.util.Optional;

public interface IEstadoEnvioUseCase {

    List<EstadoEnvioDto> getAll();

    Optional<EstadoEnvioDto> getEstadoEnvio(Integer id);

    EstadoEnvioDto save(EstadoEnvioDto newEstadoEnvio);

    Optional<EstadoEnvioDto> update(EstadoEnvioDto newEstadoEnvio);

    boolean delete(Integer idEstadoEnvio);
}
