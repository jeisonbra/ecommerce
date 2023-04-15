package com.ecommerce.ecommerce.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@ToString @AllArgsConstructor
@Table(name = "usuarios")
public class usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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



    @Getter @Setter
    @OneToMany(mappedBy = "usuarios")
    private List<productos> productos;
    @Getter @Setter
    @OneToMany(mappedBy = "usuarios") //anotacion de uno a muchos
    private List<orden> orden;






}
