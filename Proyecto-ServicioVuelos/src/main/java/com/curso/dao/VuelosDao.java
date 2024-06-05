package com.curso.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.curso.model.Vuelo;

public interface VuelosDao extends JpaRepository<Vuelo, Integer> {

	@Query("SELECT v FROM Vuelo v WHERE v.plazasDisponibles >= :numPlazas")
	List<Vuelo> vuelosDisponibles(int numPlazas);
	
	
}
