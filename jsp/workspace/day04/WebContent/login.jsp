<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
<!-- 로그인 성공과 로그인하기 전 -->
<%
	String userid = null;
	//null이면 로그인 실패거나 로그인을 안한 상태
	if(session.getAttribute("userid") != null){
		//세션에 저장되어 있는 userid라는 key로 value를 가져온다.
		userid = (String)session.getAttribute("userid");
%>
		<p><%=userid%>님 환영합니다.</p>
		<p><a href="logout.jsp">[로그아웃]</a></p>
<%
	}else{
%>
		<form action="login_ok.jsp" method="post" name="loginForm">
			<p><label>아이디 : <input type="text" name="userid"></label></p>
			<p><label>비밀번호 : <input type="password" name="pwd"></label></p>
			<p><input type="button" value="로그인" onclick="sendIt()"></p>
		</form>
<%
	}
%>
</body>
<script>
	var frm = document.loginForm;
	
	function sendIt(){
		if(frm.userid.value == ""){
			alert("아이디를 입력해주세요.");
			frm.userid.focus();
			return false;
		}
		
		if(frm.pwd.value == ""){
			alert("비밀번호를 입력해주세요.");
			frm.pwd.focus();
			return false;
		}
		
		frm.submit();
	}
</script>
</html>