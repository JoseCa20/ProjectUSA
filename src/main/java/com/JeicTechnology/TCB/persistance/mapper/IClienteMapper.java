package com.JeicTechnology.TCB.persistance.mapper;

import com.JeicTechnology.TCB.domain.dto.ClienteDto;
import com.JeicTechnology.TCB.persistance.entity.ClienteEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IClienteMapper {

    @InheritInverseConfiguration
    ClienteDto toClienteDto(ClienteEntity clienteEntity);

    @Mapping(target = "guiaEntity", ignore = true)
    ClienteEntity toClienteEntity(ClienteDto clienteDto);

    List<ClienteDto> toClientesDto(List<ClienteEntity> clienteEntityList);
}
