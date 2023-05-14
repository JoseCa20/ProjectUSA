package com.JeicTechnology.POS.domain.service;

import com.JeicTechnology.POS.domain.dto.ClienteDto;
import com.JeicTechnology.POS.domain.repository.IClienteRepository;
import com.JeicTechnology.POS.domain.useCase.IClienteUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ClienteService implements IClienteUseCase {

    private final IClienteRepository iClienteRepository;

    @Override
    public List<ClienteDto> getAll() {
        return iClienteRepository.getAll();
    }

    @Override
    public Optional<ClienteDto> getCliente(Integer id) {
        return iClienteRepository.getCliente(id);
    }

    @Override
    public Optional<ClienteDto> getClienteByName(String name) {
        return iClienteRepository.getClienteByName(name);
    }

    @Override
    public ClienteDto save(ClienteDto newCliente) {
        return iClienteRepository.save(newCliente);
    }

    @Override
    public Optional<ClienteDto> update(ClienteDto modificarCliente) {
        if (iClienteRepository.getCliente(modificarCliente.getId()).isEmpty()){
            return Optional.empty();
        }
        return Optional.of(iClienteRepository.save(modificarCliente));
    }

    @Override
    public Boolean delete(Integer idCliente) {
        if (iClienteRepository.getCliente(idCliente).isEmpty()){
            return false;
        }
        iClienteRepository.delete(idCliente);
        return true;
    }
}
