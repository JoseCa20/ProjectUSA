package com.JeicTechnology.POS.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "clientes")
@Getter
@Setter
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre")
    private String name;

    @Column(name = "telefono")
    private String phone_number;

    @Column(name = "direccion")
    private String addres;

    @Column(name = "estado")
    private String active;
}
