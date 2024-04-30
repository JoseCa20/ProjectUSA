package com.JeicTechnology.TCB.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "clientes")
public class ClienteEntity {

    @Id
    @Column(name = "cedula", nullable = false)
    private Integer idCard;

    @Column(name = "nombre")
    private String name;

    @Column(name = "telefono")
    private String phone_number;

    @Column(name = "direccion")
    private String addres;

    @Column(name = "correo")
    private String email;

    @Column(name = "clave")
    private String password;

    private String rol;

    @Column(name = "estado")
    private String active;
}
