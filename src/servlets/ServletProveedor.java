package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import model.Provider;

/**
 * Servlet implementation class ServletProveedor
 */
@WebServlet("/ServletProveedor")
public class ServletProveedor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletProveedor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try{
			
			request.getRequestDispatcher("/admin/proveedor_agregar.jsp").forward(request, response);
			
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
			
			Provider proveedor = new Provider();
			proveedor.setName(nombre);			
			

			Dao<Provider> proveedorDao = new Dao<>(Provider.class);
			boolean flag = proveedorDao.agregar(proveedor);
			
			if(flag){
				request.setAttribute("mensaje", "Proveedor guardado");
			}else{
				request.setAttribute("mensaje", "Ocurri� un error");
			}
			
			request.getRequestDispatcher("/admin/resultado.jsp").forward(request, response);
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		
	}

}
