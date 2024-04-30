package com.JeicTechnology.TCB.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "detalle_compra")
public class DetalleCompraEntity {

    @EmbeddedId
    private DetalleCompraPK id;

    @Column(name = "precio")
    private Double price;

    @Column(name = "cantidad")
    private Integer quantity;

    private Double subtotal;

    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime date;

    @ManyToOne
    @MapsId(value = "id_purchase")
    @JoinColumn(name = "id_compra", insertable = false, updatable = false)
    private CompraEntity comprasEntity;

    @ManyToOne
    @JoinColumn(name = "id_producto", insertable = false, updatable = false)
    private ProductoEntity productosEntity;
}
