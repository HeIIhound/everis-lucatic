<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>BancoApp - Cuentas</title>

<link
	href="https://fonts.googleapis.com/css?family=Raleway:300,400,500,700|Open+Sans"
	rel="stylesheet">
<link href="<c:url value="/resources/css/styles-merged.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/style.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/custom.css" />"
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
					<li><a>${cliente.Nombre}</a></li>
					<li><a>Ver Perfil</a></li>
					<li class="dropdown"><a href="#" data-toggle="dropdown"
						class="dropdown-toggle">Operaciones</a>
						<ul class="dropdown-menu">
							<li><a href="about.html">Ver Movimientos</a></li>
							<li><a href="courses.html">Ingresar</a></li>
							<li><a href="course-single.html">Extraer</a></li>
						</ul></li>
					<li><a href="login">Salir</a></li>
				</ul>
			</div>
		</nav>

		<section class="probootstrap-section">
			<div class="container">
				${cliente.nombre}
				${cliente.Nombre}
				${cliente.apellido}
				<table>
				<tr>
								<th>Nombre</th>
								<td>${contact.nombre}</td>
							</tr>
				</table>
				<p>
				<table style="width: 100%">
				<tr>
								<th>Nombre</th>
								<td>${contact.nombre}</td>
							</tr>
				</table>
				Inicialmente, fue una entidad especializada en productos de
					inversión cuyos servicios estaban dirigidos a clientes,
					particulares e instituciones. El banco basaba su negocio en la
					oferta de productos de inversión de terceros a través de dos
					plataformas de contratación: la plataforma de fondos de inversión y
					la plataforma de renta variable. Al cierre del primer cuatrimestre
					de 2013, gestionaba un patrimonio de 40.600 millones de euros de
					activos, de los que 4.500 correspondían a particulare El 28 de
					junio de 2013, se anunció que Banca Privada de Andorra (BPA),
					matriz de Banco Madrid, había logrado quedarse con el 100% de
					Inversis Banco gracias a una oferta de 215 millones de e Sin
					embargo, el 12 de julio de 2013 Banca March, que tenía el 5% del
					capital de Inversis Banco, comunicó el ejercicio de su derecho de
					tanteo6​ de la mano de Andbank y Orey Antunes. Ejercieron el
					derecho de adquisición preferente, junto a Orey Antunes, y a la
					vez, le venderían el negocio de banca privada minorista de Inversis
					a Andbank por 179,8 millones.7​ En enero de 2014, Banca March pasó
					a controlar el 100% del capital social de Inversis. Una vez se
					ejecutara la segregación del negocio de banca minorista a Andbank,
					Banca March vendería al grupo portugués Orey Antunes una
					participación del 50% de Inversis.8​ El 28 de noviembre de 2014,
					Andbank culminó la incorporación del negocio de banca personal y
					privada de Inversis.9​ Desde ese momento, Banco Inversis, una vez
					escindido el negocio de banca privada minorista, centró su negocio
					en el ámbito institucional incluido el negocio relacionado con el
					Área Mercado de Capitales.3​ El 8 de enero de 2016, culminó el
					proceso de cambio accionarial iniciado en julio de 2013. Así, una
					vez recibidas las aprobaciones pertinentes por parte del Banco
					Central Europeo (BCE) y la Comisión Nacional del Mercado de Valores
					(CNMV), el Grupo Orey adquirió el 49,99% del capital social de
					Banco Inversis, ostentando Banca March el 50,01% restante,
					integrándose Banco Inversis en el Grupo Banca March a efectos
					contables y regulatorios.3​
			</div>
		</section>

	</div>

	<!-- END wrapper -->
	
	
	<script src="<c:url value="/resources/js/scripts.min.js" />"></script>
	<script src="<c:url value="/resources/js/main.min.js" />"></script>
	<script src="<c:url value="/resources/js/custom.js" />"></script>

</body>
</html>