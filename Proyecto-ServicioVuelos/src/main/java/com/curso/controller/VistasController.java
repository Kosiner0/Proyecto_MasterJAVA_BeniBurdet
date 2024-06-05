package com.curso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.curso.model.VueloDTO;

@Controller
public class VistasController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/altaVuelo")
    public String altaVuelo(Model model) {
        model.addAttribute("vueloDTO", new VueloDTO());
        return "altaVuelo";
    }

    @GetMapping("/eliminarVuelo")
    public String eliminarVuelo() {
        return "eliminarVuelo";
    }

    @GetMapping("/actualizarVuelo")
    public String actualizarVuelo() {
        return "actualizarVuelo";
    }

    @GetMapping("/listarVuelosDisponibles")
    public String listarVuelosDisponibles() {
        return "listarVuelosDisponibles";
    }
}
