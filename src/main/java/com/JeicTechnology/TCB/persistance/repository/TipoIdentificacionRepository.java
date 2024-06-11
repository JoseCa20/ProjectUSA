package com.JeicTechnology.TCB.persistance.repository;

import com.JeicTechnology.TCB.domain.dto.TipoIdentificacionDto;
import com.JeicTechnology.TCB.domain.repository.ITipoIdentificacionRepository;
import com.JeicTechnology.TCB.persistance.crud.ITipoIdentificacionCrudRepository;
import com.JeicTechnology.TCB.persistance.entity.TipoIdentificacionEntity;
import com.JeicTechnology.TCB.persistance.mapper.ITipoIdentificacionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Repository
public class TipoIdentificacionRepository implements ITipoIdentificacionRepository {

    private final ITipoIdentificacionCrudRepository iTipoIdentificacionCrudRepository;

    private final ITipoIdentificacionMapper iTipoIdentificacionMapper;

    @Override
    public List<TipoIdentificacionDto> getAll() {
        return iTipoIdentificacionMapper.toTiposIdentificacionDto(iTipoIdentificacionCrudRepository.findAll());
    }

    @Override
    public Optional<TipoIdentificacionDto> getTipoIdentificacion(Integer id) {
        return iTipoIdentificacionCrudRepository.findById(id).map(iTipoIdentificacionMapper::toTipoIdentificacionDto);
    }

    @Override
    public TipoIdentificacionDto save(TipoIdentificacionDto newTipoIdentificacion) {
        TipoIdentificacionEntity tipoIdentificacionEntity = iTipoIdentificacionMapper.toTipoIdentificacionEntity(newTipoIdentificacion);
        return iTipoIdentificacionMapper.toTipoIdentificacionDto(iTipoIdentificacionCrudRepository.save(tipoIdentificacionEntity));
    }

    @Override
    public void delete(Integer idTipoIdentificacion) {
        iTipoIdentificacionCrudRepository.deleteById(idTipoIdentificacion);
    }
}
