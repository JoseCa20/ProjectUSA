package com.JeicTechnology.TCB.controller;

import com.JeicTechnology.TCB.domain.dto.TipoIdentificacionDto;
import com.JeicTechnology.TCB.domain.useCase.ITipoIdentificacionUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/tipo-identificacion")
public class TipoIdentificacionController {

    private final ITipoIdentificacionUseCase iTipoIdentificacionUseCase;

    @GetMapping
    public ResponseEntity<List<TipoIdentificacionDto>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(iTipoIdentificacionUseCase.getAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<TipoIdentificacionDto> getTipoIdentificacion(@PathVariable Integer id){
        return ResponseEntity.of(iTipoIdentificacionUseCase.getTipoIdentificacion(id));
    }

    @PostMapping
    public ResponseEntity<TipoIdentificacionDto> save(@RequestBody TipoIdentificacionDto newTipoIdentificacionDto){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(iTipoIdentificacionUseCase.save(newTipoIdentificacionDto));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PatchMapping
    public ResponseEntity<TipoIdentificacionDto> update(@RequestBody TipoIdentificacionDto updateTipoIdentificacionDto){
        return ResponseEntity.of(iTipoIdentificacionUseCase.update(updateTipoIdentificacionDto));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer id){
        return new ResponseEntity<>(this.iTipoIdentificacionUseCase.delete(id) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
