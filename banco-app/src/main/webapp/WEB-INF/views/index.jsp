<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Login V2</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->
	<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<spring:url value="/resources/vendor/bootstrap/css/bootstrap.min.css" var="estilos" />
	<link href="${estilos}" rel="stylesheet" />
<!--===============================================================================================-->
	<spring:url value="/resources/fonts/font-awesome-4.7.0/css/font-awesome.min.css" var="estilos1" />
	<link href="${estilos1}" rel="stylesheet" />
<!--===============================================================================================-->
	<spring:url value="/resources/fonts/iconic/css/material-design-iconic-font.min.css" var="estilos2" />
	<link href="${estilos2}" rel="stylesheet" />
<!--===============================================================================================-->
	<spring:url value="/resources/vendor/animate/animate.css" var="estilos3" />
	<link href="${estilos3}" rel="stylesheet" />
<!--===============================================================================================-->
	<spring:url value="/resources/vendor/css-hamburgers/hamburgers.min.css" var="estilos4" />
	<link href="${estilos4}" rel="stylesheet" />
<!--===============================================================================================-->
	<spring:url value="/resources/vendor/animsition/css/animsition.min.css" var="estilos5" />
	<link href="${estilos5}" rel="stylesheet" />
<!--===============================================================================================-->
	<spring:url value="/resources/vendor/select2/select2.min.css" var="estilos6" />
	<link href="${estilos6}" rel="stylesheet" />
<!--===============================================================================================-->	
	<spring:url value="/resources/vendor/daterangepicker/daterangepicker.css" var="estilos7" />
	<link href="${estilos7}" rel="stylesheet" />
<!--===============================================================================================-->
	<spring:url value="/resources/css/util.css" var="estilos8" />
	<link href="${estilos8}" rel="stylesheet" />
	
	<spring:url value="/resources/css/main.css" var="estilos9" />
	<link href="${estilos9}" rel="stylesheet" />
<!--===============================================================================================-->
</head>
<body>
	
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<form class="login100-form validate-form">
					<span class="login100-form-title p-b-26">
						Bienvenido
					</span>
					<span class="login100-form-title p-b-48">
						<i class="zmdi zmdi-font"></i>
					</span>

					<div class="wrap-input100 validate-input" data-validate = "Valid email is: a@b.c">
						<input class="input100" type="text" name="email">
						<span class="focus-input100" data-placeholder="Email"></span>
					</div>

					<div class="wrap-input100 validate-input" data-validate="Enter password">
						<span class="btn-show-pass">
							<i class="zmdi zmdi-eye"></i>
						</span>
						<input class="input100" type="password" name="pass">
						<span class="focus-input100" data-placeholder="Password"></span>
					</div>

					<div class="container-login100-form-btn">
						<div class="wrap-login100-form-btn">
							<div class="login100-form-bgbtn"></div>
							<button class="login100-form-btn">
								Login
							</button>
						</div>
					</div>

					<div class="text-center p-t-115">
						<span class="txt1">
							¿No estás registrado?
						</span>

						<a class="txt2" href="#">
							Sign Up
						</a>
					</div>
				</form>
			</div>
		</div>
	</div>
	

	<div id="dropDownSelect1"></div>
	
<!--===============================================================================================-->
	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/daterangepicker/moment.min.js"></script>
	<script src="vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
	<script src="js/main.js"></script>

</body>
</html>