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
 * Servlet implementation class ServletProducto
 */
@WebServlet("/ServletProducto")
public class ServletProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletProducto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
			Dao<Provider> proveedorDao = new Dao<>(Provider.class);
			List<model.Provider> proveedores = proveedorDao.listar();
			
			Dao<Category> categoriaDao = new Dao<>(Category.class);
			List<model.Category> categorias = categoriaDao.listar();
			
			request.setAttribute("categorias", categorias);			
			request.setAttribute("proveedores", proveedores);
			
			request.getRequestDispatcher("/admin/producto_agregar.jsp").forward(request, response);
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try{
			String nombre = request.getParameter("campoNombre");
			float monto = Float.parseFloat(request.getParameter("campoMonto"));
			int proveedorId = Integer.parseInt(request.getParameter("listaProveedores"));
			int categoriaId = Integer.parseInt(request.getParameter("listaCategorias"));
			
			Dao<Provider> providerDao = new Dao<>(Provider.class);
			Provider p = providerDao.Buscar(proveedorId);
			
			Dao<Category> categoriaDao = new Dao<>(Category.class);
			Category c = categoriaDao.Buscar(categoriaId);
			
			Product producto = new Product();
			producto.setDescription(nombre);
			producto.setMount(monto);
			producto.setCategory(c);
			producto.setProvider(p);
			
			Dao<Product> dao = new Dao<>(Product.class);
			boolean flag = dao.agregar(producto);
			
			if(flag){
				request.setAttribute("mensaje", "El producto se guardo satisfactoriamente");
			}else{
				request.setAttribute("mensaje", "Ocurrió un error");
			}
			
			request.getRequestDispatcher("/admin/resultado.jsp").forward(request, response);
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}

}
