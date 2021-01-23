package servicio;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

import Modelo.Persona;
import dao.PersonaDao;

//@Service
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
	
	
	
	
	
	
	
	@Required
	@Qualifier("PersonaDaoImpl") //inyeccion manual
	//@Autowired(required=true) // con true, evitamos una excepción si no se puede inyectar el bean, required tiene la misma funcion que la anotación
	public void setPersonaDao(PersonaDao personaDao) {
		this.personaDao = personaDao;
	}


	
	// @Required: indica que una propiedad tiene que ser inyectada, no indica como hacerlo
	// @Autowired: indica que se inyectara automaticamente el bean, se puede poner en un setter, una propiedad o un constructor
	// @Nullable: poniendolo delante de un argumento de un constructor, evitamos una excepción si no sepuede inyectar el bean
	// @Qualifier: nos permite especificar que bean sera inyectado cuando tenemos varios bean del mismo tipo,
	//			   si lo ponemos delante de un argumento de un metodo le inyectara el bean con el valor
	//			   que coincida con qualifier-value del xml, sino se usara el id del bean (qualifier-value="personaDao")
	// @Service: estereotipo para las clases servicio, logica de negocio,...
	// @Repository: estereotipo para clases de acceso a datos(DAO)
	// @Controller: estereotipo para clases que sirven para gestionar las peticiones recibidas
	// @Component: estereotipo basico, los anteriores derivan de el
	
	

}
