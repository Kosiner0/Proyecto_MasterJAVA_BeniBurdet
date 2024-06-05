package com.curso.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="vuelos")
public class Vuelo {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_vuelo")
	private int idVuelo;
	private String compania;
	@Column(name="fecha_vuelo")
	private String fechaVuelo;
	private double precio;
	@Column(name="plazas_disponibles")
	private int plazasDisponibles;
	
	
	public Vuelo() {
		super();
	}

	public Vuelo(String compania, String fechaVuelo, double precio, int plazasDisponibles) {
		super();
		this.compania = compania;
		this.fechaVuelo = fechaVuelo;
		this.precio = precio;
		this.plazasDisponibles = plazasDisponibles;
	}

	public Vuelo(int idVuelo, String compania, String fechaVuelo, double precio, int plazasDisponibles) {
		super();
		this.idVuelo = idVuelo;
		this.compania = compania;
		this.fechaVuelo = fechaVuelo;
		this.precio = precio;
		this.plazasDisponibles = plazasDisponibles;
	}

	public int getIdVuelo() {
		return idVuelo;
	}

	public void setIdVuelo(int idVuelo) {
		this.idVuelo = idVuelo;
	}

	public String getCompania() {
		return compania;
	}

	public void setCompania(String compania) {
		this.compania = compania;
	}

	public String getFechaVuelo() {
		return fechaVuelo;
	}

	public void setFechaVuelo(String fechaVuelo) {
		this.fechaVuelo = fechaVuelo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getPlazasDisponibles() {
		return plazasDisponibles;
	}

	public void setPlazasDisponibles(int plazasDisponibles) {
		this.plazasDisponibles = plazasDisponibles;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idVuelo);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vuelo other = (Vuelo) obj;
		return idVuelo == other.idVuelo;
	}
	
	
	
}
