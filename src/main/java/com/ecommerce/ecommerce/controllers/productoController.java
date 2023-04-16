package com.ecommerce.ecommerce.controllers;

import com.ecommerce.ecommerce.models.productos;
import com.ecommerce.ecommerce.models.usuarios;
import org.slf4j.*;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.ecommerce.ecommerce.services.productoService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/productos")
public class productoController {


    private final Logger LOGGER = LoggerFactory.getLogger(productoController.class);

    @Autowired
    private productoService productoService;


    /**
     *
     * @param model se usa para poder mostrar
     *              los datos en la vista
     *
     */

    @GetMapping("")
    public String show(Model model){
        model.addAttribute("productos",productoService.findAll());
        return "administrador/productos/show";
    }

    @GetMapping("/create")
    public String create(){
        return "administrador/productos/create";
    }

    @PostMapping("/save")
    public String save(productos producto){
    LOGGER.info("Este es un producto {}",producto);

        usuarios u= new usuarios(1,"","","","","","","");
        producto.setUsuarios(u);
        productoService.save(producto);
        return "redirect:/productos";
    }
}
