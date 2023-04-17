package com.ecommerce.ecommerce.controllers;

import com.ecommerce.ecommerce.models.productos;
import com.ecommerce.ecommerce.models.usuarios;
import com.ecommerce.ecommerce.services.uploadFileService;
import org.slf4j.*;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.stereotype.Controller;
import com.ecommerce.ecommerce.services.productoService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Controller
@RequestMapping("/productos")
public class productoController {


    private final Logger LOGGER = LoggerFactory.getLogger(productoController.class);

    @Autowired
    private productoService productoService;

    @Autowired
    private uploadFileService uploadFileService;


    /**
     *
     * @param model se usa para poder mostrar
     *              los datos en la vista
     *
     */

    @GetMapping("") //nos indica la direccion que abrira, mapeamos
    public String show(Model model){
        model.addAttribute("productos",productoService.findAll()); //obtenmos todos los datos de los productos y usamos model para mostrarlo en html
        return "administrador/productos/show";//redireccionamos a la plantilla html
    }

    @GetMapping("/create")
    public String create(){
        return "administrador/productos/create";
    } //nos direcciona a la plantilla create

    @PostMapping("/save")
    /**
     * @RequestParam : lo usamos para especificar a que id de la vista nos referimos, para obtener el valor que esta tenga
     * MultiPartFile : sirve para enviar archivos desde html a la parte del BackEnd
     */
    public String save(productos producto,@RequestParam("img") MultipartFile file) throws IOException {
        usuarios u= new usuarios(1,"","","","","","",""); //se usa temporalmente para indicar la sesion de un usuario
        producto.setUsuarios(u);
        //imagen
        if(producto.getId() == null){ //opcion si na variable file no es vacia
            String nombreImagen = uploadFileService.saveImage(file); //enviamos el nombre de la imagen al servicio saveImage()
            producto.setImagen(nombreImagen); //despues de obtener el nombre pasamos el nombre a la clase producto por metodo SET
        }else{

        }
        productoService.save(producto); //utiliamos el metodo save() para guardar el producto junto con la imagen a la base de datos
        return "redirect:/productos"; //redireccion a la vista producto
    }


        @GetMapping("/edit/{id}")
        /**
         * @PatchVariable : se usa para pasar la imagen desde la url a el backend
         * Model : nos permite pasar los datod de una consulta de la base de datos a la vista a travez de una lista
         */
        public String edit(@PathVariable Integer id, Model model){
            productos productos = new productos();
            /**
             * Lista Optional, en caso de no encontrar los datos buscados a travez de la id ingresada
             * se usa el servicio producto service para obtener los datos desde la base de datos a travez de la id
             */
            Optional<productos> optionalProductos = productoService.get(id);
            productos = optionalProductos.get(); //pasamos los datos a la clase productos
            model.addAttribute("productoModel", productos); //asignamos los datos a la variable produtoModel para manejarlos en la vista html


            return "administrador/productos/edit";
        }

        @PostMapping("/update")
        /**
         *@RequestParam : lo usamos para especificar a que id de la vista nos referimos, para obtener el valor que esta tenga
         * MultiPartFile : sirve para enviar archivos desde html a la parte del BackEnd
         */
        public String update(productos productos,@RequestParam("img") MultipartFile file) throws IOException {
            LOGGER.info("estos son los datos {}",file); //mustra por consola del servidor los datos que deseamos, asi evitamos mostrarlos en el navegador


            if(file.isEmpty()){//editamos el producto pero no cambiamos la imagen
                productos p=new productos();
                /**
                 * asiganos a p los datos del producto, consultandolos desde la base de datos
                 * con la funcion get() desde el servicio produtoService
                 */
                p = productoService.get(productos.getId()).get();
                productos.setImagen(p.getImagen()); //asignamos el valor(nombre) de la imagen a la clase productos
            }else{
                productos p=new productos();
                p = productoService.get(productos.getId()).get();
                if(!p.getImagen().equals("default.jpg")) { //si el nombre de la imagen que deseamos guardar no es igual al que ya tenia se guarda la ingresada
                    String nombreImagen = uploadFileService.saveImage(file); //se obtiene el nombre original de la imagen ingresada
                    productos.setImagen(nombreImagen); //se guarda el nombre de la imagen a la clase productos
                }
            }
        productoService.update(productos); //se ejjecura la funcion actualizar desde el servicio productoService
        return "redirect:/productos";
        }

        @GetMapping("/delete/{id}")
        /**
         *  @PathVariable : se usa para obneter el valor enviado desde la url
         */
        public String delete(@PathVariable Integer id){

        productos p=new productos();
        p = productoService.get(id).get(); //se obtienen los datos del producto con el id desde la base de datos
        //Eliminar cuando la imagen no sea la imagen por defecto
            /**
             * si el nombre de la imagen es diferente a "defaul.jpg", entonces la imagen se elimina de la carpeta imagen del proyecto
             * asi se evita eliminar la imagen por defecto
             */
        if(!p.getImagen().equals("default.jpg")){ //
            uploadFileService.deleteImage(p.getImagen());//se elimina la imagen desde la funcion deleteImagen en el servicio uploadFileService
        }
        productoService.delete(id); //se eliminan los datos de la base de datos a traves de la id ingresada por parametro
        return "redirect:/productos";// se direcciona a la vista productos
        }



}
