<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Administrador</title>
<link
	href="<%=getServletContext().getContextPath()%>/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="<%=getServletContext().getContextPath()%>/css/dashboard.css"
	rel="stylesheet">
<script src="<%=getServletContext().getContextPath()%>/js/jquery.js"></script>
<script type="text/javascript">
	function cerrarSesion(){
		if(confirm('¿Esta seguro que desea cerrar sesion?')){
			$("#form").submit();
		}
	}
</script>
<script
	src="<%=getServletContext().getContextPath()%>/js/jquery.validate.min.js"></script>
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<form style="display: hidden"
		action="<%=getServletContext().getContextPath()%>/ServletUsuario"
		method="POST" id="form">
		<input type="hidden" id="campoCorreo" name="campoCorreo" value="" /> <input
			type="hidden" id="campoClave" name="campoClave" value="" />
	</form>