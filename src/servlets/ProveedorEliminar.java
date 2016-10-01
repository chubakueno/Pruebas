package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.net.ssl.internal.ssl.Provider;

import dao.Dao;

/**
 * Servlet implementation class ProveedorEliminar
 */
@WebServlet("/ProveedorEliminar")
public class ProveedorEliminar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProveedorEliminar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Dao<Provider> proveedorDao = new Dao<>(Provider.class);
			boolean flag = proveedorDao.eliminar( Integer.parseInt(request.getParameter("proveedor")) );
			
			if(flag){
				request.setAttribute("mensaje", "Proveedor eliminado");
			}else{
				request.setAttribute("mensaje", "ocurrió un error");
			}
			request.getRequestDispatcher("/admin/resultado.jsp").forward(request, response);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
