package com.JeicTechnology.TCB.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "detalle_guia")
public class DetalleGuiaEntity {

    @EmbeddedId
    private DetalleGuiaPK id;

    @Column(name = "precio")
    private Double price;

    @Column(name = "cantidad")
    private Integer quantity;

    private Double subtotal;

    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "id")
    private GuiaEntity guiaEntity;

}
