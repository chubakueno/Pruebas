package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoriaDao;
import dao.ICategoriaDao;
import dao.IProductoDao;
import dao.IProveedorDao;
import dao.ProductoDao;
import dao.ProveedorDao;
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
			IProveedorDao proveedorDao = new ProveedorDao();
			List<model.Provider> proveedores = proveedorDao.listar();
			
			ICategoriaDao categoriaDao = new CategoriaDao();
			List<model.Category> categorias = categoriaDao.listar();
			
			request.setAttribute("categorias", categorias);			
			request.setAttribute("proveedores", proveedores);
			
			String productoID = request.getParameter("producto");
			
			IProductoDao producto = new ProductoDao();
			Product productoEntidad = producto.Buscar(Integer.parseInt(productoID));
			
			request.setAttribute("producto", productoEntidad);
			
			request.getRequestDispatcher("/admin/producto_editar.jsp").forward(request, response);
			
		} catch (Exception e) {
			// TODO: handle exception
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
			
			IProveedorDao providerDao = new ProveedorDao();
			Provider p = providerDao.Buscar(proveedorId);
			
			ICategoriaDao categoriaDao = new CategoriaDao();
			Category c = categoriaDao.Buscar(categoriaId);
			
			Product producto = new Product();
			producto.setDescription(nombre);
			producto.setMount(monto);
			producto.setCategory(c);
			producto.setProvider(p);
			
			IProductoDao dao = new ProductoDao();
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
