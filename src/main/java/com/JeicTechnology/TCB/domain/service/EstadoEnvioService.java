package com.JeicTechnology.TCB.domain.service;

import com.JeicTechnology.TCB.domain.dto.EstadoEnvioDto;
import com.JeicTechnology.TCB.domain.repository.IEstadoEnvioRepository;
import com.JeicTechnology.TCB.domain.useCase.IEstadoEnvioUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class EstadoEnvioService implements IEstadoEnvioUseCase {

    private final IEstadoEnvioRepository iEstadoEnvioRepository;

    @Override
    public List<EstadoEnvioDto> getAll() {
        return iEstadoEnvioRepository.getAll();
    }

    @Override
    public Optional<EstadoEnvioDto> getEstadoEnvio(Integer id) {
        return iEstadoEnvioRepository.getEstadoEnvio(id);
    }

    @Override
    public EstadoEnvioDto save(EstadoEnvioDto newEstadoEnvio) {
        return iEstadoEnvioRepository.save(newEstadoEnvio);
    }


    public Optional<EstadoEnvioDto> update(EstadoEnvioDto modificarEstadoEnvio) {
        if (iEstadoEnvioRepository.getEstadoEnvio(modificarEstadoEnvio.getId()).isEmpty()){
            return Optional.empty();
        }
        return Optional.of(iEstadoEnvioRepository.save(modificarEstadoEnvio));
    }

    @Override
    public boolean delete(Integer idEstadoEnvio) {
        if (iEstadoEnvioRepository.getEstadoEnvio(idEstadoEnvio).isEmpty()){
            return false;
        }
        iEstadoEnvioRepository.delete(idEstadoEnvio);
        return true;
    }
}
