package com.curso.service;

import java.util.List;

import com.curso.model.Hotel;

public interface HotelesService {

	List<Hotel> hoteles();
	List<Hotel> alta(Hotel hotel);
	List<Hotel> eliminar(int idHotel);
	void actualizarCategoria(int idHotel, String nuevaCategoria);
	
	List<Hotel> hotelesDisponibles();
	Hotel datosHotel(String nombre);
	
}
