<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>clientMain</title>
<meta content="" name="descriptison">
<meta content="" name="keywords">

<!-- Favicons -->
<link href="./Resources/assets/img/favicon.png" rel="icon">
<link href="./Resources/assets/img/apple-touch-icon.png"
	rel="apple-touch-icon">

<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Montserrat:300,400,500,600,700"
	rel="stylesheet">

<!-- Vendor CSS Files -->
<link href="./Resources/assets/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="./Resources/assets/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">
<link href="./Resources/assets/vendor/ionicons/css/ionicons.min.css"
	rel="stylesheet">
<link href="./Resources/assets/vendor/venobox/venobox.css"
	rel="stylesheet">
<link
	href="./Resources/assets/vendor/owl.carousel/assets/owl.carousel.min.css"
	rel="stylesheet">
<link href="./Resources/assets/vendor/aos/aos.css" rel="stylesheet">

<!-- Template Main CSS File -->
<link href="./Resources/assets/css/style.css" rel="stylesheet">

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
	height: 450px;
	display: flex;
	justify-content: center;
}

#uldiv {
	width: 30%;
}

#ulid {
	margin-left: 3%;
	margin-right: 3%;
}

#llist1 {
	list-style: none;
	margin-left: -10%;
	padding-left: 30%;
	padding-right: 30%;
}

#llist2 {
	list-style: none;
	margin-top: -21%;
	margin-left: 40%;
	padding-left: 30%;
	padding-right: 30%;
}

#llist3 {
	list-style: none;
	margin-top: -21%;
	margin-left: 85%;
	padding-left: 30%;
	padding-right: 30%;
}

#listfont {
	font-size: 28px;
}

#ddiv {
	position: relative;
	left: 5%;
	margin-top: 10%;
}

#twodiv {
	margin-top: 1%;
	margin-left: 10%;
}

#services {
	float: center;
}

#container {
	display: flex;
	align-items: center;
	justify-content: center;
}

#boxes {
	display: flex;
	align-items: center;
	justify-content: center;
}

#box {
	height: 30px;
	width: 350px;
}

#services .box {
  padding: 30px;
  position: relative;
  overflow: hidden;
  border-radius: 10px;
  margin: 0 10px 40px 10px;
  background: #f6ae1a;
  box-shadow: 0 10px 29px 0 rgba(68, 88, 144, 0.1);
  transition: all 0.3s ease-in-out;
  text-align: center;
}

#services .box:hover {
  transform: scale(1.1);
  background: #f89d00;
}

#services .title a {
  color: #fff;
}

#services .box:hover .title a {
  color: #fff;
}

.main-nav .drop-down ul a:hover, .main-nav .drop-down ul .active>a,
	.main-nav .drop-down ul li:hover>a {
	color: rgb(248, 155, 0);
}

.main-nav a:hover, .main-nav .active>a, .main-nav li:hover>a {
	color: rgb(248, 155, 0);
	text-decoration: none;
}

#hero .intro-info .btn-get-started, #hero .intro-info .btn-services {
	background: #f6ae1a;
}

.back-to-top {
	background: #f89d00;
}

#services .box:hover .title a {
	color: rgb(248, 155, 0);
}

.main-nav .drop-down ul a:hover, .main-nav .drop-down ul .active>a,
	.main-nav .drop-down ul li:hover>a {
	color: #f89d00;
}

.main-nav a {
	color: #000000;
}

.main-nav .drop-down ul a {
	color: #000000;
}

#btn {
	position: relative;
	margin-top: 1%;
	margin-left: 5%;
	height: 14%;
	font-family: "Montserrat", sans-serif;
	font-size: 13px;
	font-weight: 600;
	text-transform: uppercase;
	text-align: center;
	letter-spacing: 1px;
	display: inline-block;
	padding: 10px 32px;
	border-radius: 4px;
	transition: 0.5s;
	color: #fff;
	background: #f6ae1a;
	color: #fff;
	font-family: "Montserrat", sans-serif;
	margin-left: 5%;
}

a {
	color: #f6ae1a;
	transition: 0.5s;
}

a:hover, a:active, a:focus {
	color: #f89d00;
	outline: none;
	text-decoration: none;
}

