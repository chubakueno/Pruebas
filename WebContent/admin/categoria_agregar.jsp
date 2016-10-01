<%@page import="model.Category"%>
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
        

	<h2>Registro de Categorias</h2>
		<form  method="post"
				name="formulario"
				action="<%=getServletContext().getContextPath() %>/ServletCategoria">

			<div class="form-group">
				<label>Nombre:</label>
				<input type="text"
				required="true";
				oninvalid="this.setCustomValidity('Falta llenar el campo Descripcion');" 
				oninput="setCustomValidity('')"
				name="campoNombre" class="form-control" id="campoNombreID" placeholder="Ingresa la descripcion">
			</div>
			
			<button type="submit"
			onclick="return confirm('¿Esta seguro de registrar esta categoria?')"
			class="btn btn-default">Agregar</button>
			
		</form>

      	</div>
	</div>
</div>