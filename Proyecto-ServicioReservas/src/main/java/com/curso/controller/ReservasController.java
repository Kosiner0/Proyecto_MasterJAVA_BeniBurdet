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

import com.curso.model.Reserva;
import com.curso.service.ReservasService;

@RestController
public class ReservasController {

    @Autowired
    ReservasService service;
    
    /**
     * Devuelve la lista de reservas
     * @return lista de reservas
     */
    @GetMapping(value="reservas", produces=MediaType.APPLICATION_JSON_VALUE)
    List<Reserva> reservas(){
        return service.reservas();
    }
    
    /**
     * Devuelve la lista de reservas para un hotel específico
     * @param nombreHotel El nombre del hotel
     * @return lista de reservas del hotel
     */
    @GetMapping(value="reservas/hotel/{nombreHotel}", produces=MediaType.APPLICATION_JSON_VALUE)
    List<Reserva> reservasHotel(@PathVariable String nombreHotel){
        return service.reservasHotel(nombreHotel);
    }
    
    /**
     * Añade una nueva reserva de vuelo para un número específico de personas y devuelve la lista actualizada de reservas
     * @param reserva La reserva a añadir
     * @param numPersonas El número de personas
     * @return lista actualizada de reservas
     */
    @PostMapping(value="reservas/alta/personas/vuelo/{numPersonas}", consumes=MediaType.APPLICATION_JSON_VALUE)
    List<Reserva> altaVuelo(@RequestBody Reserva reserva, @PathVariable int numPersonas){
        return service.altaVuelo(reserva, numPersonas);
    }
    
    /**
     * Elimina una reserva por su ID y devuelve la lista actualizada de reservas
     * @param idReserva El ID de la reserva a eliminar
     * @return lista actualizada de reservas
     */
    @DeleteMapping(value="reservas/eliminar/{idReserva}", produces=MediaType.APPLICATION_JSON_VALUE)
    List<Reserva> eliminar(@PathVariable int idReserva){
        return service.eliminar(idReserva);
    }
    
    /**
     * Actualiza el nombre de una reserva por su ID y devuelve la lista actualizada de reservas
     * @param idReserva El ID de la reserva a actualizar
     * @param newNombre El nuevo nombre de la reserva
     * @return lista actualizada de reservas
     */
    @PutMapping(value="reservas/actualizar/nombre/{idReserva}/{newNombre}", produces=MediaType.APPLICATION_JSON_VALUE)
    List<Reserva> actualizarNombre(@PathVariable("idReserva") int idReserva, @PathVariable("newNombre") String newNombre){
        return service.actualizarNombre(idReserva, newNombre);
    }
}
