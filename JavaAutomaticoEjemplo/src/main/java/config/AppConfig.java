package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import dao.PersonaDaoImpl;
import servicio.PersonaServicioImpl;

@Configuration
@ComponentScan(basePackages="dao, servicio")
public class AppConfig {
	
	
	
	
	
	
	
	
	
	
	
	// @Configuration: indica que una clase va a tener uno o mas @Bean
	// @Bean: equivale a <bean>
	// @ComponentScan: buscara en los paquetes especificados, las clases anotadas con @Component, @Service, @Repository, etc
	// @Scope: por defecto es singleton(devuelve la misma instancia cada vez), tambien esta prototype (devuelve una instancia diferente cada vez)
}
