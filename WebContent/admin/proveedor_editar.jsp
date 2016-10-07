<%@page import="model.Provider"%>
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
				Provider proveedor = (Provider) request.getAttribute("proveedor");
			%>
			<h2>Editando el Proveedor</h2>
			<form method="post"
				action="<%=getServletContext().getContextPath()%>/ProveedorEditar">
				<div class="form-group">
					<label>Nombre:</label> <input type="text" required
						oninvalid="this.setCustomValidity('Falta llenar el campo Descripcion');"
						oninput="setCustomValidity('')" name="campoNombre"
						class="form-control" id="campoNombreID"
						placeholder="Ingresa la Descripcion"
						value="<%=proveedor.getName()%>">
				</div>
				<input type="hidden" name="campoID" class="form-control"
					id="campoID" value="<%=proveedor.getIdProvider()%>">
				<button type="submit"
					onclick="return confirm('¿Esta seguro de actualizar este proveedor?')"
					class="btn btn-default">Actualizar Proveedor</button>
			</form>
		</div>
	</div>
</div>