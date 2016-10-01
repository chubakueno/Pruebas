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
        
        

		<h2>Registro de Proveedores</h2>
		<form  method="post"
				action="<%=getServletContext().getContextPath() %>/ServletProveedor">

			<div class="form-group">
				<label>Nombre:</label>
				<input type="text"
				required="true";
				oninvalid="this.setCustomValidity('Falta llenar el campo Descripcion');" 
				oninput="setCustomValidity('')"
				name="campoNombre" class="form-control" id="campoNombreID" placeholder="Ingresar la Descripcion">
			</div>
			
			<button type="submit" onclick="return confirm('¿Esta seguro de registrar este proveedor?')" class="btn btn-default">Crear</button>
			
		</form>
	
      	</div>
	</div>
</div>