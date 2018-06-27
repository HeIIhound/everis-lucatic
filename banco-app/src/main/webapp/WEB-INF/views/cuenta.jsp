<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page isELIgnored="false" %> <%--  Sin esta linea no me funcionaba el JSTL --%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="utf-8">
<title>BancoApp - Cuentas</title>

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
				<a class="navbar-brand" href="#"> <img
					src="<c:url value="/resources/images/inversis.png" />" width="100%"
					height="auto">
				</a>

				<ul class="nav navbar-nav navbar-right">
					<li class="li">Bienvenido:  </li>
					<li class="liforte">${cuentaSelec.usuario.nombre} ${cuentaSelec.usuario.apellido}   </li>
					<li><a class="dropdown" href="perfil?id=${cuentaSelec.usuario.id}">Ver Perfil</a></li>					
					<li class="dropdown"><a href="#" data-toggle="dropdown"
						class="dropdown-toggle">Operaciones</a>
						<ul class="dropdown-menu">
							<li><a href="about.html">Ver Movimientos</a></li>
							<li><a href="courses.html">Ingresar</a></li>
							<li><a href="course-single.html">Extraer</a></li>
						</ul></li>
					<li><a href="logout">Salir ></a></li>
				</ul>
			</div>
		</nav>

		<section class="probootstrap-section">
			<div class="container">
				<p>
					<h3>Cuenta seleccionada:</h3>				
				</p>
					<table class="table" align="center">
					  <tr>
					    <th>Numero de cuenta:</th>
					    <td>${cuentaSelec.numCuenta}</th> 
					  </tr>							
					  <tr>
					    <th>Saldo disponible:</th>
					    <td>${cuentaSelec.saldo}</th> 
					  </tr>		
					  <tr>
					    <th>Banco:</th>
					    <td>${cuentaSelec.nomBanco}</th> 
					  </tr>	
					  <tr>
					    <th>Titular:</th>
					    <td>${cuentaSelec.usuario.nombre} ${cuentaSelec.usuario.apellido}</th> 
					  </tr>	
					  <tr>
					    <th>Fecha de alta:</th>
					    <td>${cuentaSelec.fechaDeAlta}</th> 
					  </tr>		
					</table><br>
<!-- 					<a class="btn" href="inicio" >Volver</a>		 -->
						<form:form  method="post" action="inicio" modelAttribute="Usuariologin">
						<button class="btn" type="submit">Volver</button>
						</form:form>
			</div>
		</section>

	</div>

	<!-- END wrapper -->
	
	
	<script src="<c:url value="/resources/js/scripts.min.js" />"></script>
	<script src="<c:url value="/resources/js/main.min.js" />"></script>
	<script src="<c:url value="/resources/js/custom.js" />"></script>

</body>
</html>