package com.JeicTechnology.TCB.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@Entity
@Table(name = "clientes")
public class ClienteEntity {

    @Id()
    @Column(name = "cedula", nullable = false, unique = true)
    private Integer idCard;

    @Column(name = "nombre")
    private String fullName;

    @Column(name = "telefono")
    private String cellphone;

    @Column(name = "direccion")
    private String address;

    @Column(name = "correo", unique = true)
    private String email;

    @Column(name = "clave")
    private String password;

    private String rol;

    @Column(name = "estado")
    private String active;

    @OneToMany(mappedBy = "clienteEntity")
    private List<GuiaEntity> guiaEntity;
}
