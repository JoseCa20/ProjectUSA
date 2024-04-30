package com.JeicTechnology.TCB.persistance.mapper;

import com.JeicTechnology.TCB.domain.dto.ProveedorDto;
import com.JeicTechnology.TCB.persistance.entity.ProveedorEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IProveedorMapper {

    ProveedorDto toProveedorDto(ProveedorEntity proveedorEntity);

    @Mapping(target = "productoEntityList", ignore = true)
    @Mapping(target = "comprasEntity", ignore = true)
    ProveedorEntity toProveedorEntity(ProveedorDto proveedorDto);

    List<ProveedorDto> toProveedoresDto(List<ProveedorEntity> proveedorEntities);
}
