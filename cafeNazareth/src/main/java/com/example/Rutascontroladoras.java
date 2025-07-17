// Define el paquete donde se encuentra la clase 
package com.example; 

import 
org.springframework.web.bind.annotation.GetMapping;
import 
org.springframework.web.bind.annotation.RestController;

//Crea un controlador REST 
@RestController

// En esta clase se escribiran los metodos que  manejaran las rutas web
public class Rutascontroladoras {

    //Asocia metodos de java a rutas HTTP tipo GET (solicitar datos sin modificar --> GET)
    @GetMapping("/public")
    public String publicPage(){
        return "Bienvenido";
    }

    // Es decir que cada uno de estos metodos se activa cuando se busca en la barra /user
    @GetMapping ("/user")
    public String userPage(){
        return "Bienvenido";
    }

    @GetMapping ("/admin")
    public String adminPage(){ //Metodo
        return "Bienvenido";
    } 
}
