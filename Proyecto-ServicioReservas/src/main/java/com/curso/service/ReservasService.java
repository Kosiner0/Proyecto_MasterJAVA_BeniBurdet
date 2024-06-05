package com.curso.service;

import java.util.List;

import com.curso.model.Reserva;

public interface ReservasService {

	List<Reserva> reservas();
	List<Reserva> reservasHotel(String nombreHotel);
	List<Reserva> altaVuelo(Reserva reserva, int numPersonas);
	List<Reserva> eliminar(int idReserva);
	List<Reserva> actualizarNombre(int idReserva, String newNombre);
	
}
