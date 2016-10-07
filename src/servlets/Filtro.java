package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
	List<String> allowedPrefixes,allowedExacts;
	public void init(FilterConfig config) throws ServletException {
		allowedPrefixes=new ArrayList<>();
		allowedPrefixes.add("/css/");
		allowedPrefixes.add("/js/");
		allowedExacts=new ArrayList<>();
		allowedExacts.add("/admin/index.jsp");
		allowedExacts.add("/ServletUsuario");
	}
	public void destroy() {
	}

	public void doFilter(ServletRequest req, ServletResponse res,
		FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		String url = request.getServletPath();
		System.out.println("Filtro.java:: Url: "+url);
		boolean allowedRequest = false;
		for(String str: allowedPrefixes)
			if(url.startsWith(str)) allowedRequest=true;
		if(allowedExacts.contains(url)) allowedRequest=true;
		HttpSession ses=request.getSession(false);
		if(ses!=null){
			if(ses.getAttribute("sesAdmin")!=null)
				allowedRequest=true;
		}
		if (!allowedRequest) {
			response.sendRedirect("/Pruebas/admin/index.jsp");
		}else{
			chain.doFilter(req, res);
		}
	}
}
