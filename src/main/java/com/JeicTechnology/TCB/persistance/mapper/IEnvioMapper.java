package com.JeicTechnology.TCB.persistance.mapper;

import com.JeicTechnology.TCB.domain.dto.EnvioDto;
import com.JeicTechnology.TCB.persistance.entity.EnvioEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IEnvioMapper {

    EnvioDto toEnvioDto(EnvioEntity envioEntity);

    //@Mapping(target = "categoriaEntity", ignore = true)
    //@Mapping(target = "detalleCompraEntity", ignore = true)
    //@Mapping(target = "proveedorEntityList", ignore = true)
    EnvioEntity toEnvioEntity(EnvioDto envioDto);

    List<EnvioDto> toEnviosDto(List<EnvioEntity> envioEntityList);
}
