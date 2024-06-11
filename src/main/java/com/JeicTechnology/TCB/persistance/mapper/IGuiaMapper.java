package com.JeicTechnology.TCB.persistance.mapper;

import com.JeicTechnology.TCB.domain.dto.GuiaRequestDto;
import com.JeicTechnology.TCB.persistance.entity.GuiaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IGuiaMapper {

    @Mapping(target = "detalleGuiaRequestDtoList", ignore = true)
    GuiaRequestDto toGuiaRequestDto(GuiaEntity guiaEntity);

    @Mapping(target = "clienteEntity", ignore = true)
    @Mapping(target = "detalleGuiaEntityList", ignore = true)
    GuiaEntity toGuiaEntity(GuiaRequestDto guiaRequestDto);

    List<GuiaRequestDto> toGuiasRequestDto(List<GuiaEntity> comprasEntityList);
}
