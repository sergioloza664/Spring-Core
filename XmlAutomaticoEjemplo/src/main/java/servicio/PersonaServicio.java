package servicio;

import java.time.LocalDate;
import java.util.List;

import Modelo.Persona;

public interface PersonaServicio {
	
	public List<Persona> porNombreEmpiezaPor(String s);
	
	public List<Persona> porAnyoNacimiento(int anyo);
	
	public List<Persona> porEntreAnyos(int desde, int hasta);
	
	public List<Persona> porNombreContiene(String s);
	
	public List<Persona> ordenarPorNombreAscendente(List<Persona> personas);
	
	public List<Persona> ordenarPorFechaNacimientoAscendente(List<Persona> personas);

}
