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
	
		<c:if test="${!empty param.check}">
			<c:if test="${param.check == 'false'}">
				<script>alert("등록된 ID가 없습니다.");</script>
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
					<h1 class="major">아이디 찾기</h1>
					<!-- <span class="image fit"><img src="images/pic01.jpg" alt="" /></span> -->
					<div class="row">
						<div style="margin: 0 auto; width: 60%;">
							<hr width="70%" style="margin: 0 auto;">
							<br>
							<form action="${pageContext.request.contextPath}/mypage/MyPageFindId.mp" name="findIdForm">
								<div style="width: 70%; margin: 0 auto;">
									<label>핸드폰 번호</label>
									<input type="text" name="mypagePhone" id="mypagePhone" value="010" style="width: 65%; float: left">
									<input type="button" value="인증번호" class="primary" style="width: 35%; text-align: center; padding: 0 1rem;" onclick="sms()"/>
								</div>
								<div style="width: 70%; margin: 0 auto;">
									<label style="margin-top: 20px;">인증번호</label>
									<input type="text" name="checkPhone" id="checkPhone" value="" style="width: 65%; float: left;" readonly>							
									<input type="button" id="certified" value="인증하기" class="primary" style="width: 35%; text-align: center; padding: 0 1rem;" disabled="disabled" onclick="certifiedCheck()"/>
								</div>
								<br>
								<div style="margin: 0 auto; width: 70%">
									<ul class="actions">
										<li style="margin: 0 auto;">
											<input type="button" value="아이디 찾기" class="primary" style="padding: 0 1rem; margin-right: 20px;" onclick="formSubmit()"/>
											<a href="login.jsp">
												<input type="button" value="돌아가기" style="margin-top: 20px;">
											</a>
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
			<script src="${pageContext.request.contextPath}/cyan/assets/js/findId.js"></script>

	</body>
<script src="//code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>
<script>var contextPath = "${pageContext.request.contextPath}";</script>
</html>