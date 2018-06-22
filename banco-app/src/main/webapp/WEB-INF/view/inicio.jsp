<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="es">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Logo Nav - Start Bootstrap Template</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/inicio/vendor/bootstrap/css/bootstrap.min.css" />" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<c:url value="/resources/inicio/css/logo-nav.css" />" rel="stylesheet">

	 <link href="<c:url value="/resources/inicio/css/logo-nav.css" />" >
  </head>

  <body>

    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container">
        <a class="navbar-brand" href="#">
          <img src="<c:url value="/resources/inicio/images/banco-inversis.png" />" width="250" height="50">
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item active">
              <a class="nav-link" href="#">Home
                <span class="sr-only">(current)</span>
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">About</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Services</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Contact</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>

    <!-- Page Content -->
    <div class="container">
      <h1 class="mt-5">Logo Nav by Start Bootstrap</h1>
      <p>The logo in the navbar is now a default Bootstrap feature in Bootstrap 4! Make sure to set the width and height of the logo within the HTML. For best results, it's recommended that you use an SVG image as your logo.</p>
    </div>
    <!-- /.container -->

    <!-- Bootstrap core JavaScript -->
	<script
		src="<c:url value="/resources/inicio/vendor/jquery/jquery.min.js" />"></script>
		<script
		src="<c:url value="/resources/inicio/vendor/bootstrap/js/bootstrap.bundle.min.js" />"></script>
	
  </body>

</html>
