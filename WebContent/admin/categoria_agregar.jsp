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
				action="<%=getServletContext().getContextPath() %>/ServletCategoria">

			<div class="form-group">
				<label>Nombre:</label>
				<input type="text" name="campoNombre" class="form-control" id="campoNombreID" placeholder="Ingresa el nombre">
			</div>
			
			<button type="submit" class="btn btn-default">Registrar Categoria</button>
			
		</form>

      	</div>
	</div>
</div>