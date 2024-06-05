package com.curso.service;

import java.util.List;

import com.curso.model.Vuelo;

public interface VuelosService {

	List<Vuelo> vuelos();
	List<Vuelo> alta(Vuelo vuelo);
	List<Vuelo> eliminar(int idVuelo);
	
	List<Vuelo> actualizarVuelo(int idVuelo, int plazas);
	List<Vuelo> vuelosDisponibles(int numPlazas);
	
}
