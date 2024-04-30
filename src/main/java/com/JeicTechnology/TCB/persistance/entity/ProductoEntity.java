package com.JeicTechnology.TCB.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@Entity
@Table(name = "productos")
public class ProductoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "codigo")
    private String code;

    @Column(name = "descripcion")
    private String description;

    @Column(name = "cantidad")
    private Integer quantity;

    @Column(name = "precio_compra")
    private Double purchase_price;

    @Column(name = "precio_venta")
    private Double sale_price;

    @Column(name = "estado")
    private String state;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private CategoriaEntity categoriaEntity;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(name = "producto_proveedor", joinColumns = @JoinColumn(name = "id_proveedor", referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name = "id_producto", referencedColumnName = "id"))
    private List<ProveedorEntity> proveedorEntityList;

    @OneToMany(mappedBy = "productosEntity")
    private List<DetalleCompraEntity> detalleCompraEntity;
}
