package com.JeicTechnology.POS.persistance.mapper;

import com.JeicTechnology.POS.domain.dto.ClienteDto;
import com.JeicTechnology.POS.persistance.entity.ClienteEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IClienteMapper {

    ClienteDto toClienteDto(ClienteEntity clienteEntity);

    ClienteEntity toClienteEntity(ClienteDto clienteDto);

    List<ClienteDto> toClientesDto(List<ClienteEntity> clienteEntityList);
}
