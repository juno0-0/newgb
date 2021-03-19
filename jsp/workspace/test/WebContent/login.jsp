<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String userid = null;
	
		if(session.getAttribute("userid") != null){
			userid = (String)session.getAttribute("userid");
	%>
		<p><%=userid%>님 환영합니다.</p>
		<a href="logout.jsp">로그아웃으로 이동하기.</a>
	<%
		}else{
	%>
			<form action="login_ok.jsp" name="loginForm" method="post">
				<p><label>아이디 : <input type="text" name="userid"></label></p>
				<p><label>비밀번호 : <input type="password" name="userpw"></label></p>
				<p><label><input type="button" value="로그인" onclick="sendIt()"></label></p>
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
		
		if(frm.userpw.value == ""){
			alert("비밀번호를 입력해주세요.");
			frm.userpw.focus();
			return false;
		}
		
		frm.submit();
	}
</script>
</html>