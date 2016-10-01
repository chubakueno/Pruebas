package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Dao;
import model.User;


/**
 * Servlet implementation class ServletUsuario
 */
@WebServlet("/ServletUsuario")
public class ServletUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/admin/index.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String codigo = request.getParameter("campoCorreo");
		String contrase�a = request.getParameter("campoClave");
		
		Dao<User> dao = new Dao<>(User.class);
		System.out.println(codigo+"/"+contrase�a);
		User admin = dao.login(codigo, contrase�a);
		if(admin != null){
			HttpSession sesion = request.getSession();
			sesion.setAttribute("sesAdmin", admin);
			request.getRequestDispatcher("/Principal").forward(request, response);
		}else{
			
			request.getRequestDispatcher("/admin/index.jsp").forward(request, response);
		}
	}

}
