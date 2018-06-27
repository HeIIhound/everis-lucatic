<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page isELIgnored="false" %> <%--  Sin esta linea no me funcionaba el JSTL --%>
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
				<a class="navbar-brand" href="#"> <img
					src="<c:url value="/resources/images/inversis.png" />" width="100%"
					height="auto">
				</a>

				<ul class="nav navbar-nav navbar-right">
					<li class="li">${clienteSelec.nombre} ${clienteSelec.apellido}</li>
					<li><a>Ver Perfil</a></li>
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
					<h3>Detalles de perfil:</h3>				
				</p>
					<table class="table" align="center">
					  <tr>
					    <th>Nombre:</th>
					    <td>${clienteSelec.nombre}</th> 
					  </tr>							
					  <tr>
					    <th>Apellido:</th>
					    <td>${clienteSelec.apellido}</th> 
					  </tr>		
					  <tr>
					    <th>DNI:</th>
					    <td>${clienteSelec.dni}</th> 
					  </tr>	
					  <tr>
					    <th>Ultimo acceso:</th>
					    <td>
					    	<c:forEach var="Usuariologin" items="${clienteSelec.usuariologins}">
										${Usuariologin.ultimoAcceso}
							</c:forEach></td> 
					  </tr>	
					  <tr>
					    <th>Cuentas:</th>
					    <td>
					    	<select>
					    	<option selected="yes">Cuentas disponibles</option>
							<c:forEach var="Cuentas" items="${clienteSelec.cuentas}">										
								<option>${Cuentas.numCuenta}</option>						
							</c:forEach></td> 
							</select>
						</td> 
					  </tr>		
					</table><br>
				<a class="btn" href="inicio" >Volver</a>
			</div>
		</section>

	</div>

	<!-- END wrapper -->
	
	
	<script src="<c:url value="/resources/js/scripts.min.js" />"></script>
	<script src="<c:url value="/resources/js/main.min.js" />"></script>
	<script src="<c:url value="/resources/js/custom.js" />"></script>

</body>
</html>