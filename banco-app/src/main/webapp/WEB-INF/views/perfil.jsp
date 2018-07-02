<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page isELIgnored="false"%>
<%--  Sin esta linea no me funcionaba el JSTL --%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="utf-8">
<title>BancoApp - Perfil</title>

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
				<a class="navbar-brand" href="volver?idUser=${clienteSelec.id}"> <img
					src="<c:url value="/resources/images/inversis.png" />" width="100%"
					height="auto">
				</a>

				<ul class="nav navbar-nav navbar-right">
				<li class="li">Bienvenido:  </li>
					<li class="liforte">${cuentaSelec.usuario.nombre} ${cuentaSelec.usuario.apellido}   </li>
					<li><a class="dropdown" href="perfil?idCuenta=${idCuenta}&idUser=${clienteSelec.id}">Ver Perfil</a></li>
					<li class="dropdown"><a href="#" data-toggle="dropdown"
						class="dropdown-toggle">Operaciones</a>
						<ul class="dropdown-menu">
							<li><a href="movimientos?idCuenta=${idCuenta}">Ver Movimientos</a></li>
							<li>
							<li><a href="ingresar?idCuenta=${idCuenta}">Ingresar</a></li>
							<li><a href="extraer?idCuenta=${idCuenta}">Extraer</a></li>
						</ul></li>
					<li><a href="logout?idUser=${clienteSelec.id}">Salir ></a></li>
				</ul>
			</div>
		</nav>

		<section class="probootstrap-section">
			<div class="container">

				<p>
				<h3>Detalles de perfil:</h3>
				</p>

				<table class="table">
					<tr>
						<th>Nombre:</th>
						<td>${clienteSelec.nombre}
					</tr>
					<tr>
						<th>Apellido:</th>
						<td>${clienteSelec.apellido}
					</tr>
					<tr>
						<th>DNI:</th>
						<td>${clienteSelec.dni}
					</tr>
					<tr>
						<th>&Uacuteltimo acceso:</th>
						<td><c:forEach var="Usuariologin"
								items="${clienteSelec.usuariologins}">
										${Usuariologin.ultimoAcceso}
							</c:forEach></td>
					</tr>
					<tr>
						<th>Cuentas:</th>
						<td><select>
								<option selected>Cuentas disponibles</option>
								<c:forEach var="Cuentas" items="${clienteSelec.cuentas}">
									<option>${Cuentas.numCuenta}</option>
								</c:forEach>
						</select></td>
					</tr>
				</table>
				<div class="fot">
				<a class="btn" href="cuenta?idCuenta=${idCuenta}">Volver</a>
				</div>
			</div>
		</section>

	</div>

	<!-- END wrapper -->


	<script src="<c:url value="/resources/js/scripts.min.js" />"></script>
	<script src="<c:url value="/resources/js/main.min.js" />"></script>
	<script src="<c:url value="/resources/js/custom.js" />"></script>

</body>
</html>