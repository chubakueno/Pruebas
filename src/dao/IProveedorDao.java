package dao;

import java.util.List;
import model.*;

public interface IProveedorDao {

	public List<Provider> listar();
	public boolean agregar(Provider provider);
	public boolean actualizar(Provider provider);
	public boolean eliminar(int id);
	public Provider Buscar(int id);
}
