<%@page import="model.Provider"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%List<Provider> proveedores = (List<Provider>)request.getAttribute("proveedores"); %>
	<div class="container-fluid">
	
		<h3>Listado</h3>
		<table class="table">
			<thead>
			 <tr>
		          <th>ID</th>
		          <th>Nombre</th>
		          <th>Opciones</th>
		        </tr>
			</thead>
			<tbody>
		      	<% for(int i=0; i<proveedores.size();i++){ %>
		        <tr>
		          <th scope="row"><%=proveedores.get(i).getIdProvider()%></th>
		          <td><%=proveedores.get(i).getName()%></td>
		          <td>
		          	<a href="<%=getServletContext().getContextPath()%>/ProveedorEditar?proveedor=<%=proveedores.get(i).getIdProvider()%>">Editar</a>
		          	<a href="<%=getServletContext().getContextPath()%>/ProveedorEliminar?proveedor=<%=proveedores.get(i).getIdProvider()%>">Eliminar</a>
		          </td>

		        </tr>
		        <% } %>
		      </tbody>
			
		</table>
	</div>

</body>
</html>