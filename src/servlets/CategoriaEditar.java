package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoriaDao;
import dao.ICategoriaDao;
import dao.IProveedorDao;
import dao.ProveedorDao;
import model.Category;
import model.Provider;

/**
 * Servlet implementation class CategoriaEditar
 */
@WebServlet("/CategoriaEditar")
public class CategoriaEditar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoriaEditar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			String categoriaID = request.getParameter("categoria");
			
			ICategoriaDao categoria = new CategoriaDao();
			Category categoriaEntidad = categoria.Buscar(Integer.parseInt(categoriaID));
			
			request.setAttribute("categoria", categoriaEntidad);

			request.getRequestDispatcher("/admin/categoria_editar.jsp").forward(request, response);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
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
