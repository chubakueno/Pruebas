<%@page import="model.Product"%>
<%@page import="java.util.List"%>

<%@ include file="includes/header.jsp" %>
<nav class="navbar navbar-inverse navbar-fixed-top">
	<%@ include file="includes/menu_superior.jsp" %>
</nav>
<div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
        	<%@ include file="includes/menu_lateral.jsp" %>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
        

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


      	</div>
	</div>
</div>