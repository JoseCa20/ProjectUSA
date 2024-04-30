package com.JeicTechnology.TCB.controller;

import com.JeicTechnology.TCB.domain.dto.CategoriaDto;
import com.JeicTechnology.TCB.domain.useCase.ICategoriaUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/categorias")
public class CategoriaController {

    private final ICategoriaUseCase iCategoriaUseCase;

    @GetMapping
    public ResponseEntity<List<CategoriaDto>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(iCategoriaUseCase.getAll());
        //return ResponseEntity.ok(iProductoService.getAll()); alternativa para responseEntity
        //return new ResponseEntity<>(iProductoService.getAll(), HttpStatus.OK); alternativa para responseEntity
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<CategoriaDto> getCategoria(@PathVariable Integer id){
        return ResponseEntity.of(iCategoriaUseCase.getCategoria(id));
    }

    @PostMapping
    public ResponseEntity<CategoriaDto> save(@RequestBody CategoriaDto newCategoriaDto){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(iCategoriaUseCase.save(newCategoriaDto));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PatchMapping
    public ResponseEntity<CategoriaDto> update(@RequestBody CategoriaDto updateCategoriaDto){
        return ResponseEntity.of(iCategoriaUseCase.update(updateCategoriaDto));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer id){
        return new ResponseEntity<>(this.iCategoriaUseCase.delete(id) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
