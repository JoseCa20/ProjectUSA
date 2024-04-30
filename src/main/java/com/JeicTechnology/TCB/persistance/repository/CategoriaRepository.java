package com.JeicTechnology.TCB.persistance.repository;

import com.JeicTechnology.TCB.domain.dto.CategoriaDto;
import com.JeicTechnology.TCB.domain.repository.ICategoriaRepository;
import com.JeicTechnology.TCB.persistance.crud.ICategoriaCrudRepository;
import com.JeicTechnology.TCB.persistance.entity.CategoriaEntity;
import com.JeicTechnology.TCB.persistance.mapper.ICategoriaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class CategoriaRepository implements ICategoriaRepository {

    private final ICategoriaCrudRepository iCategoriaCrudRepository;

    private final ICategoriaMapper iCategoriaMapper;
    @Override
    public List<CategoriaDto> getAll() {
        return iCategoriaMapper.toCategoriasDto(iCategoriaCrudRepository.findAll());
    }

    @Override
    public Optional<CategoriaDto> getCategoria(Integer id) {
        return iCategoriaCrudRepository.findById(id).map(iCategoriaMapper::toCategoriaDto);
    }

    @Override
    public CategoriaDto save(CategoriaDto newCategoria) {
        CategoriaEntity categoriaEntity = iCategoriaMapper.toCategoriaEntity(newCategoria);
        return iCategoriaMapper.toCategoriaDto(iCategoriaCrudRepository.save(categoriaEntity));
    }

    @Override
    public void delete(Integer idCategoria) {
        iCategoriaCrudRepository.deleteById(idCategoria);
    }
}
