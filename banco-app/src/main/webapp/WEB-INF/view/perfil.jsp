<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
<title>Inicio</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="" name="keywords">
<meta content="" name="description">

<!-- Favicons -->
<link href="img/favicon.png" rel="icon">
<link href="img/apple-touch-icon.png" rel="apple-touch-icon">

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
    Top Bar
  ============================-->
	<section id="topbar" class="d-none d-lg-block">
		<div class="container clearfix">
			<div class="contact-info float-left">
				<i class="fa fa-envelope-o"></i> <a
					href="mailto:contact@example.com">orlando.jesus.pereira.bringtown.sa@everis.com</a>
			</div>
		</div>
	</section>

	<!--==========================
    Header
  ============================-->
	<header id="header">
		<div class="container">

			<div id="logo" class="pull-left">
				<h1>
					<a href="#body" class="scrollto"><img
						src="<c:url value="/resources/inicio/images/banco-inversis.png" />"
						width="300" height="125" style="padding-bottom: 60px;"></a>
				</h1>
				<!-- Uncomment below if you prefer to use an image logo -->
				<!-- <a href="#body"><img src="img/logo.png" alt="" title="" /></a>-->
			</div>

			<nav id="nav-menu-container">
				<ul class="nav-menu">
					<li class="menu-active"><a>Bienvenido: ${usuario.nombre}
							${usuario.apellido}</a></li>
					<li><a href="login">Salir</a></li>
				</ul>
			</nav>
			<!-- #nav-menu-container -->
		</div>
	</header>
	<!-- #header -->

	<!--==========================
    Intro Section
  ============================-->
	<section id="intro">

		<div class="intro-content">
			<div>
			<h2 style="font-size:45px; padding-top: 25px;">Detalles del perfil</h2>
				<!-- 				todo -->
				<table class="table table-user-information">
					<tbody>
						<tr>
							<td><strong>Nombre:</strong></td>
							<td>${usuario.nombre}</td>
						</tr>
						<tr>
							<td><strong>Apellido:</strong></td>
							<td>${usuario.apellido}</td>
						</tr>
						<tr>
							<td><strong>DNI:</strong></td>
							<td>${usuario.dni}</td>
						</tr>

						<tr>
						<tr>
							<td><strong>Ultimo Acceso:</strong></td>
							<td><c:forEach items="${usuariologin}" var="usuariologin">${usuariologin.ultimoAcceso}</c:forEach></td>
						</tr>
						<tr>
							<td><strong>Cuentas disponibles:</strong></td>
							<td><c:forEach items="${c}" var="c">
								${c.numCuenta}<br>
									<br>
								</c:forEach></td>
						</tr>
					</tbody>
				</table>
				<!-- 				todo -->
			</div>
		</div>

		<div id="intro-carousel" class="owl-carousel">
			<div class="item"
				style="background-image: url('/resources/img/intro-carousel/1.jpg');"></div>
			<div class="item"
				style="background-image: url('/resources/img/intro-carousel/2.jpg');"></div>
			<div class="item"
				style="background-image: url('/resources/img/intro-carousel/3.jpg');"></div>
			<div class="item"
				style="background-image: url('/resources/img/intro-carousel/4.jpg');"></div>
			<div class="item"
				style="background-image: url('/resources/img/intro-carousel/5.jpg');"></div>
		</div>

	</section>
	<!-- #intro -->

	<a href="#" class="back-to-top"><i class="fa fa-chevron-up"></i></a>

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
