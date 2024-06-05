package com.curso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.curso.dao.ReservasDao;
import com.curso.model.HotelDto;
import com.curso.model.Reserva;

@Service
public class ReservasServiceImpl implements ReservasService {

	@Autowired
	ReservasDao dao;
	
	@Autowired
	RestTemplate restTemplate;
	
	private final static String urlHoteles = "http://localhost:8080/";
	private final static String urlVuelos = "http://localhost:8081/";
	
	
	@Override
	public List<Reserva> reservas() {
		return dao.findAll();
	}

	@Override
	public List<Reserva> reservasHotel(String nombreHotel) {
		HotelDto hotel = restTemplate.getForObject(urlHoteles + "hoteles/datos/{nombre}", HotelDto.class, nombreHotel);
		return dao.reservasHotel(hotel.getIdHotel());
	}
	
	@Override
	public List<Reserva> altaVuelo(Reserva reserva, int numPersonas) {
		dao.save(reserva);
		restTemplate.put(urlVuelos + "vuelos/actualizar/{idVuelo}/{numPlazas}", null, reserva.getIdVuelo(), numPersonas);
		
		return dao.findAll();
	}

	@Override
	public List<Reserva> eliminar(int idReserva) {
		dao.deleteById(idReserva);
		return dao.findAll();
	}

	@Override
	public List<Reserva> actualizarNombre(int idReserva, String newNombre) {
		Reserva reserva = dao.reservaPorId(idReserva);
		reserva.setNombreCliente(newNombre);
		dao.save(reserva);
		
		return dao.findAll();
	}
	

}
