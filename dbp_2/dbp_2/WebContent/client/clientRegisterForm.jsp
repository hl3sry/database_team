<%@ page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>clientRegisterForm</title>
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
<!-- <link href="../Resources/assets/css/style.css" rel="stylesheet"> -->
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

#hero {
	background-image: url("./Resources/assets/img/white.png");
	height: 300px;
}

#ddiv {
	position: absolute;
	left: 32%;
	margin-top: 10%;
}

#noticefont {
	text-align: left;
	font-weight: 700;
	position: relative;
	font-family: "Montserrat", sans-serif;
	position: relative;
}

#noticediv {
	margin-top: -15px;
}

#faq #faq-list a {
	padding: 18px 0;
	display: block;
	position: relative;
	font-family: "Montserrat", sans-serif;
	font-size: 15px;
	line-height: 1;
	font-weight: 400;
	padding-right: 20px;
}

#subdiv {
	margin-top: 15px;
	background-color: gray;
}

#twodiv {
	margin-top: 1%;
	margin-left: 10%;
}

#services {
	float: center;
}

#qna {
	margin-top: 50px;
}

#boxes {
	float: center;
	text-align: center;
	margin-left: 30%;
}

#services .box {
	padding: 3px;
	padding-top: 20px;
	position: relative;
	overflow: hidden;
	border-radius: 10px;
	margin: -50px 3px 0px 3px;
	background: #f6ae1a;
	box-shadow: 0 10px 29px 0 rgba(68, 88, 144, 0.1);
	transition: all 0.3s ease-in-out;
	text-align: center;
	position: relative;
}

a {
	color: #f89d00;
	transition: 0.5s;
}

a:hover, a:active, a:focus {
	color: #f89d00;
	outline: none;
	text-decoration: none;
}

.main-nav a:hover, .main-nav .active>a, .main-nav li:hover>a {
	color: #f89d00;
	text-decoration: none;
}

.back-to-top {
	background: #f89d00;
}

.main-nav a {
	color: #000000;
}

.main-nav .drop-down ul a {
	color: #000000;
}

.main-nav .drop-down ul a:hover, .main-nav .drop-down ul .active>a,
	.main-nav .drop-down ul li:hover>a {
	color: rgb(248, 155, 0);
}

#services .box:hover .title a {
	color: rgb(248, 155, 0);
}

.section-bg {
	background: #fff;
}

#footer .footer-top {
	padding: 60px 0 30px 0;
	background: #fff;
}

.section-header h3 {
	color: #000000;
}

.section-header p {
	color: #000000;
}

#footer .footer-top .footer-info h3 {
	color: #000000;
}

#footer .footer-top .footer-info p {
	color: #000000;
}

#footer .footer-top .social-links a {
	background: #ffc107;
	color: #fff;
}

#footer .footer-top .social-links a:hover {
	background: #f89d00;
	color: #fff;
}

#footer .footer-top h4 {
	color: #000000;
}

#footer .footer-top .footer-newsletter input[type="submit"] {
	background: #ffc107;
	border: 1px solid #ffc107;
}

#footer .footer-top .footer-newsletter input[type="submit"]:hover {
	background: #f89d00;
}

#footer .php-email-form button[type="submit"] {
	background: #ffc107;
}

#footer .php-email-form button[type="submit"]:hover {
	background: #f89d00;
}

#more {
	position: relative;
	left: 50%;
	font-family: "Montserrat", sans-serif;
	font-size: 13px;
	font-weight: 600;
	text-transform: uppercase;
	text-align: center;
	letter-spacing: 1px;
	display: inline-block;
	padding: 5px 32px;
	border-radius: 4px;
	border: 4px solid #f6ae1a;
	transition: 0.5s;
	color: #fff;
	background: #f6ae1a;
}

#more:hover {
	position: relative;
	left: 50%;
	font-family: "Montserrat", sans-serif;
	font-size: 13px;
	font-weight: 600;
	text-transform: uppercase;
	text-align: center;
	letter-spacing: 1px;
	display: inline-block;
	padding: 5px 32px;
	border-radius: 4px;
	transition: 0.5s;
	color: #fff;
	background: #f89d00;
	border: 4px solid #f89d00;
}

