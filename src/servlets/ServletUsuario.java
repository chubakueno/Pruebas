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
		String contrasena = request.getParameter("campoClave");
		if(codigo==""&&contrasena==""){
			HttpSession sesion = request.getSession();
			sesion.invalidate();
		}
		Dao<User> dao = new Dao<>(User.class);
		User admin = dao.login(codigo, contrasena);
		if(admin != null){
			HttpSession sesion = request.getSession();
			sesion.setAttribute("sesAdmin", admin);
			request.getRequestDispatcher("/admin/principal.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("/admin/index.jsp").forward(request, response);
		}
	}

}
