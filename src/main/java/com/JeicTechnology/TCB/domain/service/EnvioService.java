package com.JeicTechnology.TCB.domain.service;

import com.JeicTechnology.TCB.domain.dto.EnvioDto;
import com.JeicTechnology.TCB.domain.repository.IEnvioRepository;
import com.JeicTechnology.TCB.domain.useCase.IEnvioUseCase;
import com.JeicTechnology.TCB.exception.UnauthorizedException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class EnvioService implements IEnvioUseCase {

    private final IEnvioRepository iEnvioRepository;

    @Override
    public List<EnvioDto> getAll() {

        var listaRoles = SecurityContextHolder.getContext().getAuthentication().getAuthorities();

        if(listaRoles.stream().noneMatch(rol -> String.valueOf(rol).equals("Usuario"))){
            throw new UnauthorizedException();
        }

        if(listaRoles.stream().anyMatch(rol -> String.valueOf(rol).equals("Admin"))){
            throw new UnauthorizedException();
        }

        return iEnvioRepository.getAll();

    }

    @Override
    public Optional<EnvioDto> getEnvio(Integer id) {
        return iEnvioRepository.getEnvio(id);
    }

    @Override
    public EnvioDto save(EnvioDto newEnvio) {
        return iEnvioRepository.save(newEnvio);
    }

    @Override
    public Optional<EnvioDto> update(EnvioDto modificarEnvio) {
        if (iEnvioRepository.getEnvio(modificarEnvio.getId()).isEmpty()){
            return Optional.empty();
        }
        return Optional.of(iEnvioRepository.save(modificarEnvio));
    }

    @Override
    public boolean delete(Integer idEnvio) {
        if (iEnvioRepository.getEnvio(idEnvio).isEmpty()){
            return false;
        }
        iEnvioRepository.delete(idEnvio);
        return true;
    }
}
