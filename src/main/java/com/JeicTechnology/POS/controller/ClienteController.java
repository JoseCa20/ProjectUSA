package com.JeicTechnology.POS.controller;

import com.JeicTechnology.POS.domain.dto.ClienteDto;
import com.JeicTechnology.POS.domain.useCase.IClienteUseCase;
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

    @GetMapping(path = "/{id}")
    public ResponseEntity<ClienteDto> getClienteById(@PathVariable Integer id){
        return ResponseEntity.of(iClienteUseCase.getCliente(id));
    }

    @GetMapping(path = "/name/{name}")
    public ResponseEntity<ClienteDto> getClienteByName(@PathVariable String name){
        return ResponseEntity.of(iClienteUseCase.getClienteByName(name));
    }

    @PostMapping
    public ResponseEntity<ClienteDto> save(@RequestBody ClienteDto newClienteDto){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(iClienteUseCase.save(newClienteDto));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PatchMapping
    public ResponseEntity<ClienteDto> update(@RequestBody ClienteDto updateClienteDto){
        return ResponseEntity.of(iClienteUseCase.update(updateClienteDto));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer id){
        return new ResponseEntity<>(this.iClienteUseCase.delete(id) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
