package com.JeicTechnology.TCB.domain.service;

import com.JeicTechnology.TCB.domain.dto.ClienteDto;
import com.JeicTechnology.TCB.domain.dto.ResponseClienteDto;
import com.JeicTechnology.TCB.domain.repository.IClienteRepository;
import com.JeicTechnology.TCB.domain.useCase.IClienteUseCase;
import com.JeicTechnology.TCB.exception.ClienteNotExistException;
import com.JeicTechnology.TCB.exception.EmailValidationException;
import com.JeicTechnology.TCB.security.Roles;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ClienteService implements IClienteUseCase {

    private final PasswordEncoder passwordEncoder;

    private final IClienteRepository iClienteRepository;

    @Override
    public List<ClienteDto> getAll() {
        return iClienteRepository.getAll();
    }

    @Override
    public Optional<ClienteDto> getClienteByIdCard(Integer idCard) {
        return iClienteRepository.getClienteByIdCard(idCard);
    }

    @Override
    public Optional<ClienteDto> getClienteByEmail(String email) {
        return iClienteRepository.getClienteByEmail(email);
    }

    @Override
    public ResponseClienteDto save(ClienteDto newCliente) {
        if (!newCliente.getEmail().matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")){
            throw new EmailValidationException();
        }

        if (getClienteByIdCard(newCliente.getIdCard()).isPresent() || getClienteByEmail(newCliente.getEmail()).isPresent()){
            throw new ClienteNotExistException();
        }

        String passwordGenerated = generateRandomPassword(10);
        newCliente.setPassword(passwordEncoder.encode(passwordGenerated));
        newCliente.setActive("Activo");
        newCliente.setRol(Roles.CLIENTE);
        iClienteRepository.save(newCliente);

        return new ResponseClienteDto(passwordGenerated);
    }

    public ResponseClienteDto crearAdministrador(ClienteDto admin){
        String passwordGenerated = generateRandomPassword(10);
        admin.setPassword(passwordEncoder.encode(passwordGenerated));
        admin.setActive("Activo");
        admin.setRol(Roles.ADMIN);
        admin.setEmail("administrador@gmail.com");
        admin.setFullName("Administrador");
        iClienteRepository.save(admin);

        return new ResponseClienteDto(passwordGenerated);
    }

    @Override
    public Optional<ClienteDto> update(ClienteDto modificarCliente) {
        if (iClienteRepository.getClienteByIdCard(modificarCliente.getIdCard()).isEmpty()){
            return Optional.empty();
        }
        return Optional.of(iClienteRepository.save(modificarCliente));
    }

    @Override
    public boolean delete(Integer idCard) {
        if (iClienteRepository.getClienteByIdCard(idCard).isEmpty()){
            return false;
        }
        iClienteRepository.delete(idCard);
        return true;
    }

    private String generateRandomPassword(int len){
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz012345689";

        SecureRandom random = new SecureRandom();

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < len; i++){
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }

        return sb.toString();
    }
}
