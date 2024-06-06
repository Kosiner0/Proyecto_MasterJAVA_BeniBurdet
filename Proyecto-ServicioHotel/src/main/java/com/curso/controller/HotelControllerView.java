package com.curso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.curso.model.Hotel;
import com.curso.service.HotelesService;

@Controller
public class HotelControllerView {

    @Autowired
    HotelesService service;

    @GetMapping("/")
    public String inicio() {
        return "index";
    }

    @GetMapping("/hoteles/lista")
    public String listaHoteles(Model model) {
        model.addAttribute("hoteles", service.hoteles());
        return "lista";
    }

    @GetMapping("/hoteles/nuevo")
    public String nuevoHotelForm(Model model) {
        model.addAttribute("hotel", new Hotel());
        return "nuevo";
    }

    @PostMapping("/hoteles/nuevo")
    public String nuevoHotelSubmit(@ModelAttribute Hotel hotel, Model model) {
        service.alta(hotel);
        return "redirect:/hoteles/lista";
    }

    @GetMapping("/hoteles/eliminar")
    public String eliminarHotelForm() {
        return "eliminar";
    }

    @PostMapping("/hoteles/eliminar")
    public String eliminarHotelSubmit(@RequestParam int idHotel) {
        service.eliminar(idHotel);
        return "redirect:/hoteles/lista";
    }

    @GetMapping("/hoteles/actualizar")
    public String actualizarCategoriaForm() {
        return "actualizar";
    }

    @PostMapping("/hoteles/actualizar")
    public String actualizarCategoriaSubmit(@RequestParam int idHotel, @RequestParam String nuevaCategoria) {
        service.actualizarCategoria(idHotel, nuevaCategoria);
        return "redirect:/hoteles/lista";
    }
    
    @GetMapping("/hoteles/disponibles")
    public String hotelesDisponibles(Model model) {
        model.addAttribute("hoteles", service.hotelesDisponibles());
        return "disponibles";
    }

    @GetMapping("/hoteles/datos")
    public String datosHotelForm() {
        return "datos";
    }

    @PostMapping("/hoteles/datos")
    public String datosHotelSubmit(@RequestParam String nombre, Model model) {
        Hotel hotel = service.datosHotel(nombre);
        model.addAttribute("hotel", hotel);
        return "datos";
    }
}
