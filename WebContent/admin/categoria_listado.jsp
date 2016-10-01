<%@page import="model.Category"%>
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
        
        
	<%List<Category> categorias = (List<Category>)request.getAttribute("categorias"); %>
	
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
		      	<% for(int i=0; i<categorias.size();i++){ %>
		        <tr>
		          <th scope="row"><%=categorias.get(i).getIdCategory()%></th>
		          <td><%=categorias.get(i).getName()%></td>
		          <td>
		          	<a href="<%=getServletContext().getContextPath()%>/CategoriaEditar?categoria=<%=categorias.get(i).getIdCategory()%>">Editar</a>
		          	<a href="<%=getServletContext().getContextPath()%>/CategoriaEliminar?categoria=<%=categorias.get(i).getIdCategory()%>">Eliminar</a>
		          </td>
		        </tr>
		        <% } %>
		      </tbody>
			
		</table>
	</div>

		</form>
		
      	</div>
	</div>
</div>