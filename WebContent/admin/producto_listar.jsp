<%@page import="model.Product"%>
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
	<%List<Product> productos = (List<Product>)request.getAttribute("productos"); %>
	
	<div class="container-fluid">
	
		<h3>Listado</h3>
		<table class="table">
			<thead>
			 <tr>
		          <th>ID</th>
		          <th>Nombre</th>
				  <th>Monto</th>
				  <th>Categoria</th>
				  <th>Proveedor</th>
				  <th>Opciones</th>
		        </tr>
			</thead>
			<tbody>
		      	<% for(int i=0; i<productos.size();i++){ %>
		        <tr>
		          <th scope="row"><%=productos.get(i).getIdProduct()%></th>
		          <td><%=productos.get(i).getDescription()%></td>
		          <td><%=productos.get(i).getMount()%></td>
		          <td><%=productos.get(i).getCategory().getName()%></td>
		          <td><%=productos.get(i).getProvider().getName()%></td>
		          <td>
		          	<a href="<%=getServletContext().getContextPath()%>/ProductoEditar?producto=<%=productos.get(i).getIdProduct()%>">Editar</a>
		          	<a href="<%=getServletContext().getContextPath()%>/ProductoEliminar?producto=<%=productos.get(i).getIdProduct()%>">Eliminar</a>
		          </td>
		        </tr>
		        <% } %>
		      </tbody>
			
		</table>
	</div>
</body>
</html>