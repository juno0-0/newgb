<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<!--
	Wide Angle by Pixelarity
	pixelarity.com | hello@pixelarity.com
	License: pixelarity.com/license
-->
<html>
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<head>
		<title>Untitled</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		<link rel="stylesheet" href="assets/css/main.css" />
	</head>
	<style>
		.swal-text{
			font-size: 30px;
			font-family: 'Open Sans Condensed';
		}
		
		.swal-button{
			font-family: 'Open Sans Condensed';
			font-size: 25px;
			padding: 0 30px;
		}
	</style>
	<body class="is-preload">

		<!-- Header -->
			<header id="header">
				<nav>
					<ul class="nav">
						<li><a href="index.html">Home</a></li>
						<li><a href="join.html">Join</a></li>
					</ul>
				</nav>
				<div id="logo">
					<a href="index.html">
						Bang<br />
						<strong>Junho</strong>
					</a>
				</div>
				<nav>
					<ul class="nav">
						<li><a href="login.html">Login</a></li>
						<li><a href="elements.html">Elements</a></li>
					</ul>
				</nav>
			</header>

		<!-- Main -->
			<div id="main" class="wrapper">
				<div class="inner">

				<!-- Elements -->
					<h1 class="major">비밀번호 변경</h1>
					<!-- Text -->
					<div class="row">
						<div class="col-6 col-12-small" style="margin: 0 auto; width: 60%;">
							<form action="login.html">
								<label style="float: left;">새로운 비밀번호<span style="color: magenta">*</span></label>
								<input type="password" name="pw" id="pw" value="" required>
								<label style="float: right;">사용할 수 있는 비밀번호입니다. or 사용할 수 없는 비밀번호입니다.</label>
								<br>
								<label style="float: left;">비밀번호 확인<span style="color: magenta">*</span></label>
								<input type="password" name="checkPw" id="checkPw" value="" required>
								<label style="float: right;">비밀번호가 일치합니다. or 비밀번호가 일치하지 않습니다.</label>
								<br>
								<div class="col-12" style="clear: both;">
									<ul class="actions">
										<li style="margin: auto;">
											<input type="submit" value="로그인" class="primary"/>
										</li>
									</ul>
								</div>
							</form>		
						</div>
					</div>
				</div>
			</div>

		<!-- Footer -->
			<section id="footer">
				<div class="inner">
					<header>
						<h2>Get in Touch</h2>
						<p>아이콘 클릭 시 해당 페이지로 이동합니다.</p>
					</header>
					<ul class="icons">
						<li><a href="https://twitter.com/" class="icon brands fa-twitter"><span class="label">Twitter</span></a></li>
						<li><a href="https://www.instagram.com/" class="icon brands fa-instagram"><span class="label">Instagram</span></a></li>
						<li><a href="https://www.facebook.com/" class="icon brands fa-facebook-f"><span class="label">Facebook</span></a></li>
						<li><a href="https://www.apple.com/" class="icon brands fa-apple"><span class="label">apple</span></a></li>
						<li><a href="https://mail.google.com/" class="icon solid fa-envelope"><span class="label">Email</span></a></li>
					</ul>
					<div class="copyright">
						&copy; Untitled. All rights reserved.
					</div>
				</div>
			</section>

		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/browser.min.js"></script>
			<script src="assets/js/breakpoints.min.js"></script>
			<script src="assets/js/jquery.dropotron.min.js"></script>
			<script src="assets/js/util.js"></script>
			<script src="assets/js/main.js"></script>

	</body>
</html>