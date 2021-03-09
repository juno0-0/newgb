<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--
	Wide Angle by Pixelarity
	pixelarity.com | hello@pixelarity.com
	License: pixelarity.com/license
-->
<html>
	<head>
		<title>Login</title>
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		<link rel="stylesheet" href="assets/css/main.css" />
		<style>
			#nonIns{text-decoration:none;}
		</style>
	</head>
	<body class="is-preload">
		<c:if test="${!empty param.check}">
			<c:if test="${param.check == 'false'}">
				<script>alert("ID/PW를 다시 확인해주세요.");</script>
			</c:if>
		</c:if>
		<!-- Header -->
			<header id="header">
				<nav>
					<ul class="nav">
						<li><a href="index.jsp">Home</a></li>
						<li><a href="join.jsp">Join</a></li>
					</ul>
				</nav>
				<div id="logo">
					<a href="index.jsp">
						Bang<br />
						<strong>Junho</strong>
					</a>
				</div>
				<nav>
					<ul class="nav">
						<li><a href="login.jsp">Login</a></li>
						<li><a href="elements.html">Elements</a></li>
					</ul>
				</nav>
			</header>

		<!-- Main -->
			<div id="main" class="wrapper">
				<div class="inner">
					<!-- Elements -->
					<h1 class="major">로그인</h1>			

			
		<!-- Form -->
					<form method="post" action="${pageContext.request.contextPath}/mypage/MyPageLogin.mp" style="width: 60%; margin: 0 auto;" name=loginForm>
						<div class="row gtr-uniform">
							<div class="col-12">
								<label>아이디</label>
								<input type="text" name="mypageId" id="mypageId" required>
								<br>
								<label>비밀번호</label>
								<input type="password" name="mypagePw" id="mypagePw" required>
								<a href="findId.jsp" style="font-size: 0.7rem;">아이디 찾기</a>&nbsp;&nbsp;&nbsp;
								<a href="findPw.jsp" style="font-size: 0.7rem;">비밀번호 찾기</a>
							</div>
						<br>
						</div>
						<ul class="actions">
							<li style="margin: 30px auto;">
								<input type="button" value="Login" class="primary" onclick="login()"/>
							</li>
						</ul>
						<div style="text-align: center;">
							<a id="nonIns" href="join.jsp">회원가입 하러가기🌏</a>
						</div>
					</form>
				</div>
			</div>
			

		<!-- Footer -->
			<section id="footer">
				<div class="inner">
					<header>
						<h2 class="special">Get in Touch</h2>
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
			<script src="assets/js/login.js"></script>

	</body>
</html>