package com.curso.model;

public class VueloDTO {
	
    private String compania;
    private String fechaVuelo;
    private double precio;
    private int plazas;

    // Getters and Setters
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

    public int getPlazas() {
        return plazas;
    }

    public void setPlazas(int plazas) {
        this.plazas = plazas;
    }
}
