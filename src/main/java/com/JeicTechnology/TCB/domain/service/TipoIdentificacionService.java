package com.JeicTechnology.TCB.domain.service;

import com.JeicTechnology.TCB.domain.dto.TipoIdentificacionDto;
import com.JeicTechnology.TCB.domain.repository.ITipoIdentificacionRepository;
import com.JeicTechnology.TCB.domain.useCase.ITipoIdentificacionUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TipoIdentificacionService implements ITipoIdentificacionUseCase {

    private final ITipoIdentificacionRepository iTipoIdentificacionRepository;

    @Override
    public List<TipoIdentificacionDto> getAll() {
        return iTipoIdentificacionRepository.getAll();
    }

    @Override
    public Optional<TipoIdentificacionDto> getTipoIdentificacion(Integer id) {
        return iTipoIdentificacionRepository.getTipoIdentificacion(id);
    }

    @Override
    public TipoIdentificacionDto save(TipoIdentificacionDto newTipoIdentificacion) {
        return iTipoIdentificacionRepository.save(newTipoIdentificacion);
    }

    @Override
    public Optional<TipoIdentificacionDto> update(TipoIdentificacionDto modificarTipoIdentificacion) {
        if (iTipoIdentificacionRepository.getTipoIdentificacion(modificarTipoIdentificacion.getId()).isEmpty()){
            return Optional.empty();
        }
        return Optional.of(iTipoIdentificacionRepository.save(modificarTipoIdentificacion));
    }

    @Override
    public boolean delete(Integer idTipoIdentificacion) {
        if (iTipoIdentificacionRepository.getTipoIdentificacion(idTipoIdentificacion).isEmpty()){
            return false;
        }
        iTipoIdentificacionRepository.delete(idTipoIdentificacion);
        return true;
    }
}
