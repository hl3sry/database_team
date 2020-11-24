<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.util.*"%>
<%@ page import="model.Ceo"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	//주의: 아래와 같은  scriptlet은 생략하고 EL로 구현하는 것이 바람직함 (list2.jsp 참조)
@SuppressWarnings("unchecked")
List<Ceo> userList = (List<Ceo>) request.getAttribute("userList");
String curUserId = (String) request.getAttribute("curUserId");
%>
<html>

<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>ceoMain</title>
<meta content="" name="descriptison">
<meta content="" name="keywords">

<!-- Favicons -->
<link href="/Resources/assets/img/favicon.png" rel="icon">
<link href="/Resources/assets/img/apple-touch-icon.png"
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
</style>
</head>

<body>

	<!-- ======= Header Section ======= -->
	<header id="header" class="fixed-top header-transparent">
		<div class="container d-flex align-items-center">
			<h1 class="logo mr-auto">
				<a href="ui02.html" style="font-size: 20px;">우동CaRea_사장님사이트</a>
			</h1>
			<!-- Uncomment below if you prefer to use an image logo -->
			<!-- <a href="index.html" class="logo mr-auto"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>-->

			<nav class="main-nav d-none d-lg-block">
				<ul>
					<li><a href="#">주문확인</a></li>
					<li><a href="#">메뉴관리</a></li>
					<li><a href="#">업소관리</a></li>
					<li class="drop-down"><a href="">help</a>
						<ul>
							<li><a href="#">사용방법</a></li>
							<li><a href="#qna">자주묻는질문</a></li>
							<li><a href="#notice">공지사항</a></li>
						</ul></li>
				</ul>
			</nav>
			<!-- .main-nav-->
		</div>
	</header>
	<!-- End Header -->

	<main id="main">

		<section id="why-us" class="why-us" style="padding-top: 15%;">
			<div class="container-fluid" data-aos="fade-up">
				<header class="section-header">
					<h3>베너 추가</h3>
					<p>이 곳에 베너를 추가할 수 있습니다.</p>
				</header>
			</div>
		</section>

		<!-- ======= Notice, F.A.Q Section ======= -->
		<section id="faq" class="faq">
			<div id="notice" class="container" data-aos="fade-up">
				<header class="section-header">
					<h4 id="noticefont">공지사항</h4>
				</header>
				<div id="noticediv">
					<ul id="faq-list" data-aos="fade-up" data-aos-delay="100">
						<li><a data-toggle="collapse" class="collapsed" href="#">[중요]
								공지사항1 </a></li>
						<li><a data-toggle="collapse" class="collapsed" href="#">[중요]
								공지사항2 </a></li>
						<li><a data-toggle="collapse" class="collapsed" href="#">[중요]
								공지사항3 </a></li>
						<li><a data-toggle="collapse" class="collapsed" href="#">[중요]
								공지사항4 </a></li>
						<li><a data-toggle="collapse" class="collapsed" href="#">[중요]
								공지사항5 </a></li>
					</ul>
				</div>
				<div>
					<button type="submit" title="Send Message" id="more">더보기</button>
				</div>
			</div>

			<div id="qna" class="container" data-aos="fade-up">
				<header class="section-header">
					<h4 id="noticefont">자주묻는질문</h4>
				</header>

				<ul id="faq-list" data-aos="fade-up" data-aos-delay="100">
					<li><a data-toggle="collapse" class="collapsed" href="#faq1">[샘플용]
							등록을 했는데 등록하지 않았다고 뜰 경우 어떻게 해야 하나요?<i class="ion-android-remove"></i>
					</a>
						<div id="faq1" class="collapse" data-parent="#faq-list">
							<p>그럴때는 이렇게 해보세요.</p>
						</div></li>

					<li><a data-toggle="collapse" href="#faq2" class="collapsed">자주
							묻는 질문 <i class="ion-android-remove"></i>
					</a>
						<div id="faq2" class="collapse" data-parent="#faq-list">
							<p>대답</p>
						</div></li>
					<li><a data-toggle="collapse" href="#faq3" class="collapsed">자주
							묻는 질문 <i class="ion-android-remove"></i>
					</a>
						<div id="faq3" class="collapse" data-parent="#faq-list">
							<p>대답</p>
						</div></li>
					<li><a data-toggle="collapse" href="#faq4" class="collapsed">자주
							묻는 질문 <i class="ion-android-remove"></i>
					</a>
						<div id="faq4" class="collapse" data-parent="#faq-list">
							<p>대답</p>
						</div></li>
					<li><a data-toggle="collapse" href="#faq5" class="collapsed">자주
							묻는 질문 <i class="ion-android-remove"></i>
					</a>
						<div id="faq5" class="collapse" data-parent="#faq-list">
							<p>대답</p>
						</div></li>

				</ul>
				<div>
					<button type="submit" title="Send Message" id="more">더보기</button>
				</div>
			</div>
		</section>
		<!-- End F.A.Q Section -->
	</main>
	<!-- End #main -->

	<!-- ======= Footer ======= -->
	<footer id="footer" class="section-bg">
		<div class="footer-top">
			<div class="container">

				<div class="row">

					<div class="col-lg-6">

						<div class="row">

							<div class="col-sm-6">

								<div class="footer-info">
									<h3>우동CaRea</h3>
									<p>우리 동네 Cafe Ready?</p>
								</div>

								<div class="footer-newsletter">
									<h4>Our Information</h4>
									<p>
										대표자: 지혜로운 아이들<br>사업자등록번호: 000-00-00000<br> 성북구
										동덕여자대학교 컴퓨터학과<br> <strong>고객만족센터:</strong> 0000-0000<br>
										<strong>Email:</strong> info@example.com<br>
									</p>
								</div>

							</div>

							<div class="col-sm-6">
								<div class="footer-links">
									<h4>정보5</h4>
									<p>
										내용<br>
									</p>
								</div>

								<div class="footer-links">
									<h4>정보4</h4>
									<p>
										내용<br>
									</p>
								</div>

								<div class="social-links">
									<a href="#" class="twitter"><i class="fa fa-twitter"></i></a> <a
										href="#" class="facebook"><i class="fa fa-facebook"></i></a> <a
										href="#" class="instagram"><i class="fa fa-instagram"></i></a>
									<a href="#" class="linkedin"><i class="fa fa-linkedin"></i></a>
								</div>

							</div>

						</div>

					</div>

					<div class="col-lg-6">

						<div class="form">

							<h4>Send us a email!</h4>
							<p>제휴 문의 및 고객 센터</p>

							<form action="forms/contact.php" method="post" role="form"
								class="php-email-form">
								<div class="form-group">
									<input type="text" name="name" class="form-control" id="name"
										placeholder="Your Name" data-rule="minlen:4"
										data-msg="Please enter at least 4 chars" />
									<div class="validate"></div>
								</div>
								<div class="form-group">
									<input type="email" class="form-control" name="email"
										id="email" placeholder="Your Email" data-rule="email"
										data-msg="Please enter a valid email" />
									<div class="validate"></div>
								</div>
								<div class="form-group">
									<input type="text" class="form-control" name="subject"
										id="subject" placeholder="Subject" data-rule="minlen:4"
										data-msg="Please enter at least 8 chars of subject" />
									<div class="validate"></div>
								</div>
								<div class="form-group">
									<textarea class="form-control" name="message" rows="5"
										data-rule="required" data-msg="Please write something for us"
										placeholder="Message"></textarea>
									<div class="validate"></div>
								</div>

								<div class="mb-3">
									<div class="loading">Loading</div>
									<div class="error-message"></div>
									<div class="sent-message">Your message has been sent.
										Thank you!</div>
								</div>

								<div class="text-center">
									<button type="submit" title="Send Message">Send
										Message</button>
								</div>
							</form>

						</div>

					</div>

				</div>

			</div>
		</div>

		<div class="container">
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