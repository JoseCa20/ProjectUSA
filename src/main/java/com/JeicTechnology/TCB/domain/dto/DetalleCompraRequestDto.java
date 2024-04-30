package com.JeicTechnology.TCB.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class DetalleCompraRequestDto {

    private Integer id_purchase;

    private Integer id_product;

    private Double price;

    private Integer quantity;

    private Double subtotal;

    private LocalDateTime date;

}
