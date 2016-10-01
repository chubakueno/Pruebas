<%@page import="model.Provider"%>
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
	
      	</div>
	</div>
</div>