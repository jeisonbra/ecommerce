package com.ecommerce.ecommerce.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity //Anotacion que especifica a esta clase como entidad
@Table(name = "productos") // entidad que asigna un nombre a la tabla
//anotaciones de lombok para creat los metodos contructor y ToString
public class productos {
    public productos() {
    }

    public productos(Integer id, String nombre, String descripcion, String imagen, String precio, String cantidad, com.ecommerce.ecommerce.models.usuarios usuarios) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.precio = precio;
        this.cantidad = cantidad;
        this.usuarios = usuarios;
    }

    @Id //anotacion que especifica que este atributo es la llave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) //anotacion que especifica que la llave primaria será autoincrementable
    @Column(name = "id") //anotacion para especificar el nombre de la columna
    @Getter @Setter
    private Integer id;
    @Column(name = "nombre")
    @Getter @Setter //anotacion de lombok para crear metodos Setter y Getter
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
    @ManyToOne() //Anotacion mpara especificar la relacion de muchos a uno
    private  usuarios usuarios;


    @Override
    public String toString() {
        return "productos{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", imagen='" + imagen + '\'' +
                ", precio='" + precio + '\'' +
                ", cantidad='" + cantidad + '\'' +
                '}';
    }
}
