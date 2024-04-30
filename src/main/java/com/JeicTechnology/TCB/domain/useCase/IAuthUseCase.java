package com.JeicTechnology.TCB.domain.useCase;

import com.JeicTechnology.TCB.domain.dto.AuthClienteDto;
import com.JeicTechnology.TCB.domain.dto.JwtResponseDto;
import com.JeicTechnology.TCB.exception.ClienteNotExistException;
import com.JeicTechnology.TCB.exception.PasswordIncorrectException;

public interface IAuthUseCase {

    JwtResponseDto signIn(AuthClienteDto authClienteDto) throws ClienteNotExistException, PasswordIncorrectException;

    JwtResponseDto signOut(String jwt);

}
