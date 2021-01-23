package servicio;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import Modelo.Persona;
import dao.PersonaDao;

public class PersonaServicioImpl implements PersonaServicio{
	
	private PersonaDao personaDao;
	

	@Override
	public List<Persona> porNombreEmpiezaPor(String s) {
	return 	personaDao.buscarTodos()
					.stream()
					.filter(p -> p.getNombre().startsWith(s))
					.collect(Collectors.toList());
		
	}

	@Override
	public List<Persona> porAnyoNacimiento(int anyo) {
		return 	personaDao.buscarTodos()
				.stream()
				.filter(p -> p.getFechaNacimiento().getYear()==anyo)
				.collect(Collectors.toList());
	}

	@Override
	public List<Persona> porEntreAnyos(int desde, int hasta) {
		return 	personaDao.buscarTodos()
				.stream()
				.filter(p -> p.getFechaNacimiento().getYear()>=desde && p.getFechaNacimiento().getYear()<=hasta)
				.collect(Collectors.toList());
	}

	@Override
	public List<Persona> porNombreContiene(String s) {
		return 	personaDao.buscarTodos()
				.stream()
				.filter(p -> p.getNombre().contains(s))
				.collect(Collectors.toList());
	}
		
	@Override
	public List<Persona> ordenarPorNombreAscendente(List<Persona> personas) {
		Collections.sort(personas);	
		personas.sort((p1, p2) -> p1.getNombre().compareTo(p2.getNombre()));
		return personas;
	}

	@Override
	public List<Persona> ordenarPorFechaNacimientoAscendente(List<Persona> personas) {
		Collections.sort(personas);	
		return personas;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public void setPersonaDao(PersonaDao personaDao) {
		this.personaDao = personaDao;
	}


	
	
	
	
	
	
	

}
