package com.curso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.curso.model.Vuelo;
import com.curso.service.VuelosService;

@Controller
public class VueloControllerView {

    @Autowired
    VuelosService service;

    @GetMapping("/")
    public String inicio() {
        return "index";
    }

    @GetMapping("/vuelos/lista")
    public String listaVuelos(Model model) {
        model.addAttribute("vuelos", service.vuelos());
        return "lista";
    }

    @GetMapping("/vuelos/nuevo")
    public String nuevoVueloForm(Model model) {
    	model.addAttribute("vuelo", new Vuelo());
        return "nuevo";
    }

    @PostMapping("/vuelos/nuevo")
    public String nuevoVueloSubmit(@ModelAttribute Vuelo vuelo, Model model) {
        service.alta(vuelo);
        return "redirect:/vuelos/lista";
    }
    
    @GetMapping("/vuelos/eliminar")
    public String eliminarVueloForm() {
        return "eliminar";
    }

    @PostMapping("/vuelos/eliminar")
    public String eliminarVueloSubmit(@RequestParam int idVuelo) {
        service.eliminar(idVuelo);
        return "redirect:/vuelos/lista";
    }
    
    @GetMapping("/vuelos/actualizar")
    public String actualizarPlazasForm() {
        return "actualizar";
    }

    @PostMapping("/vuelos/actualizar")
    public String actualizarPlazasSubmit(@RequestParam int idVuelo, @RequestParam int numPlazas) {
        service.actualizarVuelo(idVuelo, numPlazas);
        return "redirect:/vuelos/lista";
    }
    
    @GetMapping("/vuelos/disponibles")
    public String vuelosDisponiblesForm() {
        return "disponibles";
    }
    
    @PostMapping("/vuelos/disponibles")
    public String vuelosDisponiblesSubmit(@RequestParam int numPlazas, Model model) {
        model.addAttribute("vuelos", service.vuelosDisponibles(numPlazas));
        return "disponibles";
    }

}

