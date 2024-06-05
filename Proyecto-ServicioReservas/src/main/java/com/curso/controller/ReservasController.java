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
	
	
	@GetMapping(value="reservas", produces=MediaType.APPLICATION_JSON_VALUE)
	List<Reserva> reservas(){
		return service.reservas();
	}
	
	@GetMapping(value="reservas/hotel/{nombreHotel}", produces=MediaType.APPLICATION_JSON_VALUE)
	List<Reserva> reservasHotel(@PathVariable String nombreHotel){
		return service.reservasHotel(nombreHotel);
	}
	
	@PostMapping(value="reserva/alta/personas/vuelo/{numPersonas}", consumes=MediaType.APPLICATION_JSON_VALUE)
	List<Reserva> altaVuelo(@RequestBody Reserva reserva, @PathVariable int numPersonas){
		return service.altaVuelo(reserva, numPersonas);
	}
	
	@DeleteMapping(value="reservas/eliminar/{idReserva}", produces=MediaType.APPLICATION_JSON_VALUE)
	List<Reserva> eliminar(@PathVariable int idReserva){
		return service.eliminar(idReserva);
	}
	
	@PutMapping(value="reservas/actualizar/nombre/{idReserva}/{newNombre}")
	List<Reserva> actualizarNombre(@PathVariable("idReserva") int idReserva, @PathVariable("newNombre") String newNombre){
		return service.actualizarNombre(idReserva, newNombre);
	}
	
	
}
