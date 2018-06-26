<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %> <%--  Sin esta linea no me funcionaba el JSTL --%>
<!DOCTYPE html>
<html lang="en">
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
					<li class="li">${cliente.nombre} ${cliente.apellido}</li>
					<li><a href="logout">Salir</a></li>
				</ul>
			</div>
		</nav>

		<section class="probootstrap-section">
			<div class="container">
				<p>
					<strong>Cuentas disponibles:</strong>				
				</p>
					<table class="table" align="center">
					  <tr>
					    <th>Numero de Cuenta</th>
					    <th>Saldo Disponible</th> 
					  </tr>							
					  <tr>
					    <td><c:forEach var="Cuenta" items="${listacuentas}">
										<a href="edit?id=adfg">${Cuenta.numCuenta}</a><br>
							</c:forEach></td>
					    <td>
					    	<c:forEach var="Cuenta" items="${listacuentas}">
										${Cuenta.saldo}<br>
							</c:forEach>
						</td> 
					  </tr>		
					</table>
					<button class="button" >login</button>
					<a class="button" href="volver" >Volver</a>			​
			</div>
		</section>
	</div>
	
	<!-- END wrapper -->
	
	<script src="<c:url value="/resources/js/scripts.min.js" />"></script>
	<script src="<c:url value="/resources/js/main.min.js" />"></script>
	<script src="<c:url value="/resources/js/custom.js" />"></script>
	
</body>

</html>