package com.JeicTechnology.TCB.persistance.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter @Setter
@Embeddable
public class DetalleCompraPK implements Serializable {

    @Serial
    private static final Long serialVersionUID = -2145479604343286721L;

    @Column(name = "id_compra")
    private Integer id_purchase;

    @Column(name = "id_producto")
    private Integer id_product;
}
