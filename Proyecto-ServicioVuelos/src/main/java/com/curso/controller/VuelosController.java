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
	
	
	@GetMapping(value="vuelos", produces=MediaType.APPLICATION_JSON_VALUE)
	List<Vuelo> vuelos(){
		return service.vuelos();
	}
	
	@PostMapping(value="vuelos/alta", consumes=MediaType.APPLICATION_JSON_VALUE)
	List<Vuelo> alta(@RequestBody Vuelo vuelo){
		return service.alta(vuelo);
	}
	
	@DeleteMapping(value="vuelos/eliminar/{idVuelo}", produces=MediaType.APPLICATION_JSON_VALUE)
	List<Vuelo> eliminar(@PathVariable int idVuelo){
		return service.eliminar(idVuelo);
	}
	
	@PutMapping(value="vuelos/actualizar/{idVuelo}/{numPlazas}", produces=MediaType.APPLICATION_JSON_VALUE)
	List<Vuelo> actualizarVuelo(@PathVariable("idVuelo") int idVuelo, @PathVariable("numPlazas") int plazas){
		return service.actualizarVuelo(idVuelo, plazas);
	}
	
	@GetMapping(value="vuelos/disponibles/{numPlazas}", produces=MediaType.APPLICATION_JSON_VALUE)
	List<Vuelo> vuelosDisponibles(@PathVariable int numPlazas){
		return service.vuelosDisponibles(numPlazas);
	}
	
	
}
