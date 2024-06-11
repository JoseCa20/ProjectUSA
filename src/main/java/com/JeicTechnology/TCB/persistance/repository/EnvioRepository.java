package com.JeicTechnology.TCB.persistance.repository;

import com.JeicTechnology.TCB.domain.dto.EnvioDto;
import com.JeicTechnology.TCB.domain.repository.IEnvioRepository;
import com.JeicTechnology.TCB.persistance.crud.IEnvioCrudRepository;
import com.JeicTechnology.TCB.persistance.entity.EnvioEntity;
import com.JeicTechnology.TCB.persistance.mapper.IEnvioMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class EnvioRepository implements IEnvioRepository {

    private final IEnvioCrudRepository iEnvioCrudRepository;

    private final IEnvioMapper iEnvioMapper;

    @Override
    public List<EnvioDto> getAll() {
        return iEnvioMapper.toEnviosDto(iEnvioCrudRepository.findAll());
    }

    @Override
    public Optional<EnvioDto> getEnvio(Integer id) {
        return iEnvioCrudRepository.findById(id).map(iEnvioMapper::toEnvioDto);
    }

    @Override
    public EnvioDto save(EnvioDto newEnvio) {
        EnvioEntity envioEntity = iEnvioMapper.toEnvioEntity(newEnvio);
        return iEnvioMapper.toEnvioDto(iEnvioCrudRepository.save(envioEntity));
    }

    @Override
    public void delete(Integer idEnvio) {
        iEnvioCrudRepository.deleteById(idEnvio);
    }
}
