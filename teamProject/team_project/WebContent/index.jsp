<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Untitled</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="assets/css/main.css" />
		<!-- <link rel="stylesheet" href="assets/css/slide.css" /> -->
		<noscript><link rel="stylesheet" href="assets/css/noscript.css" /></noscript>
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
					<div style= "text-align:center;"index_03">
					 <div id="header3"></div>
					  <div id="slide3"> 
					  <ul> 
					  <li><a href="#"><img style="height:300px;"src="images/slide1.jpg" alt="슬라이드1"></a></li> 
					  <li><a href="#"><img src="images/slide2.png" alt="슬라이드2"></a></li>
					  <li><a href="#"><img src="images/slide3.jpg" alt="슬라이드3"></a></li> 
					  </ul> 
					  </div> 
					  </div>
	
				<!-- modal -->
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
					
	

						<div class="inner">
							<header></header>
							<section class="tiles">
								<article class="style1">
									<span class="image">
										<img src="images/trainer.jpg" alt="" />
									</span>
									<a href="generic.html">
										<h2>트레이너</h2>
										<div class="content">
											<p>트레이너는 이곳으로..</p>
										</div>
									</a>
								</article>
								<article>
									<span class="image">
										<img src="images/mainLogo.png" alt="" />
									</span>
									<a href="index.jsp">
									</a>
								</article>
								<article class="style3">
									<span class="image">
										<img src="images/member.jpg" alt="" />
									</span>
									<a href="generic.html">
										<h2>일반회원</h2>
										<div class="content">
											<p>득근합시다!</p>
										</div>
									</a>
								</article>
								<article class="style4">
									<span class="image">
										<img src="images/qna.jpg" alt="" />
									</span>
									<a href="generic.html">
										<h2>문의게시판</h2>
										<div class="content">
											<p> 사이트 이용 중에 불편한 사항이나 궁금한 점을 질문하세요. </p>
										</div>
									</a>
								</article>
								
								<article class="style5" style="display:hidden;">
									<span class="image">
									</span>				
								</article>
								
								<article class="style6">
									<span class="image">
										<img src="images/leader.jpg" alt="" />
									</span>
									<a href="generic.html">
										<h2>운동성향 알아보기</h2>
										<div class="content">
											<p> 설문을 통해 나의 운동 성향과 나에게 맞는 트레이너를 찾을 수 있어요. </p>
										</div>
									</a>
								</article>
								
						</div>
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
		<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/browser.min.js"></script>
			<script src="assets/js/breakpoints.min.js"></script>
			<script src="assets/js/util.js"></script>
			<script src="assets/js/main.js"></script>
			<script src="assets/js/slide.js"></script>




	</body>
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
</html>