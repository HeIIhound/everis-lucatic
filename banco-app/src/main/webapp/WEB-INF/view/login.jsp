<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page isELIgnored="false"%>
<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html lang="es">
<head>
<title>Login</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link href="<c:url value="/resources/login/images/icons/favicon.ico" />"
	rel="icon" type="image/png">
<link
	href="<c:url value="/resources/login/vendor/bootstrap/css/bootstrap.min.css" />"
	rel="stylesheet" type="text/css">
<link
	href="<c:url value="/resources/login/fonts/font-awesome-4.7.0/css/font-awesome.min.css" />"
	rel="stylesheet" type="text/css">
<link
	href="<c:url value="/resources/login/fonts/Linearicons-Free-v1.0.0/icon-font.min.css" />"
	rel="stylesheet" type="text/css">
<link
	href="<c:url value="/resources/login/vendor/animate/animate.css" />"
	rel="stylesheet" type="text/css">
<link
	href="<c:url value="/resources/login/vendor/css-hamburgers/hamburgers.min.css" />"
	rel="stylesheet" type="text/css">
<link
	href="<c:url value="/resources/login/vendor/animsition/css/animsition.min.css" />"
	rel="stylesheet" type="text/css">
<link
	href="<c:url value="/resources/login/vendor/select2/select2.min.css" />"
	rel="stylesheet" type="text/css">
<link
	href="<c:url value="/resources/login/vendor/daterangepicker/daterangepicker.css" />"
	rel="stylesheet" type="text/css">
<link href="<c:url value="/resources/login/css/util.css" />"
	rel="stylesheet" type="text/css">
<link href="<c:url value="/resources/login/css/main.css" />"
	rel="stylesheet" type="text/css">
</head>
<body>

	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<div class="login100-form-title"></div>

				<form:form class="login100-form validate-form" action="inicio"
					method="post" modelAttribute="Usuariologin">
					<div class="wrap-input100 validate-input m-b-26"
						data-validate="Usuario requerido">
						<span class="label-input100">Usuario</span> <form:input path="user"
							class="input100" type="text"
							placeholder="Introduzca un usuario"/> <span
							class="focus-input100"></span>
					</div>
					${JOptionPane.showMessageDialog(null, "Operación realizada correctamente puñetas")}
					<div class="wrap-input100 validate-input m-b-18"
						data-validate="contraseña requerida">
						<span class="label-input100">Contraseña</span> <form:input path="pass"
							class="input100" type="password"
							placeholder="Introduzca una contraseña" /> <span
							class="focus-input100"></span>
					</div>

					<div class="flex-sb-m w-full p-b-30">
						<div class="contact100-form-checkbox">
							<input class="input-checkbox100" id="ckb1" type="checkbox"
								name="remember-me"> <label class="label-checkbox100"
								for="ckb1"> Recuerdame </label>
						</div>

						<div>
							<a href="--" class="txt1">¿Olvido su contraseña? </a>
						</div>
					</div>

					<div class="container-login100-form-btn">
												<button type="submit" class="login100-form-btn">Iniciar Sesion</button>
					</div>
				</form:form>
			</div>
		</div>
	</div>

	<script
		src="<c:url value="/resources/login/vendor/jquery/jquery-3.2.1.min.js" />"></script>
	<script
		src="<c:url value="/resources/login/vendor/animsition/js/animsition.min.js" />"></script>
	<script
		src="<c:url value="/resources/login/vendor/bootstrap/js/popper.js" />"></script>
	<script
		src="<c:url value="/resources/login/vendor/bootstrap/js/bootstrap.min.js" />"></script>
	<script
		src="<c:url value="/resources/login/vendor/select2/select2.min.js" />"></script>
	<script
		src="<c:url value="/resources/login/vendor/daterangepicker/moment.min.js" />"></script>
	<script
		src="<c:url value="/resources/login/vendor/daterangepicker/daterangepicker.js" />"></script>
	<script
		src="<c:url value="/resources/login/vendor/countdowntime/countdowntime.js" />"></script>
	<script src="<c:url value="/resources/login/js/main.js" />"></script>

</body>
</html>