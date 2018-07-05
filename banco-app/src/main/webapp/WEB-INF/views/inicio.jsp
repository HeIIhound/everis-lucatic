<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page isELIgnored="false"%><%--  Sin esta linea no me funcionaba el JSTL --%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>BancoApp - Inicio</title>

<link
	href="https://fonts.googleapis.com/css?family=Raleway:300,400,500,700|Open+Sans"
	rel="stylesheet">
<link href="<c:url value="/resources/css/styles-merged.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/style.min.css" />"
	rel="stylesheet">

</head>
<body>
	<div class="probootstrap-page-wrapper">
		<!-- Fixed navbar -->

		<nav class="navbar navbar-default probootstrap-navbar">
			<div class="container">
				<a class="navbar-brand" href="volver?idUser=${cliente.id}"> <img
					src="<c:url value="/resources/images/inversis.png" />" width="100%"
					height="auto">
				</a>

				<ul class="nav navbar-nav navbar-right">
					<li class="li">Bienvenido:</li>
					<li class="liforte">${cliente.nombre}&nbsp${cliente.apellido}</li>
					<li><a href="logout?idUser=${cliente.id}">Salir ></a></li>
				</ul>
			</div>
		</nav>

		<section class="probootstrap-section">
			<div class="container">
				<h3>Cuentas disponibles:</h3>
				<table class="table">
					<tr>
						<th>Número de Cuenta</th>
						<th>Saldo Disponible</th>
					</tr>
					<c:forEach var="Cuenta" items="${cliente.cuentas}">
						<tr>
							<td><a href="cuenta?idCuenta=${Cuenta.id}">${Cuenta.numCuenta}</a></td>
							<td>${Cuenta.saldo}&#8364</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</section>
	</div>

	<!-- END wrapper -->

	<script src="<c:url value="/resources/js/scripts.min.js" />"></script>
	<script src="<c:url value="/resources/js/main.min.js" />"></script>

</body>

</html>