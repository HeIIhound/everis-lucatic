<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page isELIgnored="false"%><%--  Sin esta linea no me funcionaba el JSTL --%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="utf-8">
<title>BancoApp - Ingresar</title>

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
				<a class="navbar-brand"
					href="volver?idUser=${cuentaSelec.usuario.id}"> <img
					src="<c:url value="/resources/images/inversis.png" />" width="100%"
					height="auto">
				</a>

				<ul class="nav navbar-nav navbar-right">
					<li class="li">Bienvenido:</li>
					<li class="liforte">${cuentaSelec.usuario.nombre}
						${cuentaSelec.usuario.apellido}</li>
					<li><a class="dropdown"
						href="perfil?idCuenta=${cuentaSelec.id}&idUser=${cuentaSelec.usuario.id}">Ver
							Perfil</a></li>
					<li class="dropdown"><a href="#" data-toggle="dropdown"
						class="dropdown-toggle">Operaciones</a>
						<ul class="dropdown-menu">
							<li><a href="movimientos?idCuenta=${cuentaSelec.id}">Ver
									Movimientos</a></li>
							<li><a href="extraer?idCuenta=${cuentaSelec.id}">Extraer</a></li>
						</ul></li>
					<li><a href="logout?idUser=${cuentaSelec.usuario.id}">Salir
							></a></li>
				</ul>
			</div>
		</nav>

		<section class="probootstrap-section">
			<div class="container">
				<h3>Ingresar en cuenta:</h3>
				<table class="tableSimple">
					<tr>
						<th>Número:</th>
						<td>${cuentaSelec.numCuenta}</td>
						<th>Saldo:</th>
						<td>${cuentaSelec.saldo}&#8364</td>
					</tr>
				</table>
				<br>
				<div class="oper">
					<form method="post" action="operativa" name="ingresarForm">
						<strong>Cantidad: </strong> <input class="textbox" name="cantidad"
							type="number" maxlength="22" size="30" min="0.01" step=".01"
							required="required" placeholder="Introduzca una cantidad">
						<strong> €</strong><br>
						<br> <input type="hidden" name="idCuenta"
							value="${cuentaSelec.id}" /> <input type="hidden"
							name="operativa" value="ingresar" />
						<button type="submit" class="btn" value="Ingresar una cantidad">Ingresar</button>
					</form>

				</div>
				<div class="fot">
					<a class="btn" href="cuenta?idCuenta=${cuentaSelec.id}">Volver</a>
				</div>
			</div>
		</section>

	</div>

	<!-- END wrapper -->

	<script src="<c:url value="/resources/js/scripts.min.js" />"></script>
	<script src="<c:url value="/resources/js/main.min.js" />"></script>

</body>
</html>