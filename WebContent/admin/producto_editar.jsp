<%@page import="model.Category"%>
<%@page import="model.Provider"%>
<%@page import="java.util.List"%>
<%@page import="model.Product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<% Product producto = (Product)request.getAttribute("producto"); %>
	<h2>Registro de Productos</h2>
		<form  method="post"
				action="<%=getServletContext().getContextPath() %>/ProductoEditar">

			<div class="form-group">
				<label>Nombre:</label>
				<input type="text" name="campoNombre" class="form-control" id="campoNombreID" placeholder="Ingresa el nombre" value="<%=producto.getDescription()%>">
				<input type="hidden" name="id" id="id" value="<%= producto.getIdProduct()%>">
			</div>
			
			<div class="form-group">
				<label>Monto:</label>
				<input type="text" name="campoMonto" class="form-control" id="campoMontoID" placeholder="Ingresa el monto" value="<%=producto.getMount()%>">
			</div>
			
		
			<div class="form-group">
				<% List<Provider> providers = (List<Provider>)request.getAttribute("proveedores");%>
				<label>Proveedor:</label>
				<select name="listaProveedores" id="listaProveedores">
					<option value="<%=producto.getProvider().getIdProvider()%>"><%=producto.getProvider().getName() %></option>
					<%for(int i=0; i<providers.size(); i++){ %>
						<option value="<%=providers.get(i).getIdProvider()%>"><%=providers.get(i).getName()%></option>
					<%} %>
				</select>	
			</div>
		
			<div class="form-group">
				<% List<Category> categorias = (List<Category>)request.getAttribute("categorias");%>
				<label>Categoria:</label>
				<select name="listaCategorias" id="listaCategorias">
					<option value="<%=producto.getCategory().getIdCategory()%>"><%=producto.getCategory().getName() %></option>
					<%for(int i=0; i<categorias.size();i++){ %>
						<option value="<%=categorias.get(i).getIdCategory()%>"><%=categorias.get(i).getName() %></option>
					<%} %>
				</select>	
			</div>
			
			<button type="submit" class="btn btn-default">Actualizar Producto</button>
			
		</form>

</body>
</html>