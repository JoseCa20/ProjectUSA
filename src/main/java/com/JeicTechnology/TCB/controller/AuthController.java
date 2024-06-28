package com.JeicTechnology.TCB.controller;

import com.JeicTechnology.TCB.domain.dto.AuthClienteDto;
import com.JeicTechnology.TCB.domain.dto.ClienteDto;
import com.JeicTechnology.TCB.domain.dto.JwtResponseDto;
import com.JeicTechnology.TCB.domain.dto.ResponseClienteDto;
import com.JeicTechnology.TCB.domain.useCase.IAuthUseCase;
import com.JeicTechnology.TCB.domain.useCase.IClienteUseCase;
import com.JeicTechnology.TCB.exception.ClienteNotExistException;
import com.JeicTechnology.TCB.exception.PasswordIncorrectException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin()
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/auth")
public class AuthController {

    private final IClienteUseCase iClienteUseCase;

    private final IAuthUseCase iAuthUseCase;

    @PostMapping(path = "/sign-up")
    public ResponseEntity<ResponseClienteDto> save(@RequestBody ClienteDto newClienteDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(iClienteUseCase.save(newClienteDto));
    }

    @PostMapping(path = "/sign-in")
    public ResponseEntity<JwtResponseDto> signIn(@RequestBody AuthClienteDto authClienteDto) throws ClienteNotExistException, PasswordIncorrectException {
        return ResponseEntity.ok(iAuthUseCase.signIn(authClienteDto));
    }

    @PostMapping(path = "/sign-out")
    public ResponseEntity<JwtResponseDto> signOut(@RequestHeader(name = HttpHeaders.AUTHORIZATION) String jwt){
        return ResponseEntity.ok(iAuthUseCase.signOut(jwt));
    }
}
