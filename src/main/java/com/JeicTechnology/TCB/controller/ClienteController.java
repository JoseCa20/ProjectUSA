package com.JeicTechnology.TCB.controller;

import com.JeicTechnology.TCB.domain.dto.ClienteDto;
import com.JeicTechnology.TCB.domain.dto.ResponseClienteDto;
import com.JeicTechnology.TCB.domain.useCase.IClienteUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/clientes")
public class ClienteController {

    private final IClienteUseCase iClienteUseCase;

    @GetMapping
    public ResponseEntity<List<ClienteDto>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(iClienteUseCase.getAll());
    }

    @GetMapping(path = "/{idCard}")
    public ResponseEntity<ClienteDto> getClienteById(@PathVariable Integer idCard){
        return ResponseEntity.of(iClienteUseCase.getClienteByIdCard(idCard));
    }

    @GetMapping(path = "/email/{email}")
    public ResponseEntity<ClienteDto> getClienteByEmail(@PathVariable String email){
        return ResponseEntity.of(iClienteUseCase.getClienteByEmail(email));
    }

    @PostMapping
    public ResponseEntity<ResponseClienteDto> save(@RequestBody ClienteDto newClienteDto){
            return ResponseEntity.status(HttpStatus.CREATED).body(iClienteUseCase.save(newClienteDto));
    }

    @PatchMapping
    public ResponseEntity<ClienteDto> update(@RequestBody ClienteDto updateClienteDto){
        return ResponseEntity.of(iClienteUseCase.update(updateClienteDto));
    }

    @DeleteMapping(path = "/{idCard}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer idCard){
        return new ResponseEntity<>(this.iClienteUseCase.delete(idCard) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
