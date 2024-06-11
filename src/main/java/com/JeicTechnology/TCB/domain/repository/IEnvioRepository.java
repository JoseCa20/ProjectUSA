package com.JeicTechnology.TCB.domain.repository;

import com.JeicTechnology.TCB.domain.dto.EnvioDto;

import java.util.List;
import java.util.Optional;

public interface IEnvioRepository {

    List<EnvioDto> getAll();

    Optional<EnvioDto> getEnvio(Integer id);

    EnvioDto save(EnvioDto newEnvio);

    void delete(Integer idEnvio);
}
