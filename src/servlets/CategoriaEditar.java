package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import model.Category;

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
			
			Dao<Category> categoria = new Dao<Category>(Category.class);
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
		
		try{
			String nombre = request.getParameter("campoNombre");
			int id = Integer.parseInt(request.getParameter("campoID"));
			
			Category categoria = new Category();
			categoria.setName(nombre);
			categoria.setIdCategory(id);
			
			Dao<Category> dao = new Dao<Category>(Category.class);
			boolean flag = dao.actualizar(categoria);

			if(flag){
				request.setAttribute("mensaje", "Categoria actualizada");
			}else{
				request.setAttribute("mensaje", "Ocurrió un error");
			}
			
			request.getRequestDispatcher("/admin/resultado.jsp").forward(request, response);
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

}
