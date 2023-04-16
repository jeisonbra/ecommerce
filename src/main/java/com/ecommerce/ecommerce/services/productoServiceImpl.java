package com.ecommerce.ecommerce.services;

import com.ecommerce.ecommerce.models.productos;
import com.ecommerce.ecommerce.repository.productoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


/**
 * Esta es una clase, se utiliza para implementar los metodos
 * que se crearon en la interfaz de servicio, estos metodos
 * estan inyectador (Autowire) desde la interfaz del repositorio
 * que a su vez la interfaz de repositorio extiende de la libreria
 * JPArepositorio
 */
@Service
public class productoServiceImpl implements productoService{


    @Autowired
    productoRepository productoRepository;
    @Override
    public productos save(productos productos) {
        return productoRepository.save(productos);
    }

    @Override
    public Optional<productos> get(Integer id) {
        return productoRepository.findById(id);
    }

    @Override
    public void update(productos productos) {
           productoRepository.save(productos);
    }

    @Override
    public void delete(Integer id) {
          productoRepository.deleteById(id);
    }

    @Override
    public List<productos> findAll() {
        return productoRepository.findAll();
    }
}
