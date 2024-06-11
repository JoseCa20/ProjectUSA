package com.JeicTechnology.TCB.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@Entity
@Table(name = "envios")
public class EnvioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "origen")
    private String origin;

    @Column(name = "destino")
    private String destination;

    @Column(name = "peso")
    private Double weight;

    @Column(name = "estado")
    private String state;

    //Pendiente hacer relaciones

    //@ManyToOne
    //@JoinColumn(name = "id_categoria")
    //private EstadoEnvioEntity categoriaEntity;

    //@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    //@JoinTable(name = "producto_proveedor", joinColumns = @JoinColumn(name = "id_proveedor", referencedColumnName = "id"),
    //            inverseJoinColumns = @JoinColumn(name = "id_producto", referencedColumnName = "id"))
    //private List<TipoIdentificacionEntity> proveedorEntityList;

    //@OneToMany(mappedBy = "productosEntity")
    //private List<DetalleGuiaEntity> detalleCompraEntity;
}
