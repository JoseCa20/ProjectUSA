package com.JeicTechnology.TCB.controller;

import com.JeicTechnology.TCB.domain.dto.EstadoEnvioDto;
import com.JeicTechnology.TCB.domain.useCase.IEstadoEnvioUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/estado-envio")
public class EstadoEnvioController {

    private final IEstadoEnvioUseCase iEstadoEnvioUseCase;

    @GetMapping
    public ResponseEntity<List<EstadoEnvioDto>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(iEstadoEnvioUseCase.getAll());
        //return ResponseEntity.ok(iProductoService.getAll()); alternativa para responseEntity
        //return new ResponseEntity<>(iProductoService.getAll(), HttpStatus.OK); alternativa para responseEntity
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<EstadoEnvioDto> getEstadoEnvio(@PathVariable Integer id){
        return ResponseEntity.of(iEstadoEnvioUseCase.getEstadoEnvio(id));
    }

    @PostMapping
    public ResponseEntity<EstadoEnvioDto> save(@RequestBody EstadoEnvioDto newEstadoEnvioDto){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(iEstadoEnvioUseCase.save(newEstadoEnvioDto));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PatchMapping
    public ResponseEntity<EstadoEnvioDto> update(@RequestBody EstadoEnvioDto updateEstadoEnvioDto){
        return ResponseEntity.of(iEstadoEnvioUseCase.update(updateEstadoEnvioDto));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer id){
        return new ResponseEntity<>(this.iEstadoEnvioUseCase.delete(id) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
