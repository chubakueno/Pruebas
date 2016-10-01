package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductoDao;

/**
 * Servlet implementation class ProductoEliminar
 */
@WebServlet("/ProductoEliminar")
public class ProductoEliminar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductoEliminar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ProductoDao productoDao = new ProductoDao();
			boolean flag = productoDao.eliminar( Integer.parseInt(request.getParameter("producto")) );
			
			if(flag){
				request.setAttribute("mensaje", "Producto eliminado");
			}else{
				request.setAttribute("mensaje", "ocurri� un error");
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
