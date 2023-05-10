package com.JeicTechnology.POS.controller;

import com.JeicTechnology.POS.domain.dto.ClienteDto;
import com.JeicTechnology.POS.domain.dto.ProductoDto;
import com.JeicTechnology.POS.domain.service.IClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/clientes")
public class ClienteController {

    private final IClienteService iClienteService;

    @GetMapping
    public ResponseEntity<List<ClienteDto>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(iClienteService.getAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ClienteDto> getClienteById(@PathVariable Integer id){
        return ResponseEntity.of(iClienteService.getCliente(id));
    }

    @GetMapping(path = "/name/{name}")
    public ResponseEntity<ClienteDto> getClienteByName(@PathVariable String name){
        return ResponseEntity.of(iClienteService.getClienteByName(name));
    }

    @PostMapping
    public ResponseEntity<ClienteDto> save(@RequestBody ClienteDto newClienteDto){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(iClienteService.save(newClienteDto));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PatchMapping
    public ResponseEntity<ClienteDto> update(@RequestBody ClienteDto updateClienteDto){
        return ResponseEntity.of(iClienteService.update(updateClienteDto));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer id){
        return new ResponseEntity<>(this.iClienteService.delete(id) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
