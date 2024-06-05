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
	
	
	@GetMapping(value="hoteles", produces=MediaType.APPLICATION_JSON_VALUE)
	List<Hotel> hoteles(){
		return service.hoteles();
	}
	
	@PostMapping(value="hoteles/alta", consumes=MediaType.APPLICATION_JSON_VALUE)
	List<Hotel> alta(@RequestBody Hotel hotel){
		return service.alta(hotel);
	}
	
	@DeleteMapping(value="hoteles/eliminar/{idHotel}", produces=MediaType.APPLICATION_JSON_VALUE)
	List<Hotel> eliminar(@PathVariable int idHotel){
		return service.eliminar(idHotel);
	}
	
	@PutMapping(value="hoteles/actualizar/{idHotel}/{newCategoria}")
	void actualizarCategoria(@PathVariable("idHotel") int idHotel, @PathVariable("newCategoria") String nuevaCategoria) {
		service.actualizarCategoria(idHotel, nuevaCategoria);
	}
	
	@GetMapping(value="hoteles/disponibles", produces=MediaType.APPLICATION_JSON_VALUE)
	List<Hotel> hotelesDisponibles(){
		return service.hotelesDisponibles();
	}
	
	@GetMapping(value="hoteles/datos/{nombre}", produces=MediaType.APPLICATION_JSON_VALUE)
	Hotel datosHotel(@PathVariable String nombre){
		return service.datosHotel(nombre);
	}
	

}
