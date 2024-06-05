package com.curso.controller;

import com.curso.model.Hotel;
import com.curso.service.HotelesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HotelControllerView {

    @Autowired
    private HotelesService service;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/hoteles/lista")
    public String listaHoteles(Model model) {
        model.addAttribute("hoteles", service.hoteles());
        return "lista";
    }

    @GetMapping("/hoteles/nuevo")
    public String nuevoHotel() {
        return "nuevo";
    }

    @PostMapping("/hoteles/alta")
    public String alta(Hotel hotel) {
        service.alta(hotel);
        return "redirect:/hoteles/lista";
    }
}
