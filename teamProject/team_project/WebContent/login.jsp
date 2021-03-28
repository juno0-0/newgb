<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<!--
	Phantom by Pixelarity
	pixelarity.com | hello@pixelarity.com
	License: pixelarity.com/license
-->

<!-- 
	로그인 성공 시 알럿창으로 
	"오늘은 하체 어떠신가요?"
	"오늘은 우람한 어깨를 만들어볼까요?"
	"오늘은 지방을 태워볼까요?" 
	등의 알림창 띄우고 메인페이지 띄우기?
 -->
<html>
	<head>
		<title>Untitled</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="assets/css/main.css" />
		<link rel="preconnect" href="https://fonts.gstatic.com">
		<link href="https://fonts.googleapis.com/css2?family=Gothic+A1:wght@600&display=swap" rel="stylesheet">
		<noscript><link rel="stylesheet" href="assets/css/noscript.css" /></noscript>
		<!-- 모달창 스타일 적용 -->
		<style>
			.modal_wrap{
				display: none;
				width: 400px;
				height: 350px;
				position: absolute;
				top:55%;
				left: 50%;
				margin: -250px 0 0 -250px;
				background:white;
				z-index: 2;
			}
			.black_bg{
				display: none;
				position: absolute;
				content: "";
				width: 100%;
				height: 100%;
				background-color:rgba(0, 0,0, 0.5);
				top:0;
				left: 0;
				z-index: 1;
			}
			.modal_close{
				width: 26px;
				height: 26px;
				position: absolute;
				top: -30px;
				right: 0;
			}
			.modal_close> a{
				display: block;
				width: 100%;
				height: 100%;
				background:url(https://img.icons8.com/metro/26/000000/close-window.png);
				text-indent: -9999px;
			}
			

		</style>
	</head>
	<body class="is-preload">
		<!-- Wrapper -->
			<div id="wrapper">

				<!-- Header -->
				<header id="header">
					<div class="inner" style="float:right;">
						<!-- Logo -->
						<a href="index.html" class="logo">
							<span class="symbol"><img src="images/logo.png" alt="" /></span><span class="title">Phantom</span>
						</a>
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
					<div class="inner">
						<h1>Generic Page</h1>
						<div class="row">
							<div class="col-6 col-12-medium">
								<input type='button' id="modal_btn" class="button primary" value="로그인">
								<div class="black_bg"></div>
								<div class="modal_wrap">
								    <div class="modal_close"><a href="#">close</a></div>
							    	<div class="inner" style="text-align: center; padding-top: 40px;">										
										<span class="title" style="font-family: 'Gothic A1', sans-serif; font-size: 40px;">득근하러 가기💪</span>
										<form name="" action="" method="">
											<div style="width: 50%; margin: 0 auto;">
												<label style="margin: 0 auto; font-size: 12px; text-align: left;">아이디</label>
												<input type="text" name="id" id="id" value="" style="margin: 0 auto; height: 40px;"/>
											</div>														
											<div style="width: 50%; margin: 0 auto;">
												<label style="margin: 10px 0 auto; font-size: 12px; text-align: left;">비밀번호</label>
												<input type="password" name="pw" id="pw" value="" style="margin: 0 auto; height: 40px;"/>
											</div>														
											<div style="margin-top:25px; text-align: center;"><input type='button' id="modal_btn" class="button primary" value="로그인"></div>
										</form>
									</div>
								 </div>
							</div>
							<span class="image main"><img src="images/pic13.jpg" alt="" /></span>
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
	<!-- 모달창 javascript -->
	<script>
    	window.onload = function() {
			function onClick() {
				document.querySelector('.modal_wrap').style.display ='block';
				document.querySelector('.black_bg').style.display ='block';
			}
			
			function offClick() {
				document.querySelector('.modal_wrap').style.display ='none';
				document.querySelector('.black_bg').style.display ='none';
			}
	 
			document.getElementById('modal_btn').addEventListener('click', onClick);
			document.querySelector('.modal_close').addEventListener('click', offClick);
		};
	</script>


<!-- 	<script>
		function popResizer(o){
			var tmp = [$(o).width(), $(o).height()];
			window.resizeTo(tmp[0],tmp[1]);
		}
		//집 환경에서 가운데 정렬이 안먹고 있음, 다른 사람은 된다는데 다시 확인하기
		//resizable=no는 IE에서만 적용된다.
		function loginPopup(){
			var popWidth = '400px';
			var popHeight = '600px';
			
			var popLeft = Math.ceil((window.screen.width - popWidth) / 2);
			var popTop = Math.ceil((window.screen.height) / 2);
			
			var popOption = "resizable, width=400, height=600";
			
			window.open("login.html", "Login", popOption);
			window.resizeTo(400, 600);
			window.resizeBy(-100,-100);
		}
	</script> -->
</html>