#faq #faq-list a.collapse {
	color: #f89d00;
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
				<a href="ui01.html">우동CaRea</a>
			</h1>
			<!-- Uncomment below if you prefer to use an image logo -->
			<!-- <a href="index.html" class="logo mr-auto"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>-->

			<nav class="main-nav d-none d-lg-block">
				<ul>
					<li><a href="#">마이페이지</a></li>
					<li><a href="#">주문내역</a></li>
					<li><a href="#">고객센터</a></li>
				</ul>
			</nav>
			<!-- .main-nav-->
		</div>
	</header>
	<!-- End Header -->

	<main id="main">

		<!-- ======= Hero Section ======= -->
		<section id="hero" class="clearfix">
			<div class="container d-flex" id="ddiv">
				<h3 style="margin-top: 1.5%;">현재 위치는</h3>
				<div id="uldiv">
					<nav class="main-nav d-none d-lg-block">
						<ul id="ulid">
							<li class="drop-down" id="llist1"><a href="#" id="listfont">시/도</a>
								<ul>
									<li><a href="#">Deep Drop Down 1</a></li>
									<li><a href="#">Deep Drop Down 2</a></li>
									<li><a href="#">Deep Drop Down 3</a></li>
									<li><a href="#">Deep Drop Down 4</a></li>
									<li><a href="#">Deep Drop Down 5</a></li>
								</ul></li>
							<li class="drop-down" id="llist2"><a href="#" id="listfont">구/군</a>
								<ul>
									<li><a href="#">Deep Drop Down 1</a></li>
									<li><a href="#">Deep Drop Down 2</a></li>
									<li><a href="#">Deep Drop Down 3</a></li>
									<li><a href="#">Deep Drop Down 4</a></li>
									<li><a href="#">Deep Drop Down 5</a></li>
								</ul></li>
							<li class="drop-down" id="llist3"><a href="#" id="listfont">동/읍/면</a>
								<ul>
									<li><a href="#">Deep Drop Down 1</a></li>
									<li><a href="#">Deep Drop Down 2</a></li>
									<li><a href="#">Deep Drop Down 3</a></li>
									<li><a href="#">Deep Drop Down 4</a></li>
									<li><a href="#">Deep Drop Down 5</a></li>
								</ul></li>
						</ul>
					</nav>
				</div>
				<h3 style="margin-top: 1.5%; margin-left: 21%;">입니다!</h3>
				<a href="#" class="btn-get-started scrollto" id="btn">Search</a>
			</div>
		</section>
		<!-- End Hero -->

		<!-- ======= Services Section ======= -->
		<section id="services">
			<div class="container" data-aos="fade-up" id="boxes">
				<div class="row">
					<div class="col-md-6 col-lg-4" data-aos-delay="100">
						<div class="box" id="box">
							<h4 class="title" style="color: #fff;">
								<a href="" style="color: #fff;">거리순</a>
							</h4>
						</div>
					</div>
					<div class="col-md-6 col-lg-4" data-aos-delay="200">
						<div class="box" id="box" style="margin-left: 50%;">
							<h4 class="title" style="color: #fff;">
								<a href="" style="color: #fff;">추천순</a>
							</h4>
						</div>
					</div>
				</div>
			</div>

			<!-- ======= F.A.Q Section ======= -->
			<div id="faq" class="faq">
				<div class="container" data-aos="fade-up">
					<ul id="faq-list" data-aos="fade-up" data-aos-delay="1000">
						<li><a data-toggle="collapse" class="collapsed" href="#faq1">카페밀크콩<i
								class="ion-android-remove"></i>
						</a>
							<div id="faq1" class="collapse" data-parent="#faq-list">
								<p>설명</p>
								<div align="center" style="width: 100%; margin-bottom: 5%;">
									<div
										style="font: normal normal 400 12px/normal dotum, sans-serif; width: 640px; height: 282px; color: #333; position: relative">
										<div style="height: 250px;">
											<a
												href="https://map.kakao.com/?urlX=509230.0&amp;urlY=1140949.0&amp;itemId=8917867&amp;q=%EB%8F%99%EB%8D%95%EC%97%AC%EC%9E%90%EB%8C%80%ED%95%99%EA%B5%90&amp;srcid=8917867&amp;map_type=TYPE_MAP&amp;from=roughmap"
												target="_blank"><img class="map"
												src="//t1.daumcdn.net/roughmap/imgmap/73627ca9d6399387642bb90fa1f299d5a746917067884f26d27d70b2d5a1f55c"
												width="638px" height="248px" style="border: 1px solid #ccc;"></a>
										</div>
										<div
											style="overflow: hidden; padding: 7px 11px; border: 1px solid rgba(0, 0, 0, 0.1); border-radius: 0px 0px 2px 2px; background-color: rgb(249, 249, 249);">
											<a href="https://map.kakao.com" target="_blank"
												style="float: left;"><img
												src="//t1.daumcdn.net/localimg/localimages/07/2018/pc/common/logo_kakaomap.png"
												width="72" height="16" alt="카카오맵"
												style="display: block; width: 72px; height: 16px"></a>
											<div
												style="float: right; position: relative; top: 1px; font-size: 11px;">
												<a target="_blank"
													href="https://map.kakao.com/?from=roughmap&amp;srcid=8917867&amp;confirmid=8917867&amp;q=%EB%8F%99%EB%8D%95%EC%97%AC%EC%9E%90%EB%8C%80%ED%95%99%EA%B5%90&amp;rv=on"
													style="float: left; height: 15px; padding-top: 1px; line-height: 15px; color: #000; text-decoration: none;">로드뷰</a><span
													style="width: 1px; padding: 0; margin: 0 8px 0 9px; height: 11px; vertical-align: top; position: relative; top: 2px; border-left: 1px solid #d0d0d0; float: left;"></span><a
													target="_blank"
													href="https://map.kakao.com/?from=roughmap&amp;eName=%EB%8F%99%EB%8D%95%EC%97%AC%EC%9E%90%EB%8C%80%ED%95%99%EA%B5%90&amp;eX=509230.0&amp;eY=1140949.0"
													style="float: left; height: 15px; padding-top: 1px; line-height: 15px; color: #000; text-decoration: none;">길찾기</a><span
													style="width: 1px; padding: 0; margin: 0 8px 0 9px; height: 11px; vertical-align: top; position: relative; top: 2px; border-left: 1px solid #d0d0d0; float: left;"></span><a
													target="_blank"
													href="https://map.kakao.com?map_type=TYPE_MAP&amp;from=roughmap&amp;srcid=8917867&amp;itemId=8917867&amp;q=%EB%8F%99%EB%8D%95%EC%97%AC%EC%9E%90%EB%8C%80%ED%95%99%EA%B5%90&amp;urlX=509230.0&amp;urlY=1140949.0"
													style="float: left; height: 15px; padding-top: 1px; line-height: 15px; color: #000; text-decoration: none;">지도
													크게 보기</a>
											</div>
										</div>
									</div>
								</div>
							</div></li>

						<li><a data-toggle="collapse" href="#faq2" class="collapsed">카페다온
								<i class="ion-android-remove"></i>
						</a>
							<div id="faq2" class="collapse" data-parent="#faq-list">
								<p>설명</p>
								<div align="center" style="width: 100%; margin-bottom: 5%;">
									<div
										style="font: normal normal 400 12px/normal dotum, sans-serif; width: 640px; height: 282px; color: #333; position: relative">
										<div style="height: 250px;">
											<a
												href="https://map.kakao.com/?urlX=509230.0&amp;urlY=1140949.0&amp;itemId=8917867&amp;q=%EB%8F%99%EB%8D%95%EC%97%AC%EC%9E%90%EB%8C%80%ED%95%99%EA%B5%90&amp;srcid=8917867&amp;map_type=TYPE_MAP&amp;from=roughmap"
												target="_blank"><img class="map"
												src="//t1.daumcdn.net/roughmap/imgmap/73627ca9d6399387642bb90fa1f299d5a746917067884f26d27d70b2d5a1f55c"
												width="638px" height="248px" style="border: 1px solid #ccc;"></a>
										</div>
										<div
											style="overflow: hidden; padding: 7px 11px; border: 1px solid rgba(0, 0, 0, 0.1); border-radius: 0px 0px 2px 2px; background-color: rgb(249, 249, 249);">
											<a href="https://map.kakao.com" target="_blank"
												style="float: left;"><img
												src="//t1.daumcdn.net/localimg/localimages/07/2018/pc/common/logo_kakaomap.png"
												width="72" height="16" alt="카카오맵"
												style="display: block; width: 72px; height: 16px"></a>
											<div
												style="float: right; position: relative; top: 1px; font-size: 11px;">
												<a target="_blank"
													href="https://map.kakao.com/?from=roughmap&amp;srcid=8917867&amp;confirmid=8917867&amp;q=%EB%8F%99%EB%8D%95%EC%97%AC%EC%9E%90%EB%8C%80%ED%95%99%EA%B5%90&amp;rv=on"
													style="float: left; height: 15px; padding-top: 1px; line-height: 15px; color: #000; text-decoration: none;">로드뷰</a><span
													style="width: 1px; padding: 0; margin: 0 8px 0 9px; height: 11px; vertical-align: top; position: relative; top: 2px; border-left: 1px solid #d0d0d0; float: left;"></span><a
													target="_blank"
													href="https://map.kakao.com/?from=roughmap&amp;eName=%EB%8F%99%EB%8D%95%EC%97%AC%EC%9E%90%EB%8C%80%ED%95%99%EA%B5%90&amp;eX=509230.0&amp;eY=1140949.0"
													style="float: left; height: 15px; padding-top: 1px; line-height: 15px; color: #000; text-decoration: none;">길찾기</a><span
													style="width: 1px; padding: 0; margin: 0 8px 0 9px; height: 11px; vertical-align: top; position: relative; top: 2px; border-left: 1px solid #d0d0d0; float: left;"></span><a
													target="_blank"
													href="https://map.kakao.com?map_type=TYPE_MAP&amp;from=roughmap&amp;srcid=8917867&amp;itemId=8917867&amp;q=%EB%8F%99%EB%8D%95%EC%97%AC%EC%9E%90%EB%8C%80%ED%95%99%EA%B5%90&amp;urlX=509230.0&amp;urlY=1140949.0"
													style="float: left; height: 15px; padding-top: 1px; line-height: 15px; color: #000; text-decoration: none;">지도
													크게 보기</a>
											</div>
										</div>
									</div>
								</div>
							</div></li>

						<li><a data-toggle="collapse" href="#faq3" class="collapsed">이디야
								<i class="ion-android-remove"></i>
						</a>
							<div id="faq3" class="collapse" data-parent="#faq-list">
								<p>설명</p>
								<div align="center" style="width: 100%; margin-bottom: 5%;">
									<div
										style="font: normal normal 400 12px/normal dotum, sans-serif; width: 640px; height: 282px; color: #333; position: relative">
										<div style="height: 250px;">
											<a
												href="https://map.kakao.com/?urlX=509230.0&amp;urlY=1140949.0&amp;itemId=8917867&amp;q=%EB%8F%99%EB%8D%95%EC%97%AC%EC%9E%90%EB%8C%80%ED%95%99%EA%B5%90&amp;srcid=8917867&amp;map_type=TYPE_MAP&amp;from=roughmap"
												target="_blank"><img class="map"
												src="//t1.daumcdn.net/roughmap/imgmap/73627ca9d6399387642bb90fa1f299d5a746917067884f26d27d70b2d5a1f55c"
												width="638px" height="248px" style="border: 1px solid #ccc;"></a>
										</div>
										<div
											style="overflow: hidden; padding: 7px 11px; border: 1px solid rgba(0, 0, 0, 0.1); border-radius: 0px 0px 2px 2px; background-color: rgb(249, 249, 249);">
											<a href="https://map.kakao.com" target="_blank"
												style="float: left;"><img
												src="//t1.daumcdn.net/localimg/localimages/07/2018/pc/common/logo_kakaomap.png"
												width="72" height="16" alt="카카오맵"
												style="display: block; width: 72px; height: 16px"></a>
											<div
												style="float: right; position: relative; top: 1px; font-size: 11px;">
												<a target="_blank"
													href="https://map.kakao.com/?from=roughmap&amp;srcid=8917867&amp;confirmid=8917867&amp;q=%EB%8F%99%EB%8D%95%EC%97%AC%EC%9E%90%EB%8C%80%ED%95%99%EA%B5%90&amp;rv=on"
													style="float: left; height: 15px; padding-top: 1px; line-height: 15px; color: #000; text-decoration: none;">로드뷰</a><span
													style="width: 1px; padding: 0; margin: 0 8px 0 9px; height: 11px; vertical-align: top; position: relative; top: 2px; border-left: 1px solid #d0d0d0; float: left;"></span><a
													target="_blank"
													href="https://map.kakao.com/?from=roughmap&amp;eName=%EB%8F%99%EB%8D%95%EC%97%AC%EC%9E%90%EB%8C%80%ED%95%99%EA%B5%90&amp;eX=509230.0&amp;eY=1140949.0"
													style="float: left; height: 15px; padding-top: 1px; line-height: 15px; color: #000; text-decoration: none;">길찾기</a><span
													style="width: 1px; padding: 0; margin: 0 8px 0 9px; height: 11px; vertical-align: top; position: relative; top: 2px; border-left: 1px solid #d0d0d0; float: left;"></span><a
													target="_blank"
													href="https://map.kakao.com?map_type=TYPE_MAP&amp;from=roughmap&amp;srcid=8917867&amp;itemId=8917867&amp;q=%EB%8F%99%EB%8D%95%EC%97%AC%EC%9E%90%EB%8C%80%ED%95%99%EA%B5%90&amp;urlX=509230.0&amp;urlY=1140949.0"
													style="float: left; height: 15px; padding-top: 1px; line-height: 15px; color: #000; text-decoration: none;">지도
													크게 보기</a>
											</div>
										</div>
									</div>
								</div>
							</div></li>

						<li><a data-toggle="collapse" href="#faq4" class="collapsed">탐앤탐스<i
								class="ion-android-remove"></i>
						</a>
							<div id="faq4" class="collapse" data-parent="#faq-list">
								<p>설명</p>
								<div align="center" style="width: 100%; margin-bottom: 5%;">
									<div
										style="font: normal normal 400 12px/normal dotum, sans-serif; width: 640px; height: 282px; color: #333; position: relative">
										<div style="height: 250px;">
											<a
												href="https://map.kakao.com/?urlX=509230.0&amp;urlY=1140949.0&amp;itemId=8917867&amp;q=%EB%8F%99%EB%8D%95%EC%97%AC%EC%9E%90%EB%8C%80%ED%95%99%EA%B5%90&amp;srcid=8917867&amp;map_type=TYPE_MAP&amp;from=roughmap"
												target="_blank"><img class="map"
												src="//t1.daumcdn.net/roughmap/imgmap/73627ca9d6399387642bb90fa1f299d5a746917067884f26d27d70b2d5a1f55c"
												width="638px" height="248px" style="border: 1px solid #ccc;"></a>
										</div>
										<div
											style="overflow: hidden; padding: 7px 11px; border: 1px solid rgba(0, 0, 0, 0.1); border-radius: 0px 0px 2px 2px; background-color: rgb(249, 249, 249);">
											<a href="https://map.kakao.com" target="_blank"
												style="float: left;"><img
												src="//t1.daumcdn.net/localimg/localimages/07/2018/pc/common/logo_kakaomap.png"
												width="72" height="16" alt="카카오맵"
												style="display: block; width: 72px; height: 16px"></a>
											<div
												style="float: right; position: relative; top: 1px; font-size: 11px;">
												<a target="_blank"
													href="https://map.kakao.com/?from=roughmap&amp;srcid=8917867&amp;confirmid=8917867&amp;q=%EB%8F%99%EB%8D%95%EC%97%AC%EC%9E%90%EB%8C%80%ED%95%99%EA%B5%90&amp;rv=on"
													style="float: left; height: 15px; padding-top: 1px; line-height: 15px; color: #000; text-decoration: none;">로드뷰</a><span
													style="width: 1px; padding: 0; margin: 0 8px 0 9px; height: 11px; vertical-align: top; position: relative; top: 2px; border-left: 1px solid #d0d0d0; float: left;"></span><a
													target="_blank"
													href="https://map.kakao.com/?from=roughmap&amp;eName=%EB%8F%99%EB%8D%95%EC%97%AC%EC%9E%90%EB%8C%80%ED%95%99%EA%B5%90&amp;eX=509230.0&amp;eY=1140949.0"
													style="float: left; height: 15px; padding-top: 1px; line-height: 15px; color: #000; text-decoration: none;">길찾기</a><span
													style="width: 1px; padding: 0; margin: 0 8px 0 9px; height: 11px; vertical-align: top; position: relative; top: 2px; border-left: 1px solid #d0d0d0; float: left;"></span><a
													target="_blank"
													href="https://map.kakao.com?map_type=TYPE_MAP&amp;from=roughmap&amp;srcid=8917867&amp;itemId=8917867&amp;q=%EB%8F%99%EB%8D%95%EC%97%AC%EC%9E%90%EB%8C%80%ED%95%99%EA%B5%90&amp;urlX=509230.0&amp;urlY=1140949.0"
													style="float: left; height: 15px; padding-top: 1px; line-height: 15px; color: #000; text-decoration: none;">지도
													크게 보기</a>
											</div>
										</div>
									</div>
								</div>
							</div></li>

						<li><a data-toggle="collapse" href="#faq5" class="collapsed">투썸<i
								class="ion-android-remove"></i>
						</a>
							<div id="faq5" class="collapse" data-parent="#faq-list">
								<p>설명</p>
								<div align="center" style="width: 100%; margin-bottom: 5%;">
									<div
										style="font: normal normal 400 12px/normal dotum, sans-serif; width: 640px; height: 282px; color: #333; position: relative">
										<div style="height: 250px;">
											<a
												href="https://map.kakao.com/?urlX=509230.0&amp;urlY=1140949.0&amp;itemId=8917867&amp;q=%EB%8F%99%EB%8D%95%EC%97%AC%EC%9E%90%EB%8C%80%ED%95%99%EA%B5%90&amp;srcid=8917867&amp;map_type=TYPE_MAP&amp;from=roughmap"
												target="_blank"><img class="map"
												src="//t1.daumcdn.net/roughmap/imgmap/73627ca9d6399387642bb90fa1f299d5a746917067884f26d27d70b2d5a1f55c"
												width="638px" height="248px" style="border: 1px solid #ccc;"></a>
										</div>
										<div
											style="overflow: hidden; padding: 7px 11px; border: 1px solid rgba(0, 0, 0, 0.1); border-radius: 0px 0px 2px 2px; background-color: rgb(249, 249, 249);">
											<a href="https://map.kakao.com" target="_blank"
												style="float: left;"><img
												src="//t1.daumcdn.net/localimg/localimages/07/2018/pc/common/logo_kakaomap.png"
												width="72" height="16" alt="카카오맵"
												style="display: block; width: 72px; height: 16px"></a>
											<div
												style="float: right; position: relative; top: 1px; font-size: 11px;">
												<a target="_blank"
													href="https://map.kakao.com/?from=roughmap&amp;srcid=8917867&amp;confirmid=8917867&amp;q=%EB%8F%99%EB%8D%95%EC%97%AC%EC%9E%90%EB%8C%80%ED%95%99%EA%B5%90&amp;rv=on"
													style="float: left; height: 15px; padding-top: 1px; line-height: 15px; color: #000; text-decoration: none;">로드뷰</a><span
													style="width: 1px; padding: 0; margin: 0 8px 0 9px; height: 11px; vertical-align: top; position: relative; top: 2px; border-left: 1px solid #d0d0d0; float: left;"></span><a
													target="_blank"
													href="https://map.kakao.com/?from=roughmap&amp;eName=%EB%8F%99%EB%8D%95%EC%97%AC%EC%9E%90%EB%8C%80%ED%95%99%EA%B5%90&amp;eX=509230.0&amp;eY=1140949.0"
													style="float: left; height: 15px; padding-top: 1px; line-height: 15px; color: #000; text-decoration: none;">길찾기</a><span
													style="width: 1px; padding: 0; margin: 0 8px 0 9px; height: 11px; vertical-align: top; position: relative; top: 2px; border-left: 1px solid #d0d0d0; float: left;"></span><a
													target="_blank"
													href="https://map.kakao.com?map_type=TYPE_MAP&amp;from=roughmap&amp;srcid=8917867&amp;itemId=8917867&amp;q=%EB%8F%99%EB%8D%95%EC%97%AC%EC%9E%90%EB%8C%80%ED%95%99%EA%B5%90&amp;urlX=509230.0&amp;urlY=1140949.0"
													style="float: left; height: 15px; padding-top: 1px; line-height: 15px; color: #000; text-decoration: none;">지도
													크게 보기</a>
											</div>
										</div>
									</div>
								</div>
							</div></li>

						<li><a data-toggle="collapse" href="#faq6" class="collapsed">스타벅스<i
								class="ion-android-remove"></i>
						</a>
							<div id="faq6" class="collapse" data-parent="#faq-list">
								<p>설명</p>
								<div align="center" style="width: 100%; margin-bottom: 5%;">
									<div
										style="font: normal normal 400 12px/normal dotum, sans-serif; width: 640px; height: 282px; color: #333; position: relative">
										<div style="height: 250px;">
											<a
												href="https://map.kakao.com/?urlX=509230.0&amp;urlY=1140949.0&amp;itemId=8917867&amp;q=%EB%8F%99%EB%8D%95%EC%97%AC%EC%9E%90%EB%8C%80%ED%95%99%EA%B5%90&amp;srcid=8917867&amp;map_type=TYPE_MAP&amp;from=roughmap"
												target="_blank"><img class="map"
												src="//t1.daumcdn.net/roughmap/imgmap/73627ca9d6399387642bb90fa1f299d5a746917067884f26d27d70b2d5a1f55c"
												width="638px" height="248px" style="border: 1px solid #ccc;"></a>
										</div>
										<div
											style="overflow: hidden; padding: 7px 11px; border: 1px solid rgba(0, 0, 0, 0.1); border-radius: 0px 0px 2px 2px; background-color: rgb(249, 249, 249);">
											<a href="https://map.kakao.com" target="_blank"
												style="float: left;"><img
												src="//t1.daumcdn.net/localimg/localimages/07/2018/pc/common/logo_kakaomap.png"
												width="72" height="16" alt="카카오맵"
												style="display: block; width: 72px; height: 16px"></a>
											<div
												style="float: right; position: relative; top: 1px; font-size: 11px;">
												<a target="_blank"
													href="https://map.kakao.com/?from=roughmap&amp;srcid=8917867&amp;confirmid=8917867&amp;q=%EB%8F%99%EB%8D%95%EC%97%AC%EC%9E%90%EB%8C%80%ED%95%99%EA%B5%90&amp;rv=on"
													style="float: left; height: 15px; padding-top: 1px; line-height: 15px; color: #000; text-decoration: none;">로드뷰</a><span
													style="width: 1px; padding: 0; margin: 0 8px 0 9px; height: 11px; vertical-align: top; position: relative; top: 2px; border-left: 1px solid #d0d0d0; float: left;"></span><a
													target="_blank"
													href="https://map.kakao.com/?from=roughmap&amp;eName=%EB%8F%99%EB%8D%95%EC%97%AC%EC%9E%90%EB%8C%80%ED%95%99%EA%B5%90&amp;eX=509230.0&amp;eY=1140949.0"
													style="float: left; height: 15px; padding-top: 1px; line-height: 15px; color: #000; text-decoration: none;">길찾기</a><span
													style="width: 1px; padding: 0; margin: 0 8px 0 9px; height: 11px; vertical-align: top; position: relative; top: 2px; border-left: 1px solid #d0d0d0; float: left;"></span><a
													target="_blank"
													href="https://map.kakao.com?map_type=TYPE_MAP&amp;from=roughmap&amp;srcid=8917867&amp;itemId=8917867&amp;q=%EB%8F%99%EB%8D%95%EC%97%AC%EC%9E%90%EB%8C%80%ED%95%99%EA%B5%90&amp;urlX=509230.0&amp;urlY=1140949.0"
													style="float: left; height: 15px; padding-top: 1px; line-height: 15px; color: #000; text-decoration: none;">지도
													크게 보기</a>
											</div>
										</div>
									</div>
								</div>
							</div></li>
					</ul>
				</div>
				<div>
					<button type="submit" title="Send Message" id="more">더보기</button>
				</div>
			</div>
			<!-- End F.A.Q Section -->
		</section>
		<!-- End Services Section -->

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