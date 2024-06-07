package com.curso.inicio;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.curso.model.Hotel;
import com.curso.service.HotelesService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class HotelControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HotelesService service;

    @Test
    void testGetHoteles() throws Exception {
        Hotel hotel1 = new Hotel(1, "Hotel1", "Category1", 100.0, true);
        Hotel hotel2 = new Hotel(2, "Hotel2", "Category2", 200.0, false);
        when(service.hoteles()).thenReturn(Arrays.asList(hotel1, hotel2));

        mockMvc.perform(get("/hoteles")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"idHotel\":1,\"nombre\":\"Hotel1\",\"categoria\":\"Category1\",\"precio\":100.0,\"disponible\":true},{\"idHotel\":2,\"nombre\":\"Hotel2\",\"categoria\":\"Category2\",\"precio\":200.0,\"disponible\":false}]"));
    }

    @Test
    void testAltaHotel() throws Exception {
        Hotel hotel = new Hotel(1, "Hotel1", "Category1", 100.0, true);
        when(service.alta(hotel)).thenReturn(Arrays.asList(hotel));

        mockMvc.perform(post("/hoteles/alta")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(hotel)))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"idHotel\":1,\"nombre\":\"Hotel1\",\"categoria\":\"Category1\",\"precio\":100.0,\"disponible\":true}]"));
    }

    @Test
    void testEliminarHotel() throws Exception {
        Hotel hotel = new Hotel(1, "Hotel1", "Category1", 100.0, true);
        when(service.eliminar(1)).thenReturn(Arrays.asList(hotel));

        mockMvc.perform(delete("/hoteles/eliminar/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"idHotel\":1,\"nombre\":\"Hotel1\",\"categoria\":\"Category1\",\"precio\":100.0,\"disponible\":true}]"));
    }

    @Test
    void testActualizarCategoria() throws Exception {
        mockMvc.perform(put("/hoteles/actualizar/1/CategoryUpdated")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void testHotelesDisponibles() throws Exception {
        Hotel hotel = new Hotel(1, "Hotel1", "Category1", 100.0, true);
        when(service.hotelesDisponibles()).thenReturn(Arrays.asList(hotel));

        mockMvc.perform(get("/hoteles/disponibles")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"idHotel\":1,\"nombre\":\"Hotel1\",\"categoria\":\"Category1\",\"precio\":100.0,\"disponible\":true}]"));
    }

    @Test
    void testDatosHotel() throws Exception {
        Hotel hotel = new Hotel(1, "Hotel1", "Category1", 100.0, true);
        when(service.datosHotel("Hotel1")).thenReturn(hotel);

        mockMvc.perform(get("/hoteles/datos/Hotel1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"idHotel\":1,\"nombre\":\"Hotel1\",\"categoria\":\"Category1\",\"precio\":100.0,\"disponible\":true}"));
    }
}
