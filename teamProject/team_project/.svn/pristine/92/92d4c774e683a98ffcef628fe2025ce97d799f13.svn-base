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
		<link rel="preconnect" href="https://fonts.gstatic.com">
		<link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Noto+Sans+KR&display=swap" rel="stylesheet">
		<style>
			input[type="checkbox"] + label:before, input[type="radio"] + label:before{
				top: 15px;
				left: 15px; 
			}
		</style>
	</head>
	<body class="is-preload">
		<!-- Wrapper -->
			<div id="wrapper">

				<!-- Header -->
					<header id="header">
						<div class="inner">

							<!-- Logo -->
								<a href="index.html" class="logo"> <!--css로고 사이즈 바꿧는데 적용이안됨  -->
									<span class="symbol"><img src="images/logo.png" alt="" /></span><span class="title" style="font-size:40px;">득근득근</span>
								</a>

							<!-- Nav -->
								<nav>
									<ul>
										<li><input type='button' id="modal_btn" class="button primary" value="로그인"></li>
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
							<%-- 회원 성별 선택 --%>
							<div class="inner" id="memberGender" style="width: 50%; margin: 0 auto;">
							<!-- 
								if($("#manCheck").is(":checked") == true){남자 체크한 상태}
								else{여자 체크한 상태}
							-->
								<table style="font-family: 'Noto Sans KR', sans-serif;">
									<caption style="float: left; font-size: 20px;">회원님의 <span style="color: red;">성별</span>은 무엇인가요 ?</caption>
									<tr style="background-color: white; border-left: 1px solid #c9c9c9; border-right: 1px solid #c9c9c9;">
										<td style="padding: 0;">
											<input type="checkbox" id="mManCheck" name="memberGenderCheck" value="남" onclick="noMultiMGender(this)">
											<label for="mManCheck" style="width: 100%; height: 100%; margin: 0; padding: 15px 15px 15px 60px">남자</label>
										</td>
									</tr>
									<tr style="background-color: white; border-left: 1px solid #c9c9c9; border-right: 1px solid #c9c9c9;">										
										<td style="padding: 0;">
											<input type="checkbox" id="mWomanCheck" name="memberGenderCheck" value="여" onclick="noMultiMGender(this)">
											<label for="mWomanCheck" style="width: 100%; height: 100%; margin: 0; padding: 15px 15px 15px 60px">여자</label>
										</td>
									</tr>
								</table>
								<div>
									<ul class="actions">
										<li style="margin: 0 auto;"><a href="javascript:memberMoveTrainer()" class="button">다음 단계</a></li>
									</ul>
								</div>
							</div>
							<%-- 트레이너 성별 선택 --%>
							<div class="inner" id="trainerGender" style="width: 50%; margin: 0 auto; display: none;">
								<table style="font-family: 'Noto Sans KR', sans-serif;">
									<caption style="float: left; font-size: 20px;">선호하는 트레이너의 <span style="color: red;">성별</span>은 무엇인가요 ?</caption>
									<tr style="background-color: white; border-left: 1px solid #c9c9c9; border-right: 1px solid #c9c9c9;">
										<td style="padding: 0;">
											<input type="checkbox" id="tManCheck" name="trainerGenderCheck" value="남" onclick="noMultiTGender(this)">
											<label for="tManCheck" style="width: 100%; height: 100%; margin: 0; padding: 15px 15px 15px 60px">남자</label>
										</td>
									</tr>
									<tr style="background-color: white; border-left: 1px solid #c9c9c9; border-right: 1px solid #c9c9c9;">										
										<td style="padding: 0;">
											<input type="checkbox" id="tWomanCheck" name="trainerGenderCheck" value="여" onclick="noMultiTGender(this)">
											<label for="tWomanCheck" style="width: 100%; height: 100%; margin: 0; padding: 15px 15px 15px 60px">여자</label>
										</td>
									</tr>
								</table>
								<div>
									<ul class="actions">
										<li style="margin-left: auto;"><a href="javascript:trainerMoveMember()" class="button">이전 단계</a></li>
										<li style="margin-right: auto;"><a href="javascript:trainerMoveAge()" class="button">다음 단계</a></li>
									</ul>
								</div>
							</div>
							<%-- 연령 선택 --%>
							<div class="inner" id="memberAge" style="width: 50%; margin: 0 auto; display: none;">
								<table style="font-family: 'Noto Sans KR', sans-serif;">
									<caption style="float: left; font-size: 20px;">회원님의 <span style="color: red;">연령</span>은 어떻게 되나요 ?</caption>
									<tr style="background-color: white; border-left: 1px solid #c9c9c9; border-right: 1px solid #c9c9c9;">
										<td style="padding: 0;">
											<input type="checkbox" id="underTeen" name="ageCheck" value="10대미만" onclick="noMultiAge(this)">
											<label for="underTeen" style="width: 100%; height: 100%; margin: 0; padding: 15px 15px 15px 60px">10대 미만</label>
										</td>
									</tr>
									<tr style="background-color: white; border-left: 1px solid #c9c9c9; border-right: 1px solid #c9c9c9;">										
										<td style="padding: 0;">
											<input type="checkbox" id="teenager" name="ageCheck" value="10대" onclick="noMultiAge(this)">
											<label for="teenager" style="width: 100%; height: 100%; margin: 0; padding: 15px 15px 15px 60px">10대</label>
										</td>
									</tr>
									<tr style="background-color: white; border-left: 1px solid #c9c9c9; border-right: 1px solid #c9c9c9;">										
										<td style="padding: 0;">
											<input type="checkbox" id="twenties" name="ageCheck" value="20대" onclick="noMultiAge(this)">
											<label for="twenties" style="width: 100%; height: 100%; margin: 0; padding: 15px 15px 15px 60px">20대</label>
										</td>
									</tr>
									<tr style="background-color: white; border-left: 1px solid #c9c9c9; border-right: 1px solid #c9c9c9;">										
										<td style="padding: 0;">
											<input type="checkbox" id="thirties" name="ageCheck" value="30대" onclick="noMultiAge(this)">
											<label for="thirties" style="width: 100%; height: 100%; margin: 0; padding: 15px 15px 15px 60px">30대</label>
										</td>
									</tr>
									<tr style="background-color: white; border-left: 1px solid #c9c9c9; border-right: 1px solid #c9c9c9;">										
										<td style="padding: 0;">
											<input type="checkbox" id="forties" name="ageCheck" value="40대" onclick="noMultiAge(this)">
											<label for="forties" style="width: 100%; height: 100%; margin: 0; padding: 15px 15px 15px 60px">40대</label>
										</td>
									</tr>
									<tr style="background-color: white; border-left: 1px solid #c9c9c9; border-right: 1px solid #c9c9c9;">										
										<td style="padding: 0;">
											<input type="checkbox" id="fifties" name="ageCheck" value="50대이상" onclick="noMultiAge(this)">
											<label for="fifties" style="width: 100%; height: 100%; margin: 0; padding: 15px 15px 15px 60px">50대 이상</label>
										</td>
									</tr>
								</table>
								<div>
									<ul class="actions">
										<li style="margin-left: auto;"><a href="javascript:ageMoveTrainer()" class="button">이전 단계</a></li>
										<li style="margin-right: auto;"><a href="javascript:ageMoveArea()" class="button">다음 단계</a></li>
									</ul>
								</div>
							</div>
							<%-- 지역 선택 --%>
							<div class="inner" id="memberArea" style="width: 50%; margin: 0 auto; display: none;">
								<table style="font-family: 'Noto Sans KR', sans-serif;">
									<caption style="float: left; font-size: 20px;"><span style="color: red;">지역</span>을 선택해주세요.</caption>
									<tr style="background-color: white; border-left: 1px solid #c9c9c9; border-right: 1px solid #c9c9c9;">
										<td style="padding: 0; padding-left: 30px;">
											<select id="sido" style="border: 0;">
												<option value="" selected disabled hidden="">시/도</option>
											</select>
										</td>
									</tr>
									<tr style="background-color: white; border-left: 1px solid #c9c9c9; border-right: 1px solid #c9c9c9;">
										<td style="padding: 0; padding-left: 30px;">
											<select id="sigugun" style="border: 0;">
												<option value="" selected disabled hidden>시/군/구</option>
											</select>
										</td>
									</tr>
									<tr style="background-color: white; border-left: 1px solid #c9c9c9; border-right: 1px solid #c9c9c9;">
										<td style="padding: 0; padding-left: 30px;">
											<select id="dong" style="border: 0;">
												<option value="" selected disabled hidden>읍/면/동</option>
											</select>
										</td>
									</tr>
								</table>
								<div>
									<ul class="actions">
										<li style="margin-left: auto;"><a href="javascript:areaMoveAge()" class="button">이전 단계</a></li>
										<li style="margin-right: auto;"><a href="javascript:areaMoveAttention()" class="button">다음 단계</a></li>
									</ul>
								</div>
							</div>
							<%-- 관심 분야 선택 --%>
							<div class="inner" id="memberAttention" style="width: 50%; margin: 0 auto; display: none;">
								<table style="font-family: 'Noto Sans KR', sans-serif;">
									<caption style="float: left; font-size: 20px;"><span style="color: red;">관심 분야</span>는 무엇인가요 ?</caption>
									<tr style="background-color: white; border-left: 1px solid #c9c9c9; border-right: 1px solid #c9c9c9;">
										<td style="padding: 0;">
											<input type="checkbox" id="diet" name="attentionCheck" value="다이어트" onclick="noMultiAttention(this)">
											<label for="diet" style="width: 100%; height: 100%; margin: 0; padding: 15px 15px 15px 60px">다이어트</label>
										</td>
									</tr>
									<tr style="background-color: white; border-left: 1px solid #c9c9c9; border-right: 1px solid #c9c9c9;">										
										<td style="padding: 0;">
											<input type="checkbox" id="strength" name="attentionCheck" value="근력강화" onclick="noMultiAttention(this)">
											<label for="strength" style="width: 100%; height: 100%; margin: 0; padding: 15px 15px 15px 60px">근력 강화</label>
										</td>
									</tr>
									<tr style="background-color: white; border-left: 1px solid #c9c9c9; border-right: 1px solid #c9c9c9;">										
										<td style="padding: 0;">
											<input type="checkbox" id="gainWeight" name="attentionCheck" value="체중증가" onclick="noMultiAttention(this)">
											<label for="gainWeight" style="width: 100%; height: 100%; margin: 0; padding: 15px 15px 15px 60px">체중 증가</label>
										</td>
									</tr>
									<tr style="background-color: white; border-left: 1px solid #c9c9c9; border-right: 1px solid #c9c9c9;">										
										<td style="padding: 0;">
											<input type="checkbox" id="endurance" name="attentionCheck" value="체력증진" onclick="noMultiAttention(this)">
											<label for="endurance" style="width: 100%; height: 100%; margin: 0; padding: 15px 15px 15px 60px">체력 증진</label>
										</td>
									</tr>
									<tr style="background-color: white; border-left: 1px solid #c9c9c9; border-right: 1px solid #c9c9c9;">										
										<td style="padding: 0;">
											<input type="checkbox" id="bodyType" name="attentionCheck" value="체형교정" onclick="noMultiAttention(this)">
											<label for="bodyType" style="width: 100%; height: 100%; margin: 0; padding: 15px 15px 15px 60px">체형 교정</label>
										</td>
									</tr>
									<tr style="background-color: white; border-left: 1px solid #c9c9c9; border-right: 1px solid #c9c9c9;">										
										<td style="padding: 0;">
											<input type="checkbox" id="care" name="attentionCheck" value="재활통증케어" onclick="noMultiAttention(this)">
											<label for="care" style="width: 100%; height: 100%; margin: 0; padding: 15px 15px 15px 60px">재활/통증 케어</label>
										</td>
									</tr>
									<tr style="background-color: white; border-left: 1px solid #c9c9c9; border-right: 1px solid #c9c9c9;">										
										<td style="padding: 0;">
											<input type="checkbox" id="bodyProfile" name="attentionCheck" value="바디프로필" onclick="noMultiAttention(this)">
											<label for="bodyProfile" style="width: 100%; height: 100%; margin: 0; padding: 15px 15px 15px 60px">바디프로필</label>
										</td>
									</tr>
									<tr style="background-color: white; border-left: 1px solid #c9c9c9; border-right: 1px solid #c9c9c9;">										
										<td style="padding: 0;">
											<input type="checkbox" id="contest" name="attentionCheck" value="대회준비" onclick="noMultiAttention(this)">
											<label for="contest" style="width: 100%; height: 100%; margin: 0; padding: 15px 15px 15px 60px">대회 준비</label>
										</td>
									</tr>
									<tr style="background-color: white; border-left: 1px solid #c9c9c9; border-right: 1px solid #c9c9c9;">										
										<td style="padding: 0;">
											<input type="checkbox" id="etc" name="attentionCheck" value="기타" onclick="noMultiAttention(this)">
											<label for="etc" style="width: 100%; height: 100%; margin: 0; padding: 15px 15px 15px 60px">기타</label>
										</td>
									</tr>
								</table>
								<div>
									<ul class="actions">
										<li style="margin-left: auto;"><a href="javascript:attentionMoveArea()" class="button">이전 단계</a></li>
										<li style="margin-right: auto;"><a href="javascript:attentionMoveDate()" class="button">다음 단계</a></li>
									</ul>
								</div>
							</div>
							<%-- 레슨 날짜 --%>
							<div class="inner" id="classDate" style="width: 50%; margin: 0 auto; display: none;">
								<table style="font-family: 'Noto Sans KR', sans-serif;">
									<caption style="float: left; font-size: 20px;"><span style="color: red;">레슨 가능한 날짜</span>를 모두 선택해주세요.</caption>
									<tr style="background-color: white; border-left: 1px solid #c9c9c9; border-right: 1px solid #c9c9c9;">
										<td style="padding: 0;">
											<input type="checkbox" id="counseling" name="dateCheck" value="상담후결정">
											<label for="counseling" style="width: 100%; height: 100%; margin: 0; padding: 15px 15px 15px 60px">상담 후 결정</label>
										</td>
									</tr>
									<tr style="background-color: white; border-left: 1px solid #c9c9c9; border-right: 1px solid #c9c9c9;">										
										<td style="padding: 0;">
											<input type="checkbox" id="monday" name="dateCheck" value="월">
											<label for="monday" style="width: 100%; height: 100%; margin: 0; padding: 15px 15px 15px 60px">월요일</label>
										</td>
									</tr>
									<tr style="background-color: white; border-left: 1px solid #c9c9c9; border-right: 1px solid #c9c9c9;">										
										<td style="padding: 0;">
											<input type="checkbox" id="tuesday" name="dateCheck" value="화">
											<label for="tuesday" style="width: 100%; height: 100%; margin: 0; padding: 15px 15px 15px 60px">화요일</label>
										</td>
									</tr>
									<tr style="background-color: white; border-left: 1px solid #c9c9c9; border-right: 1px solid #c9c9c9;">										
										<td style="padding: 0;">
											<input type="checkbox" id="wednesday" name="dateCheck" value="수">
											<label for="wednesday" style="width: 100%; height: 100%; margin: 0; padding: 15px 15px 15px 60px">수요일</label>
										</td>
									</tr>
									<tr style="background-color: white; border-left: 1px solid #c9c9c9; border-right: 1px solid #c9c9c9;">										
										<td style="padding: 0;">
											<input type="checkbox" id="thursday" name="dateCheck" value="목">
											<label for="thursday" style="width: 100%; height: 100%; margin: 0; padding: 15px 15px 15px 60px">목요일</label>
										</td>
									</tr>
									<tr style="background-color: white; border-left: 1px solid #c9c9c9; border-right: 1px solid #c9c9c9;">										
										<td style="padding: 0;">
											<input type="checkbox" id="friday" name="dateCheck" value="금">
											<label for="friday" style="width: 100%; height: 100%; margin: 0; padding: 15px 15px 15px 60px">금요일</label>
										</td>
									</tr>
									<tr style="background-color: white; border-left: 1px solid #c9c9c9; border-right: 1px solid #c9c9c9;">										
										<td style="padding: 0;">
											<input type="checkbox" id="saturday" name="dateCheck" value="토">
											<label for="saturday" style="width: 100%; height: 100%; margin: 0; padding: 15px 15px 15px 60px">토요일</label>
										</td>
									</tr>
									<tr style="background-color: white; border-left: 1px solid #c9c9c9; border-right: 1px solid #c9c9c9;">										
										<td style="padding: 0;">
											<input type="checkbox" id="sunday" name="dateCheck" value="일">
											<label for="sunday" style="width: 100%; height: 100%; margin: 0; padding: 15px 15px 15px 60px">일요일</label>
										</td>
									</tr>
								</table>
								<div>
									<ul class="actions">
										<li style="margin-left: auto;"><a href="javascript:dateMoveAttention()" class="button">이전 단계</a></li>
										<li style="margin-right: auto;"><a href="javascript:dateMoveTime()" class="button">다음 단계</a></li>
									</ul>
								</div>
							</div>
							<%-- 레슨 시간 --%>
							<div class="inner" id="classTime" style="width: 50%; margin: 0 auto; display: none;">
								<table style="font-family: 'Noto Sans KR', sans-serif;">
									<caption style="float: left; font-size: 20px;"><span style="color: red;">희망하는 시간대</span>는 언제인가요?</caption>
									<tr style="background-color: white; border-left: 1px solid #c9c9c9; border-right: 1px solid #c9c9c9;">
										<td style="padding: 0;">
											<input type="checkbox" id="am09" name="timeCheck" value="09">
											<label for="am09" style="width: 100%; height: 100%; margin: 0; padding: 15px 15px 15px 60px">이른 오전(9시 이전)</label>
										</td>
									</tr>
									<tr style="background-color: white; border-left: 1px solid #c9c9c9; border-right: 1px solid #c9c9c9;">										
										<td style="padding: 0;">
											<input type="checkbox" id="am0912" name="timeCheck" value="0912">
											<label for="am0912" style="width: 100%; height: 100%; margin: 0; padding: 15px 15px 15px 60px">오전(9~12시)</label>
										</td>
									</tr>
									<tr style="background-color: white; border-left: 1px solid #c9c9c9; border-right: 1px solid #c9c9c9;">										
										<td style="padding: 0;">
											<input type="checkbox" id="pm1215" name="timeCheck" value="1215">
											<label for="pm1215" style="width: 100%; height: 100%; margin: 0; padding: 15px 15px 15px 60px">오후(12~3시)</label>
										</td>
									</tr>
									<tr style="background-color: white; border-left: 1px solid #c9c9c9; border-right: 1px solid #c9c9c9;">										
										<td style="padding: 0;">
											<input type="checkbox" id="pm1518" name="timeCheck" value="1518">
											<label for="pm1518" style="width: 100%; height: 100%; margin: 0; padding: 15px 15px 15px 60px">늦은 오후(3~6시)</label>
										</td>
									</tr>
									<tr style="background-color: white; border-left: 1px solid #c9c9c9; border-right: 1px solid #c9c9c9;">										
										<td style="padding: 0;">
											<input type="checkbox" id="pm1821" name="timeCheck" value="1821">
											<label for="pm1821" style="width: 100%; height: 100%; margin: 0; padding: 15px 15px 15px 60px">저녁(6~9시)</label>
										</td>
									</tr>
									<tr style="background-color: white; border-left: 1px solid #c9c9c9; border-right: 1px solid #c9c9c9;">										
										<td style="padding: 0;">
											<input type="checkbox" id="pm21" name="timeCheck" value="21">
											<label for="pm21" style="width: 100%; height: 100%; margin: 0; padding: 15px 15px 15px 60px">늦은 저녁(9시 이후)</label>
										</td>
									</tr>
								</table>
								<div>
									<ul class="actions">
										<li style="margin-left: auto;"><a href="javascript:timeMoveDate()" class="button">이전 단계</a></li>
										<li style="margin-right: auto;"><a href="#" class="button">나의 트레이너는?</a></li>
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
	<script src="https://code.jquery.com/jquery-latest.min.js" type="application/javascript"></script>
	<script type="application/javascript" src="https://zelkun.tistory.com/attachment/cfile8.uf@99BB7A3D5D45C065343307.js"></script>
	<!-- 체크박스 중복체크 막기 -->
	<!-- 미완성 -->
	<script>
		//2차원 배열로 해보기?
		// memberGender
		function noMultiMGender(chk){ 
			var obj = document.getElementsByName("memberGenderCheck"); 
			for(var i=0; i<obj.length; i++){ 
				if(obj[i] != chk){ 
					obj[i].checked = false; 
				} 
			} 
		}
		
		// trainerGender
		function noMultiTGender(chk){ 
			var obj = document.getElementsByName("trainerGenderCheck"); 
			for(var i=0; i<obj.length; i++){ 
				if(obj[i] != chk){ 
					obj[i].checked = false; 
				} 
			} 
		}
		
		// age
		function noMultiAge(chk){ 
			var obj = document.getElementsByName("ageCheck"); 
			
			for(var i=0; i<obj.length; i++){ 
				if(obj[i] != chk){ 
					obj[i].checked = false; 
				} 
			} 
		}
		
		// attention
		function noMultiAttention(chk){ 
			var obj = document.getElementsByName("attentionCheck"); 
			
			for(var i=0; i<obj.length; i++){ 
				if(obj[i] != chk){ 
					obj[i].checked = false; 
				} 
			} 
		}
		
		// date
		function noMultiDate(chk){ 
			var obj = document.getElementsByName("dateCheck"); 
			
			for(var i=0; i<obj.length; i++){ 
				if(obj[i] != chk){ 
					obj[i].checked = false; 
				} 
			} 
		}
		
		// time
		function noMultiTime(chk){ 
			var obj = document.getElementsByName("timeCheck"); 
			
			for(var i=0; i<obj.length; i++){ 
				if(obj[i] != chk){ 
					obj[i].checked = false; 
				} 
			} 
		}
		
		
	</script>
	<!-- 다음 단계 버튼 -->
	<script>
		var memberDiv = $("#memberGender");
		var trainerDiv = $("#trainerGender");
		var ageDiv = $("#memberAge");
		var areaDiv = $("#memberArea");
		var attentionDiv = $("#memberAttention");
		var dateDiv = $("#classDate");
		var timeDiv = $("#classTime");
		
		// member > trainer
		function memberMoveTrainer(){
			if($("input[name='memberGenderCheck']").is(":checked")){
				memberDiv.hide();
				trainerDiv.show();
			}else{
				alert("일치하는 항목에 체크해주세요😀");
			}
		}
		
		// trainer > member
		function trainerMoveMember(){
			memberDiv.show();
			trainerDiv.hide();
		}
		
		// trainer > age
		function trainerMoveAge(){
			if($("input[name='trainerGenderCheck']").is(":checked")){
				ageDiv.show();
				trainerDiv.hide();
			}else{
				alert("일치하는 항목에 체크해주세요😀");
			}
		}
		
		// age > trainer
		function ageMoveTrainer(){
			trainerDiv.show();
			ageDiv.hide();
		}
		
		// age > area
		function ageMoveArea(){
			if($("input[name='ageCheck']").is(":checked")){
				areaDiv.show();
				ageDiv.hide();
			}else{
				alert("일치하는 항목에 체크해주세요😀");
			}
		}
		
		// area > age
		function areaMoveAge(){
			ageDiv.show();
			areaDiv.hide();
		}
		
		// 선택 안하면 어떻게 안넘어가게 할지 생각해보기.
		// area > attention
		function areaMoveAttention(){
			attentionDiv.show();
			areaDiv.hide();
		}
		
		// attention > area
		function attentionMoveArea(){
			areaDiv.show();
			attentionDiv.hide();
		}
		
		// attention > classDate
		function attentionMoveDate(){
			if($("input[name='attentionCheck']").is(":checked")){
				dateDiv.show();
				attentionDiv.hide();
			}else{
				alert("일치하는 항목에 체크해주세요😀");
			}
		}
		
		// classDate > attention
		function dateMoveAttention(){
			attentionDiv.show();
			dateDiv.hide();
		}
		
		// classDate > classTime
		function dateMoveTime(){
			if($("input[name='dateCheck']").is(":checked")){
				timeDiv.show();
				dateDiv.hide();
			}else{
				alert("일치하는 항목에 체크해주세요😀");
			}
		}
		
		// classTime > classDate
		function timeMoveDate(){
			dateDiv.show();
			timeDiv.hide();
		}
	</script>
	
	<!-- 주소 jQuery -->
	<script>
		jQuery(document).ready(function(){
			//sido option 추가
			jQuery.each(hangjungdong.sido, function(idx, code){
				//append를 이용하여 option 하위에 붙여넣음
				jQuery('#sido').append(fn_option(code.sido, code.codeNm));
		  	});

			//sido 변경시 시군구 option 추가
			jQuery('#sido').change(function(){
				jQuery('#sigugun').show();
		    	jQuery('#sigugun').empty();
		    	jQuery('#sigugun').append(fn_option('','선택')); //
		    	jQuery.each(hangjungdong.sigugun, function(idx, code){
				if(jQuery('#sido > option:selected').val() == code.sido)
					jQuery('#sigugun').append(fn_option(code.sigugun, code.codeNm));
		    	});

		    	//세종특별자치시 예외처리
		    	//옵션값을 읽어 비교
				if(jQuery('#sido option:selected').val() == '36'){
					jQuery('#sigugun').hide();
					//index를 이용해서 selected 속성(attr)추가
		      		//기본 선택 옵션이 최상위로 index 0을 가짐
		      		jQuery('#sigugun option:eq(1)').attr('selected', 'selected');
		      		//trigger를 이용해 change 실행
		      		jQuery('#sigugun').trigger('change');
		    	}
			});

			//시군구 변경시 행정동 옵션추가
			jQuery('#sigugun').change(function(){
				//option 제거
		    	jQuery('#dong').empty();
		    	jQuery.each(hangjungdong.dong, function(idx, code){
		      		if(jQuery('#sido > option:selected').val() == code.sido && jQuery('#sigugun > option:selected').val() == code.sigugun)
		        		jQuery('#dong').append(fn_option(code.dong, code.codeNm));
		    	});
		    	//option의 맨앞에 추가
			    jQuery('#dong').prepend(fn_option('','선택'));
			    //option중 선택을 기본으로 선택
			    jQuery('#dong option:eq("")').attr('selected', 'selected');
			});

			jQuery('#dong').change(function(){
			    var sido = jQuery('#sido option:selected').val();
			    var sigugun = jQuery('#sigugun option:selected').val();
			    var dong = jQuery('#dong option:selected').val();
		    	var dongCode = sido + sigugun + dong + '00';
		  	});
		});

		function fn_option(code, name){
			return '<option value="' + code +'">' + name +'</option>';
		}
	</script>
	
</html>