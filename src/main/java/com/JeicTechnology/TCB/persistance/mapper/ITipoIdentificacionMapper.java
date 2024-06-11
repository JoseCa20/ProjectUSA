package com.JeicTechnology.TCB.persistance.mapper;

import com.JeicTechnology.TCB.domain.dto.TipoIdentificacionDto;
import com.JeicTechnology.TCB.persistance.entity.TipoIdentificacionEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ITipoIdentificacionMapper {

    TipoIdentificacionDto toTipoIdentificacionDto(TipoIdentificacionEntity tipoIdentificacionEntity);


    TipoIdentificacionEntity toTipoIdentificacionEntity(TipoIdentificacionDto tipoIdentificacionDto);

    List<TipoIdentificacionDto> toTiposIdentificacionDto(List<TipoIdentificacionEntity> tipoIdentificacionEntityList);
}
