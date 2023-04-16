package com.ecommerce.ecommerce.services;

import com.ecommerce.ecommerce.models.productos;

import java.util.List;
import java.util.Optional;


/**
 * Esta es una interfaz, se utiliza para declarar los metodos a usar
 * en el servicio
 */
public interface productoService {

    public productos save(productos productos);
    public Optional<productos> get(Integer id);

    public void update(productos productos);
    public void delete(Integer id);
    public List<productos> findAll();
}