package com.curso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.curso.model.Reserva;
import com.curso.service.ReservasService;

@Controller
public class ReservaControllerView {

    @Autowired
    ReservasService service;

    @GetMapping("/")
    public String inicio() {
        return "index";
    }

    @GetMapping("/reservas/lista")
    public String listaReservas(Model model) {
        model.addAttribute("reservas", service.reservas());
        return "lista";
    }

    @GetMapping("/reservas/listaHotel")
    public String reservasHotelForm() {
        return "listaHotel";
    }

    @PostMapping("/reservas/listaHotel")
    public String reservasHotelSubmit(@RequestParam String nombreHotel, Model model) {
        model.addAttribute("reservas", service.reservasHotel(nombreHotel));
        return "listaHotel";
    }
    
    @GetMapping("/reservas/nuevo")
    public String nuevoReservaForm(Model model) {
        model.addAttribute("reservas", new Reserva());
        return "nuevo";
    }

    @PostMapping("/reservas/nuevo")
    public String nuevoReservaSubmit(@ModelAttribute Reserva reserva, @RequestParam int numPersonas, Model model) {
        service.altaVuelo(reserva, numPersonas);
        return "redirect:/reservas/lista";
    }

    @GetMapping("/reservas/eliminar")
    public String eliminarReservaForm() {
        return "eliminar";
    }

    @PostMapping("/reservas/eliminar")
    public String eliminarReservaSubmit(@RequestParam int idReserva) {
        service.eliminar(idReserva);
        return "redirect:/reservas/lista";
    }

    @GetMapping("/reservas/actualizar")
    public String actualizarReservaForm() {
        return "actualizar";
    }

    @PostMapping("/reservas/actualizar")
    public String actualizarReservaSubmit(@RequestParam int idReserva, @RequestParam String nuevoNombre) {
        service.actualizarNombre(idReserva, nuevoNombre);
        return "redirect:/reservas/lista";
    }

}
