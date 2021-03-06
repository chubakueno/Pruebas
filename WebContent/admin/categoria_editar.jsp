<%@page import="model.Category"%>
<%@ include file="includes/header.jsp"%>
<nav class="navbar navbar-inverse navbar-fixed-top">
	<%@ include file="includes/menu_superior.jsp"%>
</nav>
<div class="container-fluid">
	<div class="row">
		<div class="col-sm-3 col-md-2 sidebar">
			<%@ include file="includes/menu_lateral.jsp"%>
		</div>
		<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			<%
				Category categoria = (Category) request.getAttribute("categoria");
			%>
			<h2>Editando la Categoria</h2>
			<form method="post"
				action="<%=getServletContext().getContextPath()%>/CategoriaEditar">
				<div class="form-group">
					<label>Nombre:</label> <input type="text" name="campoNombre"
						oninvalid="this.setCustomValidity('Falta llenar el campo Descripcion');"
						oninput="setCustomValidity('')" required class="form-control"
						id="campoNombreID" placeholder="Ingresa la descripcion"
						value="<%=categoria.getName()%>">
				</div>
				<input type="hidden" name="campoID" class="form-control"
					id="campoID" value="<%=categoria.getIdCategory()%>">
				<button type="submit"
					onclick="return confirm('�Esta seguro de actualizar esta categoria?')"
					class="btn btn-default">Actualizar Categoria</button>
			</form>
		</div>
	</div>
</div>