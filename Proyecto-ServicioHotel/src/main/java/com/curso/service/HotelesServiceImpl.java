package com.curso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.dao.HotelDao;
import com.curso.model.Hotel;

@Service
public class HotelesServiceImpl implements HotelesService {

	@Autowired
	HotelDao dao;

	
	@Override
	public List<Hotel> hoteles() {
		return dao.findAll();
	}

	@Override
	public List<Hotel> alta(Hotel hotel) {
		dao.save(hotel);
		return dao.findAll();
	}

	@Override
	public List<Hotel> eliminar(int idHotel) {
		dao.deleteById(idHotel);
		return dao.findAll();
	}

	@Override
	public void actualizarCategoria(int idHotel, String nuevaCategoria) {
		Hotel hotel = dao.findById(idHotel).orElse(null);
		
		if(hotel != null) {
			hotel.setCategoria(nuevaCategoria);
		}
		dao.save(hotel);
	}

	@Override
	public List<Hotel> hotelesDisponibles() {
		return dao.hotelesDisponibles();
	}

	@Override
	public Hotel datosHotel(String nombre) {
		return dao.datosHotel(nombre);
	}

	
}
