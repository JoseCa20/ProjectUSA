package com.JeicTechnology.POS.controller;

import com.JeicTechnology.POS.domain.pojo.ProductoPojo;
import com.JeicTechnology.POS.domain.service.IProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<List<ProductoPojo>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(iProductoService.getAll());
        //return ResponseEntity.ok(iProductoService.getAll()); alternativa para responseEntity
        //return new ResponseEntity<>(iProductoService.getAll(), HttpStatus.OK); alternativa para responseEntity
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ProductoPojo> getProducto(@PathVariable Integer id){
        return ResponseEntity.of(iProductoService.getProducto(id));
    }

    @PostMapping
    public ResponseEntity<ProductoPojo> save(@RequestBody ProductoPojo newProductoPojo){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(iProductoService.save(newProductoPojo));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PatchMapping
    public ResponseEntity<ProductoPojo> update(@RequestBody ProductoPojo updateProductoPojo){
        return ResponseEntity.of(iProductoService.update(updateProductoPojo));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer id){
        return new ResponseEntity<>(this.iProductoService.delete(id) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

}
