package com.JeicTechnology.TCB.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter @Setter
public class GuiaRequestDto {

    private Integer id;

    private Integer idCard;

    private Double total;

    private LocalDateTime date;

    private List<DetalleGuiaRequestDto> detalleGuiaRequestDtoList;

}
