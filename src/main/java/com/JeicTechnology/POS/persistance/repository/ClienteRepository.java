package com.JeicTechnology.POS.persistance.repository;

import com.JeicTechnology.POS.domain.dto.ClienteDto;
import com.JeicTechnology.POS.domain.repository.IClienteRepository;
import com.JeicTechnology.POS.persistance.crud.IClienteCrudRepository;
import com.JeicTechnology.POS.persistance.entity.ClienteEntity;
import com.JeicTechnology.POS.persistance.mapper.IClienteMapper;
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
    public Optional<ClienteDto> getCliente(Integer id) {
        return iClienteCrudRepository.findById(id).map(iClienteMapper::toClienteDto);
    }

    @Override
    public Optional<ClienteDto> getClienteByName(String name) {
        return iClienteCrudRepository.findByName(name).map(iClienteMapper::toClienteDto);
    }

    @Override
    public ClienteDto save(ClienteDto newCliente) {
        ClienteEntity clienteEntity = iClienteMapper.toClienteEntity(newCliente);
        return iClienteMapper.toClienteDto(iClienteCrudRepository.save(clienteEntity));
    }

    @Override
    public void delete(Integer idCliente) {
        iClienteCrudRepository.deleteById(idCliente);
    }
}
