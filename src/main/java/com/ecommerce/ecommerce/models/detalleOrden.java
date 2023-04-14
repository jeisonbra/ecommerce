package com.ecommerce.ecommerce.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity @Table(name = "detalleorden")
@AllArgsConstructor @ToString
public class detalleOrden {




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Getter
    @Setter
    private long id;
    @Column(name = "nombe") @Getter @Setter
    private String nombre;
    @Column(name = "cantidad") @Getter @Setter
    private String cantidad;
    @Column(name = "precio") @Getter @Setter
    private String precio;
    @Column(name = "total") @Getter @Setter
    private String total;
    @Column(name = "total1") @Getter @Setter
    private String total1;

    @Getter @Setter
    @OneToOne
    private orden orden;
    @Getter @Setter
    @OneToOne()
    private productos productos;
}
