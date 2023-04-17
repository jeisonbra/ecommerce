package com.ecommerce.ecommerce.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@Service
public class uploadFileService {

    String folder = "images://";


    public String saveImage(MultipartFile file) throws IOException {

        if(!file.isEmpty()){

            byte bytes[] = file.getBytes();
            Path patch = Paths.get(folder+file.getOriginalFilename());
            Files.write(patch,bytes);
            return file.getOriginalFilename();
        }


        return "default.jpg";
    }

    public void delete(String nombre){
        String ruta = "images//";
        File file = new File(ruta+nombre);
        file.delete();
    }



}
