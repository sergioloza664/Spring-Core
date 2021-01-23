package principal;
import java.time.LocalDate;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Modelo.Persona;
import dao.PersonaDao;
import servicio.PersonaServicio;

public class Principal {
	
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		// Iniciamos el contexto, para utilizar los beans(objetos)
		ApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml");

		PersonaDao personaDao = appContext.getBean(PersonaDao.class);
		PersonaServicio personaServicio = appContext.getBean(PersonaServicio.class);
		
		opcion(personaDao, personaServicio);
	
	// Cerramos el contexto
	((ClassPathXmlApplicationContext) appContext).close();
	}
	
	
	
	
	public static void opcion(PersonaDao personaDao, PersonaServicio personaServicio) {
		int opcion = 0;
		
		do {
			menu();
			opcion=sc.nextInt();
			switch (opcion) {
			case 1:
				System.out.println("Buscar una personapor id");
				System.out.println("--------------------------------------------------");
				System.out.print("Introduce el id:");
				System.out.println(personaDao.buscarPorId(sc.nextInt()));
				break;
			case 2:
				System.out.println("Busca todas las personas");
				System.out.println("--------------------------------------------------");
				personaDao.buscarTodos()
									.stream()
									.forEach(System.out::println);
				break;
			case 3:
				System.out.println("Insertar una persona");
				System.out.println("-----------------------------------------------------------");				
				personaDao.insertar(insertarEditarPersona());
				break;
			case 4:
				System.out.println("Editar una persona");
				System.out.println("-----------------------------------------------------------");
				personaDao.editar(insertarEditarPersona());
				break;
			case 5:
				System.out.println("Elige el id de la persona a borrar"); 
				System.out.println("-----------------------------------------------------------");
				System.out.print("Introduce el id:");
				personaDao.borrar(sc.nextInt());
				break;
			case 6:
				System.out.println("Personas cuyo nombre empiece por");
				System.out.println("-----------------------------------------------------------");
				System.out.print("Introduce el comienzo del nombre:");
				String empiezaPor=sc.next();
				personaServicio.porNombreEmpiezaPor(empiezaPor)
															.stream()
															.forEach(System.out::println);
				break;
			case 7:
				System.out.println("Personas que han nacido en el año especificado");
				System.out.println("-----------------------------------------------------------");
				System.out.print("Introduce el año:");
				int anyoNacimiento=sc.nextInt();
				personaServicio.porAnyoNacimiento(anyoNacimiento)
													.stream()
													.forEach(System.out::println);
				break;
			case 8:
				System.out.println("Personas que han nacido entre 2 años especificados:");
				System.out.println("-----------------------------------------------------------");
				System.out.print("Introduce el primer año:");
				int anyoDesde=sc.nextInt();
				System.out.println("");
				System.out.print("Introduce el segundo año:");
				int anyoHasta=sc.nextInt();
				personaServicio.porEntreAnyos(anyoDesde, anyoHasta)
														.stream()
														.forEach(System.out::println);
				break;
			case 9:
				System.out.println("Personas cuyo nombre contiene los caracteres especificados");
				System.out.println("-----------------------------------------------------------");
				System.out.print("Introduce los caracteres:");
				String contiene=sc.next();
				personaServicio.porNombreContiene(contiene)
												.stream()
												.forEach(System.out::println);
				break;
			case 10:
				System.out.println("Personas ordenadas ascendentemente por nombre:");
				System.out.println("-----------------------------------------------------------");
				personaServicio.ordenarPorNombreAscendente(personaDao.buscarTodos())
																.stream()
																.forEach(System.out::println);
				break;
			case 11:
				System.out.println("Personas ordenadas ascendentemente por fecha de nacimiento:");
				System.out.println("-----------------------------------------------------------");
				personaServicio.ordenarPorFechaNacimientoAscendente(personaDao.buscarTodos())
																	.stream()
																	.forEach(System.out::println);
				break;

			default:
				break;
			}
			
			System.out.println("");
		} while (opcion !=0);
		
	}
	
	
	
	private static void menu() {
		System.out.println(" 1-Buscar una personapor id");
		System.out.println(" 2-Busca todas las personas");
		System.out.println(" 3-Insertar una persona");
		System.out.println(" 4-Editar una persona");
		System.out.println(" 5-Elige el id de la persona a borrar"); 
		System.out.println(" 6-Personas cuyo nombre empiece por");
		System.out.println(" 7-Personas que han nacido en el año especificado");
		System.out.println(" 8-Personas que han nacido entre 2 años especificados:");
		System.out.println(" 9-Personas cuyo nombre contiene los caracteres especificados");
		System.out.println("10-Personas ordenadas ascendentemente por nombre:");
		System.out.println("11-Personas ordenadas ascendentemente por fecha de nacimiento:");
		System.out.println(" 0-Salir");
		
	}
	
	
	private static Persona insertarEditarPersona() {
		System.out.println("Elige el id: ");	int id=+sc.nextInt();
		
		System.out.println("Elige el nombre: ");	String nombre=sc.next();
		
		System.out.println("Elige el apellido 1: ");	String apellido1=sc.next();
		
		System.out.println("Elige el apellido 2: ");	String apellido2=sc.next();
		
		System.out.println("Elige el fecha de nacimiento: ");
		System.out.println("      año: "); 	int anyo= sc.nextInt();
		System.out.println("      mes: "); 	int mes= sc.nextInt();
		System.out.println("      dia: "); 	int dia= sc.nextInt();
		LocalDate fechaNacimiento = LocalDate.of(anyo, mes, dia);
		
		System.out.println("Elige el sexo: ");	String sexo=sc.next();
		return new Persona(id, nombre, apellido1, apellido2, fechaNacimiento, sexo);
	}
	
	
	
	

}
