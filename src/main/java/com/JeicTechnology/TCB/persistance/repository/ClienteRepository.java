package com.JeicTechnology.TCB.persistance.repository;

import com.JeicTechnology.TCB.domain.dto.ClienteDto;
import com.JeicTechnology.TCB.domain.repository.IClienteRepository;
import com.JeicTechnology.TCB.persistance.crud.IClienteCrudRepository;
import com.JeicTechnology.TCB.persistance.entity.ClienteEntity;
import com.JeicTechnology.TCB.persistance.mapper.IClienteMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class ClienteRepository implements IClienteRepository {

    private final IClienteCrudRepository iClienteCrudRepository;

    private final IClienteMapper iClienteMapper;

    @Override
    public List<ClienteDto> getAll() {
        return iClienteMapper.toClientesDto(iClienteCrudRepository.findAll());
    }

    @Override
    public Optional<ClienteDto> getClienteByIdCard(Integer idCard) {
        return iClienteCrudRepository.findByIdCard(idCard).map(iClienteMapper::toClienteDto);
    }

    @Override
    public Optional<ClienteDto> getClienteByEmail(String email) {
        return iClienteCrudRepository.findByEmail(email).map(iClienteMapper::toClienteDto);
    }

    @Override
    public ClienteDto save(ClienteDto newCliente) {
        return iClienteMapper.toClienteDto(iClienteCrudRepository.save(iClienteMapper.toClienteEntity(newCliente)));
    }

    @Override
    public void delete(Integer idCard) {
        iClienteCrudRepository.deleteById(idCard);
    }
}
