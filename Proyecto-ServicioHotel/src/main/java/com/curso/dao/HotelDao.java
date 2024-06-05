package com.curso.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.curso.model.Hotel;

public interface HotelDao extends JpaRepository<Hotel, Integer> {

	
	@Query("SELECT h FROM Hotel h WHERE h.disponible = true")
	List<Hotel> hotelesDisponibles();
	
	@Query("SELECT h FROM Hotel h WHERE h.nombre = :nombre")
	Hotel datosHotel(String nombre);
	
}
