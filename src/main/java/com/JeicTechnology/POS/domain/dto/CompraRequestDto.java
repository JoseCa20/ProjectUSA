package com.JeicTechnology.POS.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter @Setter
public class CompraRequestDto {

    private Integer id;

    private Integer id_supplier;

    private Double total;

    private LocalDateTime date;

    private List<DetalleCompraRequestDto> detalleCompraRequestDtoList;

}
