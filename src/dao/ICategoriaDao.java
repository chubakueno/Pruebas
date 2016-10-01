package dao;

import java.util.List;

import model.*;

public interface ICategoriaDao {

	public List<Category> listar();
	public boolean agregar(Category categoria);
	public boolean eliminar(int id);
	public Category Buscar(int id);
}
