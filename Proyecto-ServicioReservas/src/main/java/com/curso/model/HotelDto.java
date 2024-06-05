package com.curso.model;

import java.util.Objects;


public class HotelDto {


	private int idHotel;
	private String nombre;
	private String categoria;
	private double precio;
	private boolean disponible;
	
	
	public HotelDto() {
		super();
	}

	public HotelDto(String nombre, String categoria, double precio, boolean disponible) {
		super();
		this.nombre = nombre;
		this.categoria = categoria;
		this.precio = precio;
		this.disponible = disponible;
	}

	public HotelDto(int idHotel, String nombre, String categoria, double precio, boolean disponible) {
		super();
		this.idHotel = idHotel;
		this.nombre = nombre;
		this.categoria = categoria;
		this.precio = precio;
		this.disponible = disponible;
	}

	public int getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(int idHotel) {
		this.idHotel = idHotel;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idHotel);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HotelDto other = (HotelDto) obj;
		return idHotel == other.idHotel;
	}
	
}
