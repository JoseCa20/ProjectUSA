package com.JeicTechnology.POS.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@Entity
@Table(name = "proveedores")
public class ProveedorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nit;

    @Column(name = "proveedor")
    private String supplier;

    @Column(name = "telefono")
    private String phone_number;

    @Column(name = "direccion")
    private String addres;

    @Column(name = "estado")
    private String state;

    @ManyToMany(mappedBy = "proveedorEntityList")
    private List<ProductoEntity> productoEntityList;

    @OneToMany(mappedBy = "proveedorEntity")
    private List<CompraEntity> comprasEntity;

}
