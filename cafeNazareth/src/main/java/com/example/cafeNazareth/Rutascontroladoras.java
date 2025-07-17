// Define el paquete donde se encuentra la clase 
package com.example.cafeNazareth; 

import 
org.springframework.web.bind.annotation.GetMapping;
//se usa para decirle a Spring Boot que un método debe responder a una petición HTTP tipo GET en una ruta específica.

import 
org.springframework.web.bind.annotation.RestController;
//ndica que la clase es un controlador REST, es decir, una clase que responderá a peticiones HTTP (GET, POST, etc.) con datos directamente, no con páginas HTML.

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
