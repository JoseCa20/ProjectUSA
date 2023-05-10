package com.JeicTechnology.POS.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteDto {
    private Integer id;
    private String name;
    private String phone_number;
    private String addres;
    private String active;
}
