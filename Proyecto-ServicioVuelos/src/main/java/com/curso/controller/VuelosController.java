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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="Gestion de vuelos", description="Endpoints para gestionar CRUD de vuelos")

@RestController
public class VuelosController {

	@Autowired
	VuelosService service;
	
	@Operation(summary = "Lista de los vuelos existentes.", description = "Sca la lista de vuelos existentes en la BD.")

	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "OK", content = {
					@Content(mediaType = "application/JSON", schema = @Schema(implementation = Vuelo.class)) }),
			@ApiResponse(responseCode = "401", description = "invalido lo que sea"), })
	
	
	
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
