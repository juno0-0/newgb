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
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<head>
		<title>Untitled</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/cyan/assets/css/main.css" />
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
					<h1 class="major">비밀번호 변경</h1>
					<!-- Text -->
					<div class="row">
						<div class="col-6 col-12-small" style="margin: 0 auto; width: 60%;">
							<form action="${pageContext.request.contextPath}/mypage/MyPageChangePw.mp" name="changePwForm">
								<c:if test="${not empty param.mypageId}">
									<input type="hidden" id="mypageId" name="mypageId" value="${param.mypageId}">
								</c:if>
								<label style="float: left;">새로운 비밀번호<span style="color: magenta">*</span></label>
								<input type="password" name="newMypagePw" id="newMypagePw" value="" required>
								<p id="newMypagePw_msg" style="float: right;"></p>
								<br>
								<label style="float: left;">비밀번호 확인<span style="color: magenta">*</span></label>
								<input type="password" name="checkPw" id="checkPw" value="" required>
								<p id="checkPw_msg" style="float: right;"></p>
								<br>
								<div class="col-12" style="clear: both;">
									<ul class="actions">
										<li style="margin: auto;">
											<input type="button" value="변경하기" class="primary" onclick="changePwCheck()"/>
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
			<script src="${pageContext.request.contextPath}/cyan/assets/js/jquery.min.js"></script>
			<script src="${pageContext.request.contextPath}/cyan/assets/js/browser.min.js"></script>
			<script src="${pageContext.request.contextPath}/cyan/assets/js/breakpoints.min.js"></script>
			<script src="${pageContext.request.contextPath}/cyan/assets/js/jquery.dropotron.min.js"></script>
			<script src="${pageContext.request.contextPath}/cyan/assets/js/util.js"></script>
			<script src="${pageContext.request.contextPath}/cyan/assets/js/main.js"></script>
			<script src="${pageContext.request.contextPath}/cyan/assets/js/changePw.js"></script>

	</body>
<script src="//code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>
<script>var contextPath = "${pageContext.request.contextPath}";</script>
</html>