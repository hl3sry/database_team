<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>loginForm</title>
<meta content="" name="descriptison">
<meta content="" name="keywords">

<!-- Favicons -->
<link href="../Resources/assets/img/favicon.png" rel="icon">
<link href="../Resources/assets/img/apple-touch-icon.png"
	rel="apple-touch-icon">

<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Montserrat:300,400,500,600,700"
	rel="stylesheet">

<!-- Vendor CSS Files -->
<link rel=stylesheet
	href="<c:url value='/Resources/assets/vendor/bootstrap/css/bootstrap.min.css' />"
	type="text/css">
<link rel=stylesheet
	href="<c:url value='/Resources/assets/vendor/font-awesome/css/font-awesome.min.css' />"
	type="text/css">
<link rel=stylesheet
	href="<c:url value='/Resources/assets/vendor/ionicons/css/ionicons.min.css' />"
	type="text/css">
<link rel=stylesheet
	href="<c:url value='/Resources/assets/vendor/venobox/venobox.css' />"
	type="text/css">
<link rel=stylesheet
	href="<c:url value='/Resources/assets/vendor/owl.carousel/assets/owl.carousel.min.css' />"
	type="text/css">
<link rel=stylesheet
	href="<c:url value='/Resources/assets/vendor/aos/aos.css' />"
	type="text/css">

<!-- Template Main CSS File -->
<link rel=stylesheet
	href="<c:url value='/Resources/assets/css/style.css' />"
	type="text/css">

<!-- =======================================================
  * Template Name: Rapid - v2.2.0
  * Template URL: https://bootstrapmade.com/rapid-multipurpose-bootstrap-business-template/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
<style>
#header .logo a {
	color: #f89d00;
}

#main {
	margin-top: 5%;
	display: flex;
	align-items: center;
	justify-content: center;
}

#footer .footer-top {
	padding: 60px 0 30px 0;
	background: #fff;
}

#c {
	position: relative;
	top: 50%;
}

#link {
	position: relative;
	padding: 10%;
	width: 200px;
	margin-top: 10%;
	left: 10%;
}

.main-nav .drop-down ul a:hover, .main-nav .drop-down ul .active>a,
	.main-nav .drop-down ul li:hover>a {
	color: rgb(248, 155, 0);
}

.main-nav a:hover, .main-nav .active>a, .main-nav li:hover>a {
	color: rgb(248, 155, 0);
	text-decoration: none;
}

#footer .php-email-form input[type="button"] {
	background: #f6ae1a;
	border: 0;
	border-radius: 3px;
	padding: 8px 30px;
	color: #fff;
	transition: 0.3s;
	text-align: center;
	vertical-align: center;
}

#footer .php-email-form input[type="button"]:hover {
	border: 0;
	background: #f89d00;
	cursor: pointer;
}

#inpt {
	border: 0;
	width: 150%;
	margin-top: -10%;
	margin-bottom: 15%;
	margin-left: -15%;
	outline: none;
}

#inpt:hover {
	border: 0;
	outline: none;
}
</style>

<script>
	function login() {
		if (form.userId.value == "") {
			alert("사용자 ID를 입력하십시오.");
			form.userId.focus();
			return false;
		}
		if (form.password.value == "") {
			alert("비밀번호를 입력하십시오.");
			form.password.focus();
			return false;
		}
		form.submit();
	}

	function userCreate(targetUri) {
		form.action = targetUri;
		form.submit();
	}
</script>

</head>

<body id="bodyid">

	<!-- ======= Header ======= -->
	<header id="header" class="fixed-top header-transparent">
		<div class="container d-flex align-items-center">
			<h1 class="logo mr-auto">
				<a href="#">우동CaRea</a>
			</h1>
			<!-- Uncomment below if you prefer to use an image logo -->
			<!-- <a href="index.html" class="logo mr-auto"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>-->
		</div>
	</header>
	<!-- End Header -->

	<main id="main">
		<!-- ======= Footer ======= -->
		<footer id="footer" class="section-bg">
			<div class="footer-top">
				<div class="container">

					<div class="row">

						<div class="col-lg-6">

							<div class="form">

								<h2 style="position: relative; left: 50%; color: #000000;">Login</h2>
								<c:if test="${loginFailed}">
									<br>
									<font color="red"><c:out
											value="${exception.getMessage()}" /></font>
									<br>
								</c:if>

								<form name="form" action="" method="POST" role="form"
									class="php-email-form">
									<div class="form-group">
										<div style="margin-bottom: 10%; width: 200%;">
											<input type=radio name="position" value="n1"
												checked="checked">손님 &nbsp;&nbsp;<input type=radio
												name="position" value="n2">사장님
										</div>
									</div>
									<div class="form-group">
										<input type="text" name="userId" class="form-control"
											id="name" placeholder="ID" data-rule="minlen:4"
											data-msg="Please enter at least 4 chars"
											style="width: 180px;" />
										<div class="validate"></div>
									</div>
									<div class="form-group">
										<input type="text" class="form-control" name="password"
											id="name" placeholder="PW" data-rule="minlen:4"
											data-msg="Please enter at least 4 chars"
											style="width: 180px;" />
										<div class="validate"></div>
									</div>
									<div class="mb-3">
										<div class="loading">Loading</div>
										<div class="error-message"></div>
										<div class="sent-message">Your message has been sent.
											Thank you!</div>
									</div>

									<div style="position: relative; left: 50%;">
										<input type="button" value="Login" onClick="login()">
									</div>
								</form>
							</div>

						</div>

					</div>

				</div>
			</div>

			<div class="container" style="position: relative; top: 30%;">
				<div class="copyright">
					<strong><input type="text" value="손님 우동CaRea는 처음이신가요?"
						onClick="userCreate('<c:url value='/client/register/form' />')"
						id="inpt"></strong><br> <strong><input type="text"
						value="사장님 우동CaRea는 처음이신가요?"
						onClick="userCreate('<c:url value='/ceo/register/form' />')"
						id="inpt"></strong><br>

				</div>
				<div class="credits">
					<!--
        All the links in the footer should remain intact.
        You can delete the links only if you purchased the pro version.
        Licensing information: https://bootstrapmade.com/license/
        Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/buy/?theme=Rapid
      -->
					Designed by 지혜로운 아이들
				</div>
			</div>
		</footer>
		<!-- End  Footer -->
	</main>
	<!-- End #main -->

	<!-- Vendor JS Files -->
	<script src="./Resources/assets/vendor/jquery/jquery.min.js"></script>
	<script
		src="./Resources/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script
		src="./Resources/assets/vendor/jquery.easing/jquery.easing.min.js"></script>
	<script src="./Resources/assets/vendor/php-email-form/validate.js"></script>
	<script
		src="./Resources/assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
	<script src="./Resources/assets/vendor/counterup/counterup.min.js"></script>
	<script src="./Resources/assets/vendor/venobox/venobox.min.js"></script>
	<script
		src="./Resources/assets/vendor/owl.carousel/owl.carousel.min.js"></script>
	<script
		src="./Resources/assets/vendor/waypoints/jquery.waypoints.min.js"></script>
	<script src="./Resources/assets/vendor/aos/aos.js"></script>

	<!-- Template Main JS File -->
	<script src="./Resources/assets/js/main.js"></script>

</body>

</html>