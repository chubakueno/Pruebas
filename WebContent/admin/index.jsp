<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Administrador</title>
    <link href="<%=getServletContext().getContextPath()%>/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=getServletContext().getContextPath()%>/css/signin.css" rel="stylesheet">
    
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>
    <div class="container">
      <form class="form-signin" action="<%=getServletContext().getContextPath()%>/ServletUsuario" method="post">
        <h2 class="form-signin-heading">Inicia sesión</h2>
        <label for="inputEmail" class="sr-only">Usuario</label>
        <input
        oninvalid="this.setCustomValidity('Falta llenar el campo Usuario');" 
		oninput="setCustomValidity('')"
        type="text" id="campoCorreo" name="campoCorreo" class="form-control" placeholder="ingresa tu correo" required autofocus>
        <label for="inputPassword" class="sr-only">Clave</label>
        <input
        oninvalid="this.setCustomValidity('Falta llenar el campo Contrasena');" 
		oninput="setCustomValidity('')"
        type="password" id="campoClave" name="campoClave" class="form-control" placeholder="ingresa tu clave" required>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Ingresar</button>
      </form>
    </div>
  </body>
</html>