.customer_info_register, .orderlist, .pickup_time {
	border: 1px solid #f89d00;
	border-radius: 0.3rem;
}

.customer_info, .orderlist, .pickup_time, .buttons {
	margin-top: 30px;
	padding: 10px;
}

.customer_info_contents, .orderlist_contents, .pickup_time_contents {
	margin-top: 20px;
	padding: 5px;
}

.register_name, .register_phone, .register_email, .register_password,
	.register_ceoNum {
	width: 130px;
	height: 60px;
}

#tb_customer_info {
	width: 100%;
	table-layout: fixed;
}

#phone, #privacy_contents, #shopInfo {
	width: 100%;
	padding: 5px;
}

.buttons {
	margin-bottom: 30px;
}

#btn_submit {
	float: right;
}

#btn_cancel, #btn_submit {
	padding: 5px 20px;
	background: #f6ae1a;
	border: 1px solid #f6ae1a;
	border-radius: 3px;
	color: #fff;
	transition: 0.3s;
}

#btn_cancel:hover, #btn_cancel:active, #btn_cancel:focus {
	background: #f89d00;
	border: 1px solid #f89d00;
}

#btn_submit:hover, #btn_submit:active, #btn_submit:focus {
	background: #f89d00;
	border: 1px solid #f89d00;
}

.customer_info_contents {
	position: relative;
	left: 28%;
	width: 700px;
	border-radius: 0.3rem;
	width: 700px;
}

#name, #phone, #email, #password, #ceoNum {
	width: 280px;
	height: 30px;
}

#main {
	margin-left: 40px;
}
</style>
</head>

<script>
	function register() {
		if (form.userId.value == "") {
			alert("ID를 입력하십시오.");
			form.userId.focus();
			return false;
		}
		if (form.password.value == "") {
			alert("비밀번호를 입력하십시오.");
			form.password.focus();
			return false;
		}
		if (form.email.value == "") {
			alert("이메일을 입력하십시오.");
			form.password.focus();
			return false;
		}
		if (form.phone.value == "") {
			alert("핸드폰 번호를 입력하십시오.");
			form.password.focus();
			return false;
		}
		if (form.ceoNum.value == "") {
			alert("사업자 등록번호를 입력하십시오.");
			form.password.focus();
			return false;
		}
		form.submit();
	}

	function userCreate(targetUri) {
		form.action = targetUri;
		form.submit();
	}
	
	function cancel(targetUri) {
		form.action = targetUri;
		form.submit();
	}
</script>

<body>

	<!-- ======= Header Section ======= -->
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
		<div class="container">
			<section id="why-us" class="why-us">
				<form name="form" action="" method="POST">
					<!-- 고객정보 -->
					<div class="customer_info" style="text-align: center;">
						<h3>손님 회원가입</h3>
						<div class="customer_info_contents"">
							<table id="tb_customer_info_register">
								<tr>
									<td class="register_name">Id</td>
									<td><input type="text" id="name" name="userId" /></td>
								</tr>
								<tr>
									<td class="register_password">Password</td>
									<td><input type="password" id="password" name="password" /></td>
								</tr>
								<tr>
									<td class="register_email">Email</td>
									<td><input type="email" id="email" name="email" /></td>
								</tr>
								<tr>
									<td class="register_phone">Phone Number</td>
									<td><input type="tel" id="phone" name="phone" /></td>
								</tr>

							</table>
						</div>
					</div>



					<!-- 제출버튼 -->
					<div class="buttons" style="float: right;">
						<input type="button" id="btn_cancel" value="취소"
							onClick="cancel('<c:url value='/user/login/form' />')">&nbsp;&nbsp;&nbsp;<input
							type="button" id="btn_submit" value="회원가입" onClick="register()">
					</div>

				</form>

			</section>

			<!-- ======= Notice, F.A.Q Section ======= -->

			<!-- End F.A.Q Section -->
		</div>
	</main>
	<!-- End #main -->

	<a href="#" class="back-to-top"><i class="fa fa-chevron-up"></i></a>

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