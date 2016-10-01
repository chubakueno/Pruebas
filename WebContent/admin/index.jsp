<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="<%=getServletContext().getContextPath() %>/ServletProducto">Registrar Producto</a>
	<a href="<%=getServletContext().getContextPath() %>/ServletCategoria">Registrar Categoria</a>
	<a href="<%=getServletContext().getContextPath() %>/ServletProveedor">Registrar Proveedor</a>
	<a href="<%=getServletContext().getContextPath()%>/CategoriaListar">Listar Categorias</a>
	<a href="<%=getServletContext().getContextPath()%>/ProductoListar">Listar Productos</a>
	<a href="<%=getServletContext().getContextPath()%>/ProveedorListar">Listar Proveedores</a>
</body>
</html>