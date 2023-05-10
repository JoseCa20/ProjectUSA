package com.JeicTechnology.POS.controller;

import com.JeicTechnology.POS.domain.dto.ProductoDto;
import com.JeicTechnology.POS.domain.service.IProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * controlador rest de producto
 */
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/productos")
public class ProductoController {

    /**
     * servicio de producto
     */
    private final IProductoService iProductoService;

    @GetMapping
    public ResponseEntity<List<ProductoDto>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(iProductoService.getAll());
        //return ResponseEntity.ok(iProductoService.getAll()); alternativa para responseEntity
        //return new ResponseEntity<>(iProductoService.getAll(), HttpStatus.OK); alternativa para responseEntity
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ProductoDto> getProducto(@PathVariable Integer id){
        return ResponseEntity.of(iProductoService.getProducto(id));
    }

    @PostMapping
    public ResponseEntity<ProductoDto> save(@RequestBody ProductoDto newProductoDto){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(iProductoService.save(newProductoDto));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PatchMapping
    public ResponseEntity<ProductoDto> update(@RequestBody ProductoDto updateProductoDto){
        return ResponseEntity.of(iProductoService.update(updateProductoDto));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer id){
        return new ResponseEntity<>(this.iProductoService.delete(id) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

}
