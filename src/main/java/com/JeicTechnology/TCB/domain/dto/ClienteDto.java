package com.JeicTechnology.TCB.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteDto {

    private Integer idCard;
    private String fullName;
    private String cellphone;
    private String address;
    private String email;
    private String password;
    private String rol;
    private String active;

}
