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

import com.curso.model.Hotel;
import com.curso.service.HotelesService;

@RestController
public class HotelController {

    @Autowired
    HotelesService service;
    
    /**
     * Devuelve la lista de hoteles
     * @return lista de hoteles
     */
    @GetMapping(value="hoteles", produces=MediaType.APPLICATION_JSON_VALUE)
    List<Hotel> hoteles(){
        return service.hoteles();
    }
    
    /**
     * Añade un nuevo hotel y devuelve la lista actualizada de hoteles
     * @param hotel El hotel a añadir
     * @return lista actualizada de hoteles
     */
    @PostMapping(value="hoteles/alta", consumes=MediaType.APPLICATION_JSON_VALUE)
    List<Hotel> alta(@RequestBody Hotel hotel){
        return service.alta(hotel);
    }
    
    /**
     * Elimina un hotel por su ID y devuelve la lista actualizada de hoteles
     * @param idHotel El ID del hotel a eliminar
     * @return lista actualizada de hoteles
     */
    @DeleteMapping(value="hoteles/eliminar/{idHotel}", produces=MediaType.APPLICATION_JSON_VALUE)
    List<Hotel> eliminar(@PathVariable int idHotel){
        return service.eliminar(idHotel);
    }
    
    /**
     * Actualiza la categoría de un hotel por su ID
     * @param idHotel El ID del hotel a actualizar
     * @param nuevaCategoria La nueva categoría del hotel
     */
    @PutMapping(value="hoteles/actualizar/{idHotel}/{newCategoria}")
    void actualizarCategoria(@PathVariable("idHotel") int idHotel, @PathVariable("newCategoria") String nuevaCategoria) {
        service.actualizarCategoria(idHotel, nuevaCategoria);
    }
    
    /**
     * Devuelve la lista de hoteles disponibles
     * @return lista de hoteles disponibles
     */
    @GetMapping(value="hoteles/disponibles", produces=MediaType.APPLICATION_JSON_VALUE)
    List<Hotel> hotelesDisponibles(){
        return service.hotelesDisponibles();
    }
    
    /**
     * Devuelve los datos de un hotel por su nombre
     * @param nombre El nombre del hotel
     * @return datos del hotel
     */
    @GetMapping(value="hoteles/datos/{nombre}", produces=MediaType.APPLICATION_JSON_VALUE)
    Hotel datosHotel(@PathVariable String nombre){
        return service.datosHotel(nombre);
    }
}
