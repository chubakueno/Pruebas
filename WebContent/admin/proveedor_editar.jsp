<%@page import="model.Provider"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<%Provider proveedor = (Provider)request.getAttribute("proveedor"); %>
		<h2>Registro de Proveedores</h2>
		<form  method="post"
				action="<%=getServletContext().getContextPath() %>/ServletProveedor">

			<div class="form-group">
				<label>Nombre:</label>
				<input type="text" name="campoNombre" class="form-control" id="campoNombreID" placeholder="Ingresa el nombre" value="<%= proveedor.getName()%>">
			</div>
			
			<button type="submit" class="btn btn-default">Registrar Proveedor</button>
			
		</form>

</body>
</html>