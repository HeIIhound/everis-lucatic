<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>BancoApp - Login</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link
	href="<c:url value="/resources/fonts/font-awesome-4.7.0/css/font-awesome.min.css" />"
	rel="stylesheet">
<link
	href="<c:url value="/resources/fonts/iconic/css/material-design-iconic-font.min.css" />"
	rel="stylesheet">

<link href="<c:url value="/resources/css/util.css" />" rel="stylesheet">

<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">

</head>
<body>

	<div class="limiter">
		<div class="container-login100"
			style="background-image: url('resources/images/fondo.jpg');">
			<div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-54">
				<form:form class="login100-form validate-form" method="post"
					name="form" action="inicio" modelAttribute="Usuariologin"
					onsubmit="return checkForm(this);">
					<span class="login100-form-title p-b-10"> Inicio de sesión </span>
					<span class="container-login10011"
						style="background-image: url('resources/images/inversisa.png');"></span>


					<div class="wrap-input100 validate-input m-b-23"
						data-validate="Es necesario un usuario">
						<span class="label-input100">Nombre de usuario</span>
						<form:input class="input100" type="text" path="user" name="user"
							placeholder="Introduzca un usuario" />
						<span class="focus-input100" data-symbol="&#xf206;"></span>
					</div>

					<div class="wrap-input100 validate-input"
						data-validate="Es necesaria una contraseña">
						<span class="label-input100">Contraseña</span>
						<form:input class="input100" type="password" path="pass"
							name="pass" placeholder="Introduzca una contraseña" />
						<span class="focus-input100" data-symbol="&#xf190;"></span>
					</div>

					<div class="container-login100-form-btn">
						<div class="wrap-login100-form-btn">
							<div class="login100-form-bgbtn"></div>
							<button class="login100-form-btn" type="submit">login</button>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>

	<script src="<c:url value="/resources/js/jquery-3.2.1.min.js" />"></script>
	<script src="<c:url value="/resources/js/main.js" />"></script>

</body>
</html>