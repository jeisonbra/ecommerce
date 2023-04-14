package com.ecommerce.ecommerce.models;

import jakarta.persistence.Column;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

public class usuarios {


    @Id
    @Column(name = "id")
    @Getter
    @Setter
    private long id;
    @Getter @Setter
    @Column(name = "nombres")
    private String nombres;
    @Getter @Setter
    @Column(name = "apellidos")
    private String apellidos;
    @Getter @Setter
    @Column(name = "direccion")
    private String direccion;
    @Getter @Setter
    @Column(name = "telefono")
    private String telefono;
    @Getter @Setter
    @Column(name = "usuario")
    private String usuario;
    @Getter @Setter
    @Column(name = "password")
    private String password;
    @Getter @Setter
    @Column(name = "tipo")
    private String tipo;



}
