package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

import dao.PersonaDaoImpl;
import servicio.PersonaServicioImpl;

@Configuration
public class AppConfig {
	@Scope("singleton")
	@Bean()
	@Primary
	public PersonaDaoImpl personaDaoImpl() {
		return new PersonaDaoImpl();
	}
	
	@Scope("singleton")
	@Bean
	public PersonaServicioImpl personaServicioImpl() {
		return new PersonaServicioImpl();
	}
	
	
	
	
	
	
	
	
	
	// @Configuration: indica que una clase va a tener uno o mas @Bean
	// @Bean: equivale a <bean>
	// @Primary: ante varios beans de un tipo, es el primer candidato para ser inyectado
	// @Scope: por defecto es singleton(devuelve la misma instancia cada vez), tambien esta prototype (devuelve una instancia diferente cada vez)
}
