package com.JeicTechnology.TCB.domain.service;

import com.JeicTechnology.TCB.domain.dto.ProveedorDto;
import com.JeicTechnology.TCB.domain.repository.IProveedorRepository;
import com.JeicTechnology.TCB.domain.useCase.IProveedorUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProveedorService implements IProveedorUseCase {

    private final IProveedorRepository iProveedorRepository;

    @Override
    public List<ProveedorDto> getAll() {
        return iProveedorRepository.getAll();
    }

    @Override
    public Optional<ProveedorDto> getProveedor(Integer id) {
        return iProveedorRepository.getProveedor(id);
    }

    @Override
    public ProveedorDto save(ProveedorDto newProveedor) {
        return iProveedorRepository.save(newProveedor);
    }

    @Override
    public Optional<ProveedorDto> update(ProveedorDto modificarProveedor) {
        if (iProveedorRepository.getProveedor(modificarProveedor.getId()).isEmpty()){
            return Optional.empty();
        }
        return Optional.of(iProveedorRepository.save(modificarProveedor));
    }

    @Override
    public Boolean delete(Integer idProveedor) {
        if (iProveedorRepository.getProveedor(idProveedor).isEmpty()){
            return false;
        }
        iProveedorRepository.delete(idProveedor);
        return true;
    }
}
