package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class Filtro
 */
@WebFilter("/*")
public class Filtro implements Filter {
	public void destroy() {
	}

	public void doFilter(ServletRequest req, ServletResponse res,
		FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		String url = request.getServletPath();
		System.out.println(url);
		HttpSession ses=request.getSession(false);
		if(ses!=null){
			System.out.println(ses.getAttribute("sesAdmin"));
		}else{
			System.out.println("/null");
		}
		boolean allowedRequest = true;
		if (!allowedRequest) {
			HttpSession session = request.getSession(false);
			if (null == session) {
				response.sendRedirect("index.jsp");
			}
		}
		
		chain.doFilter(req, res);
	}

	public void init(FilterConfig config) throws ServletException {
	}
}
