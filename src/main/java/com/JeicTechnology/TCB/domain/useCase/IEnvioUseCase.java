package com.JeicTechnology.TCB.domain.useCase;

import com.JeicTechnology.TCB.domain.dto.EnvioDto;

import java.util.List;
import java.util.Optional;

public interface IEnvioUseCase {

    List<EnvioDto> getAll();

    Optional<EnvioDto> getEnvio(Integer id);

    EnvioDto save(EnvioDto newEnvio);

    Optional<EnvioDto> update(EnvioDto newEnvio);

    boolean delete(Integer idEnvio);
}
