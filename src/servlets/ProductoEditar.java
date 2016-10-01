package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import model.Category;
import model.Product;
import model.Provider;

/**
 * Servlet implementation class ProductoEditar
 */
@WebServlet("/ProductoEditar")
public class ProductoEditar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductoEditar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			Dao<Provider> provider = new Dao<>(Provider.class);
			List<model.Provider> proveedores = provider.listar();
			
			Dao<Category> categoriaDao = new Dao<>(Category.class);
			List<model.Category> categorias = categoriaDao.listar();
			
			request.setAttribute("categorias", categorias);			
			request.setAttribute("proveedores", proveedores);
			
			String productoID = request.getParameter("producto");
			
			Dao<Product> producto = new Dao<>(Product.class);
			Product productoEntidad = producto.Buscar(Integer.parseInt(productoID));
			
			request.setAttribute("producto", productoEntidad);
			
			request.getRequestDispatcher("/admin/producto_editar.jsp").forward(request, response);
		} catch (Exception e) {
			request.getRequestDispatcher("/admin/producto_agregar.jsp").forward(request, response);
			System.out.println(e.getMessage());
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			String nombre = request.getParameter("campoNombre");
			String id = request.getParameter("id");
			float monto = Float.parseFloat(request.getParameter("campoMonto"));
			int proveedorId = Integer.parseInt(request.getParameter("listaProveedores"));
			int categoriaId = Integer.parseInt(request.getParameter("listaCategorias"));
			
			Dao<Provider> providerDao = new Dao<>(Provider.class);
			Provider p = providerDao.Buscar(proveedorId);
			
			Dao<Category> categoriaDao = new Dao<Category>(Category.class);
			Category c = categoriaDao.Buscar(categoriaId);
			
			Product producto = new Product();
			producto.setDescription(nombre);
			producto.setMount(monto);
			producto.setCategory(c);
			producto.setProvider(p);
			producto.setIdProduct(Integer.parseInt(id));
			Dao<Product> dao = new Dao<Product>(Product.class);
			boolean flag = dao.actualizar(producto);
			
			if(flag){
				request.setAttribute("mensaje", "Producto actualizado");
			}else{
				request.setAttribute("mensaje", "Ocurrió un error");
			}
			
			request.getRequestDispatcher("/admin/resultado.jsp").forward(request, response);
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

}
