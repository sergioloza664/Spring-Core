package dao;

import java.util.List;

import Modelo.Persona;

public interface PersonaDao {

	public Persona buscarPorId(int id);
	public List<Persona> buscarTodos();
	public void insertar(Persona p);
	public void editar(Persona p);
	public void borrar(int id);
}
