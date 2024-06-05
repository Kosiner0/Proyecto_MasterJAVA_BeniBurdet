package com.curso.inicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@EnableJpaRepositories(basePackages="com.curso.dao")
@EntityScan(basePackages="com.curso.model")
@SpringBootApplication(scanBasePackages={"com.curso.service", "com.curso.controller"})
public class ProyectoServicioReservasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoServicioReservasApplication.class, args);
	}
	
	@Bean
	RestTemplate template() {
		return new RestTemplate();
	}

}
