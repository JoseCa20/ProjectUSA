package com.JeicTechnology.TCB.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EnvioDto {

    private Integer id;

    private String origin;

    private String destination;

    private Double weight;

    private String state;

}
