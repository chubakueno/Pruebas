package dao;

import java.util.List;
import model.Product;

public interface IProductoDao {

	public List<Product> listar();
	public boolean agregar(Product producto);
	public boolean actualizar(Product producto);
	public boolean eliminar(int id);
	public Product Buscar(int id);
	
}
