package com.curso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.curso.model.Vuelo;
import com.curso.model.VueloDTO;
import com.curso.service.VuelosService;

@Controller
public class VistasController {

    @Autowired
    private VuelosService vuelosService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/listar")
    public String listarVuelos(Model model) {
        model.addAttribute("vuelos", vuelosService.vuelos());
        return "listar";
    }
    
    @GetMapping("/altaVuelo")
    public String mostrarFormularioAlta(Model model) {
        model.addAttribute("vueloDTO", new VueloDTO());
        return "altaVuelo";
    }

    @PostMapping("/altaVuelo")
    public String altaVuelos(@ModelAttribute VueloDTO vueloDTO, Model model) {
    	Vuelo vuelo = new Vuelo();
    	vuelo.setCompania(vueloDTO.getCompania());
    	vuelo.setFechaVuelo(vueloDTO.getFechaVuelo());
    	vuelo.setPrecio(vueloDTO.getPrecio());
    	vuelo.setPlazasDisponibles(vueloDTO.getPlazas());
    	
        vuelosService.alta(vuelo);
        return "redirect:/listar"; 
    }
}
