package com.JeicTechnology.TCB.domain.service;

import com.JeicTechnology.TCB.domain.dto.CategoriaDto;
import com.JeicTechnology.TCB.domain.repository.ICategoriaRepository;
import com.JeicTechnology.TCB.domain.useCase.ICategoriaUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CategoriaService implements ICategoriaUseCase {

    private final ICategoriaRepository iCategoriaRepository;

    @Override
    public List<CategoriaDto> getAll() {
        return iCategoriaRepository.getAll();
    }

    @Override
    public Optional<CategoriaDto> getCategoria(Integer id) {
        return iCategoriaRepository.getCategoria(id);
    }

    @Override
    public CategoriaDto save(CategoriaDto newCategoria) {
        return iCategoriaRepository.save(newCategoria);
    }


    public Optional<CategoriaDto> update(CategoriaDto modificarCategoria) {
        if (iCategoriaRepository.getCategoria(modificarCategoria.getId()).isEmpty()){
            return Optional.empty();
        }
        return Optional.of(iCategoriaRepository.save(modificarCategoria));
    }

    @Override
    public Boolean delete(Integer idCategoria) {
        if (iCategoriaRepository.getCategoria(idCategoria).isEmpty()){
            return false;
        }
        iCategoriaRepository.delete(idCategoria);
        return true;
    }
}
