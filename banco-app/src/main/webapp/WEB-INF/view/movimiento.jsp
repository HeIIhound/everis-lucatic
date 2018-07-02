<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="es">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Inicio</title>

<!-- Bootstrap core CSS -->
<link
	href="<c:url value="/resources/inicio/vendor/bootstrap/css/bootstrap.min.css" />"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="<c:url value="/resources/inicio/css/logo-nav.css" />"
	rel="stylesheet">

<link href="<c:url value="/resources/inicio/css/logo-nav.css" />">
</head>

<body>

	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
		<div class="container">
			<a class="navbar-brand" href="#"> <img
				src="<c:url value="/resources/inicio/images/banco-inversis.png" />"
				width="250" height="50">
			</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item active"><a class="nav-link">Bienvenido:  ${usuario.nombre} ${usuario.apellido}</a></li>
					<li class="nav-item active"><a class="nav-link" href="perfil?idUsuario=${usuario.id}&idCuenta=${cuenta.id}">Ver Perfil</a></li>
					<li class="nav-item active"><a class="nav-link">Operaciones:</a></li>
					<li class="nav-item active"><a class="nav-link">Ver Movimientos</a></li>
					<li class="nav-item active"><a class="nav-link">Ingresar</a></li>
					<li class="nav-item active"><a class="nav-link">Extraer</a></li>
					<li class="nav-item active"><a class="nav-link" href="login">Salir</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<!-- Page Content -->
	<div class="container" style="
    padding-top: 250px;
    padding-left: 220px;
    padding-right: 300px;
    text-align: -webkit-center;
">
			<strong style="padding-left: 100px;">Movimientos de cuenta:</strong>
			
				<strong>${movimiento.fechaOperacion}</strong>
				<strong>${movimiento.cantidad}</strong>
				<strong>${movimiento.tipoOperacion}</strong>                    
				 
				 
				 <a class="nav-link" href="gestionVolverDesdeMovimiento?idUsuario=${usuario.id}&idCuenta=${cuenta.id}">Volver</a>
	</div>
	<!-- /.container -->

	<!-- Bootstrap core JavaScript -->
	<script
		src="<c:url value="/resources/inicio/vendor/jquery/jquery.min.js" />"></script>
	<script
		src="<c:url value="/resources/inicio/vendor/bootstrap/js/bootstrap.bundle.min.js" />"></script>

</body>

</html>
