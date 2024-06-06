package com.curso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.curso.model.Vuelo;
import com.curso.service.VuelosService;

@Controller
public class VueloControllerView {

    @Autowired
    private VuelosService service;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/vuelos/lista")
    public String listaVuelos(Model model) {
        model.addAttribute("vuelos", service.vuelos());
        return "lista";
    }

    @GetMapping("/vuelos/nuevo")
    public String nuevoVuelo() {
        return "nuevo";
    }

    @PostMapping("/vuelos/alta")
    public String alta(Vuelo vuelo) {
        service.alta(vuelo);
        return "redirect:/vuelos/lista";
    }
}
