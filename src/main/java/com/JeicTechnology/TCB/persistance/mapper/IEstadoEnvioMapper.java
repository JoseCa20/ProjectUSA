package com.JeicTechnology.TCB.persistance.mapper;

import com.JeicTechnology.TCB.domain.dto.EstadoEnvioDto;
import com.JeicTechnology.TCB.persistance.entity.EstadoEnvioEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IEstadoEnvioMapper {

    EstadoEnvioDto toEstadoEnvioDto(EstadoEnvioEntity estadoEnvioEntity);

    EstadoEnvioEntity toEstadoEnvioEntity(EstadoEnvioDto estadoEnvioDto);

    List<EstadoEnvioDto> toEstadosEnvioDto(List<EstadoEnvioEntity> estadoEnvioEntityList);
}
