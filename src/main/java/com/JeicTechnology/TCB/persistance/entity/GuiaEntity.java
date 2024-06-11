package com.JeicTechnology.TCB.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "guia_entity")
public class GuiaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "id_cliente")
    private Integer id_customer;

    private Double total;

    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime date;


    @ManyToOne
    @JoinColumn(name = "id_cliente", insertable = false, updatable = false)
    private ClienteEntity clienteEntity;

    @OneToMany(mappedBy = "guiaEntity", cascade = {CascadeType.ALL})
    private List<DetalleGuiaEntity> detalleGuiaEntityList;
}
