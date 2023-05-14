package com.JeicTechnology.POS.controller;

import com.JeicTechnology.POS.domain.dto.ProveedorDto;
import com.JeicTechnology.POS.domain.useCase.IProveedorUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/proveedores")
public class ProveedorController {

    private final IProveedorUseCase iProveedorUseCase;

    @GetMapping
    public ResponseEntity<List<ProveedorDto>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(iProveedorUseCase.getAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ProveedorDto> getProveedor(@PathVariable Integer id){
        return ResponseEntity.of(iProveedorUseCase.getProveedor(id));
    }

    @PostMapping
    public ResponseEntity<ProveedorDto> save(@RequestBody ProveedorDto newProductoDto){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(iProveedorUseCase.save(newProductoDto));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PatchMapping
    public ResponseEntity<ProveedorDto> update(@RequestBody ProveedorDto updateProveedorDto){
        return ResponseEntity.of(iProveedorUseCase.update(updateProveedorDto));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer id){
        return new ResponseEntity<>(this.iProveedorUseCase.delete(id) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
