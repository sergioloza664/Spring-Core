package dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.*;

import org.springframework.stereotype.Repository;

import Modelo.Persona;
@Repository
public class PersonaDaoImpl implements PersonaDao{
	
	private List<Persona> personas = new ArrayList<>();

	public Persona buscarPorId(int id) {		
		return personas.get(id);
	}

	public List<Persona> buscarTodos() {		
		return personas;
	}

	public void insertar(Persona p) {
		personas.add(p);
		
	}

	public void editar(Persona p) {
		for (int i = 0; i < personas.size(); i++) 
			if(personas.get(i).getId()==p.getId()) personas.set(i, p);
		
		
							
		
	}

	public void borrar(int id) {
		for (int i = 0; i < personas.size(); i++) 
			if(personas.get(i).getId()==id) personas.remove(i);
							
		
	}
	
	
	
	
	
	@PostConstruct
	public void init() {
		personas.add(new Persona(1, "Sergio", "Lozano", "Pérez", LocalDate.of(1992, 3, 24), "Hombre"));
		personas.add(new Persona(2, "Silvia", "Gonzalez", "Cervantes", LocalDate.of(1989, 5, 24), "Mujer"));
		personas.add(new Persona(3, "Laura", "Martinez", "Blanco", LocalDate.of(1990, 3, 4), "Mujer"));
		personas.add(new Persona(4, "Manolo", "Moreno", "Marco", LocalDate.of(1991, 11, 12), "Hombre"));
		personas.add(new Persona(5, "Maria", "Carrillo", "Galvez", LocalDate.of(1993, 6, 21), "Mujer"));
		personas.add(new Persona(6, "Pedro", "Sanchez", "Belmonte", LocalDate.of(1988, 1, 15), "Hombre"));
		personas.add(new Persona(7, "Elena", "Garcia", "López", LocalDate.of(1987, 7, 29), "Mujer"));
		personas.add(new Persona(8, "Marta", "Galvez", "Abellan", LocalDate.of(1987, 2, 14), "Mujer"));
		personas.add(new Persona(9, "Mario", "Alcolea", "Galera", LocalDate.of(1986, 8, 11), "Hombre"));
		
	}
	
	
	@PreDestroy
	public void destroy() {
		personas.clear();
	}
	
	
	// @PostConstruct: ejecuta el codigo del metodo anotado con esta anotacion despues de crear el bean 
	// @PreDestroy: ejecuta el codigo del metodo anotado con esta anotacion antes de destruir el bean
	// @Repository: estereotipo para clases de acceso a datos(DAO)

	//si en los estereotipos le damos nombre(@Repository("personaDao") con la anotacion @qualifield podremos inyectarla manualmente)
}
