package com.JeicTechnology.TCB.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DetalleGuiaRequestDto {

    private Integer id;

    private String description;

    private int quantity;

    private double weight;

    private double price;

}
