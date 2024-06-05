package com.curso.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.curso.model.Reserva;

public interface ReservasDao extends JpaRepository<Reserva, Integer> {

	@Query("SELECT r FROM Reserva r WHERE r.idReserva = :codRes")
	Reserva reservaPorId(int codRes);
	
	@Query("SELECT r FROM Reserva r WHERE r.idHotel = :codHotel")
	List<Reserva> reservasHotel(int codHotel);
	
}
