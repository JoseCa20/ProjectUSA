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
    @GeneratedValue()
    @Column(name = "cedula", nullable = false, unique = true)
    private String idCard;

    @Column(name = "nombre")
    private String name;

    @Column(name = "telefono")
    private String phone_number;

    @Column(name = "direccion")
    private String addres;

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
