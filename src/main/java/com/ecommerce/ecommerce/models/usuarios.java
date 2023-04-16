package com.ecommerce.ecommerce.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.beans.ConstructorProperties;
import java.util.List;

@Entity
@ToString
@Table(name = "usuarios")
public class usuarios {


    public usuarios(long id, String nombres, String apellidos, String direccion, String telefono, String usuario, String password, String tipo) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono = telefono;
        this.usuario = usuario;
        this.password = password;
        this.tipo = tipo;
    }

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
