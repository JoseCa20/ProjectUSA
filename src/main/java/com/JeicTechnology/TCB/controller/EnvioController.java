package com.JeicTechnology.TCB.controller;

import com.JeicTechnology.TCB.domain.dto.EnvioDto;
import com.JeicTechnology.TCB.domain.useCase.IEnvioUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/envios")
public class EnvioController {

    private final IEnvioUseCase iEnvioUseCase;

    @GetMapping
    public ResponseEntity<List<EnvioDto>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(iEnvioUseCase.getAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<EnvioDto> getEnvio(@PathVariable Integer id){
        return ResponseEntity.of(iEnvioUseCase.getEnvio(id));
    }

    @PostMapping
    public ResponseEntity<EnvioDto> save(@RequestBody EnvioDto newEnvioDto){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(iEnvioUseCase.save(newEnvioDto));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PatchMapping
    public ResponseEntity<EnvioDto> update(@RequestBody EnvioDto updateEnvioDto){
        return ResponseEntity.of(iEnvioUseCase.update(updateEnvioDto));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer id){
        return new ResponseEntity<>(this.iEnvioUseCase.delete(id) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
