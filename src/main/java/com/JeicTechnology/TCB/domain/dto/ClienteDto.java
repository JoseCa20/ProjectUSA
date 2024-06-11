package com.JeicTechnology.TCB.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteDto {

    private String idCard;
    private String name;
    private String phone_number;
    private String addres;
    private String email;
    private String password;
    private String rol;
    private String active;

}
