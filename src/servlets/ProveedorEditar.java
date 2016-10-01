package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProveedorDao;
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
			
			ProveedorDao proveedor = new ProveedorDao();
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
			
			ProveedorDao dao = new ProveedorDao();
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
