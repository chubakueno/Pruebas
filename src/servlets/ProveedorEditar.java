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
 * Servlet implementation class ProveedorEditar
 */
@WebServlet("/ProveedorEditar")
public class ProveedorEditar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProveedorEditar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			
			String proveedorID = request.getParameter("proveedor");
			
			IProveedorDao proveedor = new ProveedorDao();
			Provider proveedorEntidad = proveedor.Buscar(Integer.parseInt(proveedorID));
			
			request.setAttribute("proveedor", proveedorEntidad);

			request.getRequestDispatcher("/admin/proveedor_editar.jsp").forward(request, response);
			
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

			Provider proveedor  = new Provider();
			proveedor.setName(nombre);
			
			IProveedorDao dao = new ProveedorDao();
			boolean flag = dao.actualizar(proveedor);
			
			if(flag){
				request.setAttribute("mensaje", "Proveedor actualizado");
			}else{
				request.setAttribute("mensaje", "Ocurrió un error");
			}
			
			request.getRequestDispatcher("/admin/resultado.jsp").forward(request, response);
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		
	}

}
