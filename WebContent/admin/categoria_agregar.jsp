<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h2>Registro de Categorias</h2>
		<form  method="post"
				action="<%=getServletContext().getContextPath() %>/ServletCategoria">

			<div class="form-group">
				<label>Nombre:</label>
				<input type="text" name="campoNombre" class="form-control" id="campoNombreID" placeholder="Ingresa el nombre">
			</div>
			
			<button type="submit" class="btn btn-default">Registrar Categoria</button>
			
		</form>


</body>
</html>