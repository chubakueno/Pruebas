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
        
        
		<h2>Registro de Productos</h2>
		<form  method="post"
				name="formulario"
				action="<%=getServletContext().getContextPath() %>/ServletProducto">

			<div class="form-group">
				<label>Nombre:</label>
				<input type="text"
				required="true";
				oninvalid="this.setCustomValidity('Falta campo Descripcion');" 
				oninput="setCustomValidity('')"
				name="campoNombre" class="form-control" id="campoNombreID" placeholder="Ingresar la Descripcion">
			</div>
			
			<div class="form-group">
				<label>Monto:</label>
				<input type="text"
				required="true"
				oninvalid="this.setCustomValidity('Falta llenar el campo Monto');" 
				oninput="setCustomValidity('')"
				name="campoMonto" class="form-control" id="campoMontoID" placeholder="Ingresa el monto">
			</div>
			
		
			<div class="form-group">
				<% List<Provider> providers = (List<Provider>)request.getAttribute("proveedores");%>
				<label>Proveedor:</label>
				<select
				required="true"
				oninvalid="this.setCustomValidity('Falta llenar el campo Proveedor');" 
				oninput="setCustomValidity('')"
				name="listaProveedores" id="listaProveedores">
					<option disabled selected hidden>Seleccionar</option>
					<%for(int i=0; i<providers.size(); i++){ %>
						<option value="<%=providers.get(i).getIdProvider()%>"><%=providers.get(i).getName()%></option>
					<%} %>
				</select>	
			</div>
		
			<div class="form-group">
				<% List<Category> categorias = (List<Category>)request.getAttribute("categorias");%>
				<label>Categoria:</label>
				<select
				required="true"
				oninvalid="this.setCustomValidity('Falta llenar el campo Categoria');" 
				oninput="setCustomValidity('')"
				name="listaCategorias" id="listaCategorias">
					<option disabled selected hidden>Seleccionar</option>
					<%for(int i=0; i<categorias.size();i++){ %>
						<option value="<%=categorias.get(i).getIdCategory()%>"><%=categorias.get(i).getName() %></option>
					<%} %>
				</select>	
			</div>
			
			<button type="submit" onclick="return confirm('¿Esta seguro de registrar este producto?')" class="btn btn-default">Crear</button>
			
		</form>
		
      	</div>
	</div>
</div>