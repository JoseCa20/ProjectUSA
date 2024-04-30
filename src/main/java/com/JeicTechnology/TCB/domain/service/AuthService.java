package com.JeicTechnology.TCB.domain.service;

import com.JeicTechnology.TCB.domain.dto.AuthClienteDto;
import com.JeicTechnology.TCB.domain.dto.ClienteDto;
import com.JeicTechnology.TCB.domain.dto.JwtResponseDto;
import com.JeicTechnology.TCB.domain.repository.IClienteRepository;
import com.JeicTechnology.TCB.domain.useCase.IAuthUseCase;
import com.JeicTechnology.TCB.exception.ClienteNotExistException;
import com.JeicTechnology.TCB.exception.PasswordIncorrectException;
import com.JeicTechnology.TCB.security.JwtAuthenticationProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AuthService implements IAuthUseCase {

    private final IClienteRepository iClienteRepository;

    private final JwtAuthenticationProvider jwtAuthenticationProvider;

    private final PasswordEncoder passwordEncoder;

    public JwtResponseDto signIn(AuthClienteDto authClienteDto) throws ClienteNotExistException, PasswordIncorrectException {
        Optional<ClienteDto> cliente = iClienteRepository.getClienteByEmail(authClienteDto.getEmail());
        if (cliente.isEmpty()){
            throw new ClienteNotExistException();
        }

        if (!passwordEncoder.matches(authClienteDto.getPassword(), cliente.get().getPassword())){
            throw new PasswordIncorrectException();
        }

        return new JwtResponseDto(jwtAuthenticationProvider.createToken(cliente.get()));
    }

    @Override
    public JwtResponseDto signOut(String token) {
        String[] authElements =token.split(" ");
        return new JwtResponseDto(jwtAuthenticationProvider.deleteToken(authElements[1]));
    }
}
