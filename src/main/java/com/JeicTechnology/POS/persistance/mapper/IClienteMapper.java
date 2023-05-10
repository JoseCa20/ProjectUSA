package com.JeicTechnology.POS.persistance.mapper;

import com.JeicTechnology.POS.domain.dto.ClienteDto;
import com.JeicTechnology.POS.domain.dto.ProductoDto;
import com.JeicTechnology.POS.persistance.entity.ClienteEntity;
import com.JeicTechnology.POS.persistance.entity.ProductoEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IClienteMapper {

    ClienteDto toClienteDto(ClienteEntity clienteEntity);

    ClienteEntity toClienteEntity(ClienteDto clienteDto);

    List<ClienteDto> toClientesDto(List<ClienteEntity> clienteEntityList);
}
