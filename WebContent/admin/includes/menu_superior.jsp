
<%
	// @pageimport="beans.AdministradorBean"
%>
<%
	//AdministradorBean admin = (AdministradorBean)session.getAttribute("sesAdmin");
%>
<div class="container-fluid">
	<div class="navbar-header">
		<button type="button" class="navbar-toggle collapsed"
			data-toggle="collapse" data-target="#navbar" aria-expanded="false"
			aria-controls="navbar">
			<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
			<span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="#">DEISW.WEB</a>
	</div>
	<div id="navbar" class="navbar-collapse collapse">
		<ul class="nav navbar-nav navbar-right">
			<li><a
				href="<%=getServletContext().getContextPath()%>/admin/principal.jsp">Inicio</a></li>
			<li><a onclick="cerrarSesion()">Cerrar sesi�n</a></li>
		</ul>
	</div>
</div>