package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoriaDao;
import dao.ProductoDao;
import dao.ProveedorDao;
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
			ProveedorDao proveedorDao = new ProveedorDao();
			List<model.Provider> proveedores = proveedorDao.listar();
			
			CategoriaDao categoriaDao = new CategoriaDao();
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
			
			ProveedorDao providerDao = new ProveedorDao();
			Provider p = providerDao.Buscar(proveedorId);
			
			CategoriaDao categoriaDao = new CategoriaDao();
			Category c = categoriaDao.Buscar(categoriaId);
			
			Product producto = new Product();
			producto.setDescription(nombre);
			producto.setMount(monto);
			producto.setCategory(c);
			producto.setProvider(p);
			
			ProductoDao dao = new ProductoDao();
			boolean flag = dao.agregar(producto);
			
			if(flag){
				request.setAttribute("mensaje", "Producto guardado");
			}else{
				request.setAttribute("mensaje", "Ocurrió un error");
			}
			
			request.getRequestDispatcher("/admin/resultado.jsp").forward(request, response);
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}

}
