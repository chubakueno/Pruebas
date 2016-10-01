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
 * Servlet implementation class ServletCategoria
 */
@WebServlet("/ServletCategoria")
public class ServletCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCategoria() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try{
			request.getRequestDispatcher("/admin/categoria_agregar.jsp").forward(request, response);
			
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
			
			Category categoria = new Category();
			categoria.setName(nombre);			
			

			ICategoriaDao categoriaDao = new CategoriaDao();
			boolean flag = categoriaDao.agregar(categoria);
			
			if(flag){
				request.setAttribute("mensaje", "Categoria guardada");
			}else{
				request.setAttribute("mensaje", "Ocurrió un error");
			}
			
			request.getRequestDispatcher("/admin/resultado.jsp").forward(request, response);
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}

}
