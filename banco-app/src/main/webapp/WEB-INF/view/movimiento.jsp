<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
<title>Movimientos</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="" name="keywords">
<meta content="" name="description">

<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,700,700i|Raleway:300,400,500,700,800|Montserrat:300,400,700"
	rel="stylesheet">

<!-- Bootstrap CSS File -->
<link
	href="<c:url value="/resources/lib/bootstrap/css/bootstrap.min.css" />"
	rel="stylesheet">

<!-- Libraries CSS Files -->
<link
	href="<c:url value="/resources/lib/font-awesome/css/font-awesome.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/lib/animate/animate.min.css" />"
	rel="stylesheet">
<link
	href="<c:url value="/resources/lib/ionicons/css/ionicons.min.css" />"
	rel="stylesheet">
<link
	href="<c:url value="/resources/lib/owlcarousel/assets/owl.carousel.min.css" />"
	rel="stylesheet">
<link
	href="<c:url value="/resources/lib/magnific-popup/magnific-popup.css" />"
	rel="stylesheet">
<link
	href="<c:url value="/resources/lib/ionicons/css/ionicons.min.css" />"
	rel="stylesheet">

<!-- Main Stylesheet File -->
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">

</head>

<body id="body">

	<!--==========================
    Header
  ============================-->
	<header id="header">
		<div class="container">

			<div id="logo" class="pull-left">
				<h1>
					<a href="#body" class="scrollto"><img
						src="<c:url value="/resources/banco-inversis.png" />"
						width="300" height="125" style="padding-bottom: 60px;"></a>
				</h1>
				<!-- Uncomment below if you prefer to use an image logo -->
				<!-- <a href="#body"><img src="img/logo.png" alt="" title="" /></a>-->
			</div>

			<nav id="nav-menu-container">
				<ul class="nav-menu">
					<li class="menu-active"><a>Bienvenido: ${usuario.nombre}
							${usuario.apellido}</a></li>
					<li><a href="perfil?idUsuario=${usuario.id}&idCuenta=${cuenta.id}">Ver perfil</a></li>
					<li class="menu-has-children"><a>Operaciones</a>
						<ul>
							<li><a href="movimiento?idUsuario=${usuario.id}&idCuenta=${cuenta.id}">Ver Movimientos</a></li>
							<li><a href="ingresar?idUsuario=${usuario.id}&idCuenta=${cuenta.id}">Ingresar</a></li>
							<li><a href="extraer?idUsuario=${usuario.id}&idCuenta=${cuenta.id}">Extraer</a></li>
						</ul></li>
					<li><a href="login">Salir</a></li>
				</ul>
			</nav>
		</div>
	</header>
	<!-- #header -->

	<!--==========================
    Intro Section
  ============================-->
	<section id="intro">

		<div class="intro-content">
			<div>
				<h2 style="font-size: 45px; padding-top: 25px;">Movimientos de
					Cuenta:</h2>

				<strong style="padding-right: 700px;">${cuenta.numCuenta}</strong> <strong>${cuenta.saldo}</strong>
				<!-- 				todo -->
				<div class="table-responsive" style="padding-top: 10px;">


					<table id="mytable" class="table table-bordred table-striped">

						<thead>
							<tr>
							<th> Fecha</th>
							<th>Hora</th>
							<th>Cantidad</th>
							<th>Operacion</th>
							</tr>	
						</thead>
						<tbody>

							<tr>
								<c:forEach items="${movimiento}" var="movimiento">
										<tr><td>${movimiento.fechaOperacion}</td> <td>${movimiento.cantidad}</td><td>${movimiento.tipoOperacion}</td></tr>
										</c:forEach>
							</tr>


						</tbody>

					</table>

					<div class="clearfix"></div>
					<a href="gestion?idUsuario=${usuario.id}&idCuenta=${cuenta.id}" style="padding-top: 25px;">Volver</a>
				</div>
				<!-- 				todo -->
			</div>
		</div>

	</section>

	<!-- JavaScript Libraries -->
	
	<script src="<c:url value="/resources/lib/jquery/jquery.min.js" />"></script>
	<script
		src="<c:url value="/resources/lib/jquery/jquery-migrate.min.js" />"></script>
	<script
		src="<c:url value="/resources/lib/bootstrap/js/bootstrap.bundle.min.js" />"></script>
	<script src="<c:url value="/resources/lib/easing/easing.min.js" />"></script>
	<script src="<c:url value="/resources/lib/superfish/hoverIntent.js" />"></script>
	<script
		src="<c:url value="/resources/lib/superfish/superfish.min.js" />"></script>
	<script src="<c:url value="/resources/lib/wow/wow.min.js" />"></script>
	<script
		src="<c:url value="/resources/lib/owlcarousel/owl.carousel.min.js" />"></script>
	<script
		src="<c:url value="/resources/lib/magnific-popup/magnific-popup.min.js" />"></script>
	<script src="<c:url value="/resources/lib/sticky/sticky.js" />"></script>
	<script
		src="<c:url value="https://maps.googleapis.com/maps/api/js?key=AIzaSyD8HeI8o-c1NppZA-92oYlXakhDPYR7XMY" />"></script>

	<script src="<c:url value="/resources/contactform/contactform.js" />"></script>


	<!-- Template Main Javascript File -->
	<script src="<c:url value="/resources/js/main.js" />"></script>

</body>
</html>
