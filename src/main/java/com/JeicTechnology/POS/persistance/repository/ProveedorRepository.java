package com.JeicTechnology.POS.persistance.repository;

import com.JeicTechnology.POS.domain.dto.ProveedorDto;
import com.JeicTechnology.POS.domain.repository.IProveedorRepository;
import com.JeicTechnology.POS.persistance.crud.IProveedorCrudRepository;
import com.JeicTechnology.POS.persistance.entity.CategoriaEntity;
import com.JeicTechnology.POS.persistance.entity.ProveedorEntity;
import com.JeicTechnology.POS.persistance.mapper.IProveedorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Repository
public class ProveedorRepository implements IProveedorRepository {

    private final IProveedorCrudRepository iProveedorCrudRepository;

    private final IProveedorMapper iProveedorMapper;

    @Override
    public List<ProveedorDto> getAll() {
        return iProveedorMapper.toProveedoresDto(iProveedorCrudRepository.findAll());
    }

    @Override
    public Optional<ProveedorDto> getProveedor(Integer id) {
        return iProveedorCrudRepository.findById(id).map(iProveedorMapper::toProveedorDto);
    }

    @Override
    public ProveedorDto save(ProveedorDto newProveedor) {
        ProveedorEntity proveedorEntity = iProveedorMapper.toProveedorEntity(newProveedor);
        return iProveedorMapper.toProveedorDto(iProveedorCrudRepository.save(proveedorEntity));
    }

    @Override
    public void delete(Integer idProveedor) {
        iProveedorCrudRepository.deleteById(idProveedor);
    }
}
