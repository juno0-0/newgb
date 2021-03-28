<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<!--
	Phantom by Pixelarity
	pixelarity.com | hello@pixelarity.com
	License: pixelarity.com/license
-->
<html>
	<head>
		<title>회원 회원가입</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="assets/css/main.css" />
		<noscript><link rel="stylesheet" href="assets/css/noscript.css" /></noscript>
	</head>
	<body class="is-preload">
		<!-- Wrapper -->
			<div id="wrapper">

				<!-- Header -->
					<header id="header">
						<div class="inner">

							<!-- Logo -->
								<div style="text-align: center">
								<a href="index.html" class="logo" style="height: 100px;">
									<span class="symbol"><img src="images/logo.png" alt="" style="height:100px; width: 100px"/></span><span class="title" style="font-size: 30px;">득근득근</span>
								</a>
								</div>
							<!-- Nav -->
								<nav>
									<ul>
										<li><a href="#menu">Menu</a></li>
									</ul>
								</nav>

						</div>
					</header>

				<!-- Menu -->
					<nav id="menu">
						<h2>Menu</h2>
						<ul>
							<li><a href="index.html">Home</a></li>
							<li><a href="generic.html">Ipsum veroeros</a></li>
							<li><a href="generic.html">Tempus etiam</a></li>
							<li><a href="generic.html">Consequat dolor</a></li>
							<li><a href="elements.html">Elements</a></li>
						</ul>
					</nav>

				<!-- Main -->
					<div id="main">
						<form action="">
						<div class="inner"  style="width: 40%; margin-left: 30%;">
							<div style="text-align: center">
								<h2>회원용 회원가입</h2>	
							</div>
							<div>
								<h3>아이디</h3>
								<input type="text" name="memberId" id="memberId" value="" required/>
								 <p id="idCheck_text"></p>
							</div>
							<br>
							<div>
								<h3>비밀번호</h3>
								<input type="password" name="memberPw" id="memberPw" value=""  required/>
							</div>
							<br>
							<div>
								<h3>이름</h3>
								<input type="text" name="memberName" id="memberName" value=""/>
							</div>
							<br>
							<div>
								<h3>휴대폰번호</h3>
								<input type="text" name="memberPhonenumber" id="memberPhonenumber" value=""  style="float: left; width: 65%;"/>
							</div>
							<div>
							<ul class="actions">
							<li><a href="#" class="button" style="width: 100%">인증번호 보내기</a></li>
							</ul>
								<input type="text" name="memberPhonenumberOk" id="memberPhonenumberOk" placeholder="인증번호 입력하세요" value="" disabled  />
							</div>
							
							<br>
								<h3>성별</h3>
								<select name="memberGender" id="memberGender">
									<option value="">- 성별 -</option>
									<option value="남자">남자</option>
									<option value="여자">여자</option>
									<option value="선택안함">선택안함</option>
								</select>
							<br>
							<div>
								<h3>이메일</h3>
								<input type="text" name="memberEmail" id="memberEmail" value=""  />
							</div>
							<br>
							<div>
								<h3>우편번호</h3>
								<input type="text" name="memberZipcode" id="memberZipcode" class="postcodify_postcode5" value="" style="float: left; width: 75%" readonly/>
								<ul class="actions">
								<li><a href="#"id="postcodify_search_button" class="button"  style="width: 100%">검색</a></li>
								</ul>
<!--                   			<input type="button" id="postcodify_search_button" value="검색" style="width: 20%"><br /> -->
							</div>
							<br>
							<div>
								<h3>주소</h3>
								<input type="text" name="memberAddress" id="memberAddress"  value="" class="postcodify_address" value="" readonly />
							</div>
							<br>
							<div>
								<h3>상세주소</h3>
								<input type="text" name="memberAddressDetail" id="memberAddressDetail" class="postcodify_details" value="" value=""/>
							</div>
							<br>
						<div>
						<ul class="actions">
						<li style="margin-left: 25%"><a href="index.jsp" class="button primary">취소</a></li>
						<li><a href="#" class="button">회원가입</a></li>
						</ul>
						</div>
						</div>
					
						</form>
					</div>

				<!-- Footer -->
					<footer id="footer">
						<div class="inner">
							<section>
								<h2>Get in touch</h2>
								<form method="post" action="#">
									<div class="fields">
										<div class="field half">
											<input type="text" name="name" id="name" placeholder="Name" />
										</div>
										<div class="field half">
											<input type="email" name="email" id="email" placeholder="Email" />
										</div>
										<div class="field">
											<textarea name="message" id="message" placeholder="Message"></textarea>
										</div>
									</div>
									<ul class="actions">
										<li><input type="submit" value="Send" class="primary" /></li>
									</ul>
								</form>
							</section>
							<section>
								<h2>Follow</h2>
								<ul class="icons">
									<li><a href="#" class="icon brands style2 fa-twitter"><span class="label">Twitter</span></a></li>
									<li><a href="#" class="icon brands style2 fa-facebook-f"><span class="label">Facebook</span></a></li>
									<li><a href="#" class="icon brands style2 fa-instagram"><span class="label">Instagram</span></a></li>
									<li><a href="#" class="icon brands style2 fa-dribbble"><span class="label">Dribbble</span></a></li>
									<li><a href="#" class="icon brands style2 fa-github"><span class="label">GitHub</span></a></li>
									<li><a href="#" class="icon brands style2 fa-500px"><span class="label">500px</span></a></li>
									<li><a href="#" class="icon solid style2 fa-phone"><span class="label">Phone</span></a></li>
									<li><a href="#" class="icon solid style2 fa-envelope"><span class="label">Email</span></a></li>
								</ul>
							</section>
							<ul class="copyright">
								<li>&copy; Untitled. All rights reserved</li>
							</ul>
						</div>
					</footer>

			</div>

		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/browser.min.js"></script>
			<script src="assets/js/breakpoints.min.js"></script>
			<script src="assets/js/util.js"></script>
			<script src="assets/js/main.js"></script>
			

	</body>
	<script src="//code.jquery.com/jquery-3.5.1.min.js"></script>
	<script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>
	<script> $(function() { $("#postcodify_search_button").postcodifyPopUp(); }); </script>
	
</html>