package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Vuelo;
import com.curso.service.VuelosService;

@RestController
public class VuelosController {

    @Autowired
    VuelosService service;
    
    /**
     * Devuelve la lista de vuelos
     * @return lista de vuelos
     */
    @GetMapping(value="vuelos", produces=MediaType.APPLICATION_JSON_VALUE)
    List<Vuelo> vuelos(){
        return service.vuelos();
    }
    
    /**
     * Añade un nuevo vuelo y devuelve la lista actualizada de vuelos
     * @param vuelo El vuelo a añadir
     * @return lista actualizada de vuelos
     */
    @PostMapping(value="vuelos/alta", consumes=MediaType.APPLICATION_JSON_VALUE)
    List<Vuelo> alta(@RequestBody Vuelo vuelo){
        return service.alta(vuelo);
    }
    
    /**
     * Elimina un vuelo por su ID y devuelve la lista actualizada de vuelos
     * @param idVuelo El ID del vuelo a eliminar
     * @return lista actualizada de vuelos
     */
    @DeleteMapping(value="vuelos/eliminar/{idVuelo}", produces=MediaType.APPLICATION_JSON_VALUE)
    List<Vuelo> eliminar(@PathVariable int idVuelo){
        return service.eliminar(idVuelo);
    }
    
    /**
     * Actualiza el número de plazas de un vuelo por su ID y devuelve la lista actualizada de vuelos
     * @param idVuelo El ID del vuelo a actualizar
     * @param plazas El nuevo número de plazas del vuelo
     * @return lista actualizada de vuelos
     */
    @PutMapping(value="vuelos/actualizar/{idVuelo}/{numPlazas}", produces=MediaType.APPLICATION_JSON_VALUE)
    List<Vuelo> actualizarVuelo(@PathVariable("idVuelo") int idVuelo, @PathVariable("numPlazas") int plazas){
        return service.actualizarVuelo(idVuelo, plazas);
    }
    
    /**
     * Devuelve la lista de vuelos disponibles con un número específico de plazas
     * @param numPlazas El número de plazas
     * @return lista de vuelos disponibles
     */
    @GetMapping(value="vuelos/disponibles/{numPlazas}", produces=MediaType.APPLICATION_JSON_VALUE)
    List<Vuelo> vuelosDisponibles(@PathVariable int numPlazas){
        return service.vuelosDisponibles(numPlazas);
    }
}
