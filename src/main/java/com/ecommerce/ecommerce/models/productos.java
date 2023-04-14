package com.ecommerce.ecommerce.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "productos")
@AllArgsConstructor @ToString
public class productos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "nombre")
    @Getter @Setter
    private String nombre;
    @Getter @Setter
    @Column(name = "descripcion")
    private String descripcion;
    @Getter @Setter
    @Column(name = "imagen")
    private String imagen;
    @Getter @Setter
    @Column(name = "precio")
    private String precio;
    @Getter @Setter
    @Column(name = "cantidad")
    private  String cantidad;

    @Getter @Setter
    @ManyToOne()
    private  usuarios usuarios;

}
