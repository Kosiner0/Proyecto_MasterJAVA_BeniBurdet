package com.curso.inicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages="com.curso.dao")
@EntityScan(basePackages="com.curso.model")
@SpringBootApplication(scanBasePackages={"com.curso.service", "com.curso.controller"})
public class ProyectoServicioVuelosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoServicioVuelosApplication.class, args);
	}

}
