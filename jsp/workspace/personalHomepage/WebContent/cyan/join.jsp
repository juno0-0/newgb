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
	<!-- alert() 변경 -->
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<head>
		<title>Join</title>
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		<link rel="stylesheet" href="assets/css/main.css" />
		<style> 
			a { text-decoration:none } 
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
	</head>
	
	
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
					<h1 class="major">회원가입</h1>			
					<!-- Form -->
					<form method="post" action="${pageContext.request.contextPath}/mypage/MyPageJoin.mp" style="width:60%; margin: auto;" name="joinForm">
						<div class="col-6 col-12-xsmall" style="margin: auto;">
							<label>아이디<span style="color: magenta">*</span></label>
							<input type="text" name="mypageId" id="mypageId" required style="float:left; width: 70%;">
							<input type="button" class="primary" value="중복확인" style="float: left; width: 30%; padding: 0 1rem;" onclick="checkId()">
							<p id="checkId_msg" style="float:right;"></p>
							<br>
							<label style="margin-top: 50px;">비밀번호<span style="color: magenta">*</span></label>
							<input type="password" name="mypagePw" id="mypagePw" required>
							<!-- 8자 이상 16자 미만 -->
							<p id="checkPw_msg" style="float: right;"></p>
							<br>
							<label>비밀번호 확인<span style="color: magenta">*</span></label>
							<input type="password" name="checkPw" id="checkPw" value="" required>
							<!-- keyup으로 mypagePw랑 checkPw랑 비교? -->
							<p id="equalPw_msg" style="float: right;"></p>
							<br>
							<label>성함<span style="color: magenta">*</span></label>
							<input type="text" name="mypageName" id="mypageName" required>
							<br>
							<label>핸드폰 번호<span style="color: magenta">*</span></label>
							<input type="text" name="mypagePhone" id="mypagePhone" value="010" required style="float:left; width: 70%;">
							<input type="button" class="primary" value="인증번호" style="float: left; width: 30%; padding: 0 1rem;" onclick="sms()">
							<input type="text" name="checkPhone" id="checkPhone" required readonly style="float:left; width: 70%; margin: 30px auto; ">
							<input id="certified" type="button" class="primary" value="인증하기" disabled="disabled" style="float: left; width: 30%; padding: 0 1rem; margin: 30px auto;" onclick="certifiedCheck()">
							<br>
							<label style="margin-top: 50px;">이메일</label>
							<input type="text" name="mypageEmail" id="mypageEmail" value="" style="float:left; width:70%;">
							<div class="col-12" style="float:left; width:30%;">
								<select name="category" id="category">
									<option value="">직접 입력</option>
									<option value="@gmail.com">@gmail.com</option>
									<option value="@naver.com">@naver.com</option>
									<option value="@hanmail.net">@hanmail.net</option>
									<option value="@nate.com">@nate.com</option>
									<option value="@hanmir.com">@hanmir.com</option>
									<option value="@dreamwiz.com">@dreamwiz.com</option>
									<option value="@lycos.co.kr">@lycos.co.kr</option>
								</select>
							<br>
							</div>
							<label>주소</label>
							<input type="text" name="mypageAddress" id="mypageAddress" placeholder="OO시 OO구 OO동">
						</div>
						<hr>
						<div class="col-12">
							<input type="checkbox" id="checkbox-alpha" name="checkbox" checked>
							<label for="checkbox-alpha"><span style="color: magenta">[필수]</span>&nbsp;약관에 동의합니다.</label>
							<!-- 일단은 바로 jsp로 이동하기 -->
							<a href="info.jsp" target=”_blank”>이용약관 보러가기🙄</a>
						</div>
						<br>
						<div class="col-12">
							<ul class="actions">
								<li style="margin: auto;">
									<input type="button" value="회원가입" class="primary" style="margin-right: 30px;" onclick="formSubmit()"/>
									<input type="reset" value="초기화" style="margin-top: 10px;"/>
								</li>
							</ul>
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
			<script src="assets/js/join.js"></script>

	</body>
<script src="//code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>
<script>var contextPath = "${pageContext.request.contextPath}";</script>
</html>