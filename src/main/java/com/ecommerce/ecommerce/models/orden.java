package com.ecommerce.ecommerce.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "orden")
@AllArgsConstructor @ToString
public class orden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    @Column(name = "id")
    private long id;
    @Getter @Setter @Column(name = "numero")
    private String numero;
    @Getter @Setter @Column(name = "fechaDeCreacion")
    private String fechaDeCreacion;
    @Getter @Setter @Column(name = "fechaRecibida")
    private String fechaRecibida;

    @Getter @Setter
    @ManyToOne
    private usuarios usuarios;
    @Getter @Setter
    @OneToOne
    private detalleOrden detalleOrden;

}
