package com.JeicTechnology.TCB.persistance.repository;

import com.JeicTechnology.TCB.domain.dto.EstadoEnvioDto;
import com.JeicTechnology.TCB.domain.repository.IEstadoEnvioRepository;
import com.JeicTechnology.TCB.persistance.crud.IEstadoEnvioCrudRepository;
import com.JeicTechnology.TCB.persistance.entity.EstadoEnvioEntity;
import com.JeicTechnology.TCB.persistance.mapper.IEstadoEnvioMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class EstadoEnvioRepository implements IEstadoEnvioRepository {

    private final IEstadoEnvioCrudRepository iEstadoEnvioCrudRepository;

    private final IEstadoEnvioMapper iEstadoEnvioMapper;
    @Override
    public List<EstadoEnvioDto> getAll() {
        return iEstadoEnvioMapper.toEstadosEnvioDto(iEstadoEnvioCrudRepository.findAll());
    }

    @Override
    public Optional<EstadoEnvioDto> getEstadoEnvio(Integer id) {
        return iEstadoEnvioCrudRepository.findById(id).map(iEstadoEnvioMapper::toEstadoEnvioDto);
    }

    @Override
    public EstadoEnvioDto save(EstadoEnvioDto newEstadoEnvio) {
        EstadoEnvioEntity estadoEnvioEntity = iEstadoEnvioMapper.toEstadoEnvioEntity(newEstadoEnvio);
        return iEstadoEnvioMapper.toEstadoEnvioDto(iEstadoEnvioCrudRepository.save(estadoEnvioEntity));
    }

    @Override
    public void delete(Integer idEstadoEnvio) {
        iEstadoEnvioCrudRepository.deleteById(idEstadoEnvio);
    }
}
