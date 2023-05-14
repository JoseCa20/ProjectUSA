package com.JeicTechnology.POS.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProductoDto {

    private Integer id;

    private String code;

    private String description;

    private Integer quantity;

    private Double purchase_price;

    private Double sale_price;

    private String state;

}
