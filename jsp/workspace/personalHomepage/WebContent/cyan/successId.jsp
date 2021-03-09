<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<!--
	Wide Angle by Pixelarity
	pixelarity.com | hello@pixelarity.com
	License: pixelarity.com/license
-->
<html>
	<head>
		<title>Untitled</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/cyan/assets/css/main.css" />
	</head>
	<body class="is-preload">

		<c:if test="${param.check == 'true'}">
			<script>
			var list = "${param.list}";
			alert(list);</script>
		</c:if>

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
					<h1 class="major">아이디 찾기 성공</h1>
					<!-- Text -->
					<div class="row">
						<div class="col-6 col-12-small" style="margin: 0 auto; text-align: center;">
							<form action="login.jsp">
								<h4>입력하신 정보로 가입되어 있는 아이디</h4>
								<c:forEach items="${param.list}" var="list" >
									<c:out value="${list}" />
								</c:forEach>
								<!-- <ul style="list-style: none;">
									<li></li>
									<li></li>
									<li></li>
								</ul> -->
								<input type="submit" value="로그인" class="primary" style="padding: 0 1rem; width:40%;"/>
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
			<script src="${pageContext.request.contextPath}/cyan/assets/js/jquery.min.js"></script>
			<script src="${pageContext.request.contextPath}/cyan/assets/js/browser.min.js"></script>
			<script src="${pageContext.request.contextPath}/cyan/assets/js/breakpoints.min.js"></script>
			<script src="${pageContext.request.contextPath}/cyan/assets/js/jquery.dropotron.min.js"></script>
			<script src="${pageContext.request.contextPath}/cyan/assets/js/util.js"></script>
			<script src="${pageContext.request.contextPath}/cyan/assets/js/main.js"></script>

	</body>
</html>