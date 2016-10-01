<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	String mensaje = (String)request.getAttribute("mensaje");
	%>
	<div class="container-fluid">
	      <div class="row">
	        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
	           <h3><%=mensaje %></h3>
	      	</div>
		</div>
	</div>
</body>
</html>