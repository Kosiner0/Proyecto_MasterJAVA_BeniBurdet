package com.curso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.dao.VuelosDao;
import com.curso.model.Vuelo;

@Service
public class VuelosServiceImpl implements VuelosService {

	@Autowired
	VuelosDao dao;
	
	
	@Override
	public List<Vuelo> vuelos(){
		return dao.findAll();
	}

	@Override
	public List<Vuelo> alta(Vuelo vuelo){
		dao.save(vuelo);
		return dao.findAll();
	}

	@Override
	public List<Vuelo> eliminar(int idVuelo){
		dao.deleteById(idVuelo);
		return dao.findAll();
	}

	@Override
	public List<Vuelo> actualizarVuelo(int idVuelo, int plazas){
		List<Vuelo> vuelosDisp = vuelosDisponibles(plazas);
		
		for(Vuelo v : vuelosDisp) {
			if(v.getIdVuelo() == idVuelo) {
				v.setPlazasDisponibles(v.getPlazasDisponibles() - plazas);
				dao.save(v);
			}
		}
		
		return dao.findAll();
	}

	@Override
	public List<Vuelo> vuelosDisponibles(int numPlazas){
		return dao.vuelosDisponibles(numPlazas);
	}

}
