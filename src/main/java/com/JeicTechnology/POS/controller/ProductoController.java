package com.JeicTechnology.POS.controller;

import com.JeicTechnology.POS.domain.dto.ProductoDto;
import com.JeicTechnology.POS.domain.useCase.IProductoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/productos")
public class ProductoController {

    private final IProductoUseCase iProductoUseCase;

    @GetMapping
    public ResponseEntity<List<ProductoDto>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(iProductoUseCase.getAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ProductoDto> getProducto(@PathVariable Integer id){
        return ResponseEntity.of(iProductoUseCase.getProducto(id));
    }

    @PostMapping
    public ResponseEntity<ProductoDto> save(@RequestBody ProductoDto newProductoDto){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(iProductoUseCase.save(newProductoDto));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PatchMapping
    public ResponseEntity<ProductoDto> update(@RequestBody ProductoDto updateProductoDto){
        return ResponseEntity.of(iProductoUseCase.update(updateProductoDto));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer id){
        return new ResponseEntity<>(this.iProductoUseCase.delete(id) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
