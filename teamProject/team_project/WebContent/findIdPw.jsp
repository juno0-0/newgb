<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<!--
	Phantom by Pixelarity
	pixelarity.com | hello@pixelarity.com
	License: pixelarity.com/license
-->

<!-- 

	아이디 찾기에서 다음 단계를 누르면 ajax로 핸드폰 번호와 일치하는 아이디를 찾아서
	메인 페이지로 이동 후 alert으로 
	가입 되어 있는 아이디
	    abc***gh
	보여주고 
	비밀번호 찾기에서 다음 단계를 누르면 비밀번호 변경 페이지로 이동 
 -->
<html>
	<head>
		<title>Untitled</title>
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
						<div class="inner" style="text-align: center;">

							<!-- Logo -->
								<a href="index.jsp" class="logo">
									<span class="symbol"><img src="images/logo.png" alt="" /></span><span class="title">득근득근</span>
								</a>
						</div>
					</header>

				<!-- Menu -->


				<!-- Main -->
					<div id="main">
						<div class="inner" style="width: 70%; margin: 0 auto;">
							<div style="overflow: hidden; text-align: center;">
								<a href="javascript:showIdDiv()" class="button" >Find ID</a>
								<a href="javascript:showPwDiv()" class="button primary">Find PW</a>
							</div>
							<hr style="width: 60%; margin-left: auto; margin-right: auto;">
							<div style="text-align: center;">
								<label id="ID">아이디 찾기</label>
								<label id="PW" style="display: none;">비밀번호 찾기</label>
							</div>
							<div id="findIdDiv" style="width: 60%; margin: 0 auto;">
								<form method="post" action="#">
									<div style="margin: 0 auto; width:70%;">
										<label style="margin: 0 auto; font-size: 12px">핸드폰 번호</label>
										<input type="text" class="findInput" name="demo-name" id="phoneNum" value="" placeholder="" style="width: 60%; margin: 0 auto; float:left; height: 2.1em;"/>
										<a href="javascript:temp()" class="button primary small" style="width: 40%">발송</a>
									</div>
									<br>
									<div style="margin: 0 auto; width:70%;">
										<label style="margin: 0 auto; font-size: 12px">인증 번호</label>
										<input type="text" class="findInput" name="demo-name" id="checkNum" value="" placeholder="" style="width: 60%; margin: 0 auto; float:left; height: 2.1em;" readonly/>
										<input type="button" id="disableAtag" class="button primary small" style="width: 40%;" value="확인" disabled>
									</div>
								</form>
								<hr style="margin-left: auto; margin-right: auto;">
								<div style="text-align: center; margin: 0 auto;">
									<a href="index.jsp" class="button primary" >돌아가기</a>
									<a href="#" class="button" >다음 단계</a>
								</div>
							</div>
							<div id="findPwDiv" style="width: 60%; margin: 0 auto; display: none;">
								<form method="post" action="changePw.jsp" name="findPwForm">
									<div style="margin: 0 auto; width:70%;">
										<label style="margin: 0 auto; font-size: 12px">아이디</label>
										<input type="text" class="findInput" name="demo-name" id="demo-name" value="" placeholder="" style="margin: 0 auto; height: 2.1em;"/>
									</div>
									<br>
									<div style="margin: 0 auto; width:70%;">
										<label style="margin: 0 auto; font-size: 12px">핸드폰 번호</label>
										<input type="text" class="findInput" name="demo-name" id="demo-name" value="" placeholder="" style="width: 60%; margin: 0 auto; float:left; height: 2.1em;"/>
										<a href="#" class="button primary small" style="width: 40%">발송</a>
									</div>
									<br>
									<div style="margin: 0 auto; width:70%;">
										<label style="margin: 0 auto; font-size: 12px">인증 번호</label>
										<input type="text" class="findInput" name="demo-name" id="aTest" value="" placeholder="" style="width: 60%; margin: 0 auto; float:left; height: 2.1em;" readonly/>
										<input type="button" id="disableAtag" class="button primary small" style="width: 40%;" value="확인" disabled>
									</div>
								</form>
								<hr style="margin-left: auto; margin-right: auto;">
								<div style="text-align: center; margin: 0 auto;">
									<a href="index.jsp" class="button primary" >돌아가기</a>
									<a href="javascript:findPwForm.submit()" class="button" >다음 단계</a>
								</div>
							</div>
						</div>
					</div>
			</div>

		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/browser.min.js"></script>
			<script src="assets/js/breakpoints.min.js"></script>
			<script src="assets/js/util.js"></script>
			<script src="assets/js/main.js"></script>

	</body>
	<script src="//code.jquery.com/jquery-3.5.1.min.js"></script>

	<script>
		var idDiv = $("#findIdDiv");
		var pwDiv = $("#findPwDiv");
		var pwLabel = $("#PW");
		var idLabel = $("#ID");
	
		//아이디 찾기 DIV
		function showIdDiv(){
			idDiv.show();
			idLabel.show();
			pwDiv.hide();
			pwLabel.hide();
		}
		
		//비밀번호 찾기 DIV
		function showPwDiv(){
			idDiv.hide();
			idLabel.hide();
			pwDiv.show();
			pwLabel.show();
		}
		
		function temp(){
			var phoneNum = $("#phoneNum").val();
			var checkButton = $("#disableAtag");
			var checkNum = $("#checkNum");
			
			if(phoneNum != "" && phoneNum != null){
				checkButton.removeAttr("disabled");
				checkNum.removeAttr("readonly");
			}
		}
	</script>
</html>