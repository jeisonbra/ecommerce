package com.ecommerce.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ecommerce.ecommerce.models.productos;


/**
 * Esta es una interfaz, se utiliza para extender de la libreria JPA los metodos
 * a utilizar en los servicios
 */
@Repository
public interface productoRepository extends JpaRepository<productos, Integer> {

}
