package com.curso.inicio;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.curso.model.Vuelo;
import com.curso.service.VuelosService;

@SpringBootTest
@AutoConfigureMockMvc
class VuelosControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private VuelosService service;
	
	
	@BeforeEach
	public void setup() {
		Vuelo vuelo = new Vuelo("Ryanair", "04/06/2024", 29.99, 130);
		List<Vuelo> list = new ArrayList<>();
		list.add(vuelo);
		when(service.vuelos()).thenReturn(list);
		
	}
	
	
	@Test
	public void createVueloTest() throws Exception {
		service.alta(any(Vuelo.class));
		
		mockMvc.perform(post("/vuelos/alta")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"compania\":\"Turquish\", \"fechaVuelo\":\"13-02-2020\", \"precio\":\"30.00\", \"plazasDisponibles\":\"50\" }"))
				.andExpect(status().isOk());
	}
	
	
	@Test
	public void updateVueloByIdTest() throws Exception {
		service.actualizarVuelo(2, 15);
		
		mockMvc.perform(put("/vuelos/actualizar/2/15"))
				.andExpect(status().isOk());
		
	}
	
	
	
	@Test
	public void getListTodosLosClientesTest() throws Exception {
		service.vuelos();
		
		mockMvc.perform(get("/vuelos"))
				.andExpect(status().isOk());
				
	}
	
	
	@Test
	public void deleteVueloByIdTest() throws Exception {
		service.eliminar(1);
		
		mockMvc.perform(delete("/vuelos/eliminar/1"))
				.andExpect(status().isOk());
		
	}
	

}
