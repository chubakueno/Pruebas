package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoriaDao;
import dao.ICategoriaDao;
import dao.IProductoDao;
import dao.ProductoDao;

/**
 * Servlet implementation class CategoriaEliminar
 */
@WebServlet("/CategoriaEliminar")
public class CategoriaEliminar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoriaEliminar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ICategoriaDao categoriaDao = new CategoriaDao();
			boolean flag = categoriaDao.eliminar( Integer.parseInt(request.getParameter("categoria")) );
			
			if(flag){
				request.setAttribute("mensaje", "Categoria eliminada");
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
