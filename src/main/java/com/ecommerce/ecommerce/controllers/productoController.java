package com.ecommerce.ecommerce.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/productos")
public class productoController {
    @GetMapping("")
    public String show(){
        return "administrador/productos/show";
    }
}
