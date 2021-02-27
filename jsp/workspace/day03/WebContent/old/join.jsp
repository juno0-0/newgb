<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
<!--
	1. 입력한 아이디를 join_ok.jsp로 전송
	2. join.ok.jsp에서 DAO에서 아이디 중복검사 메소드 사용
	3. 결과를 join.jsp로 전송(check)
	4. join.jsp에서 check의 값에 따른 적절한 메세지를 p태그에 삽입
	
	※우선 check가 null인지부터 판단한 후 false, true 검사
	※어떻게 자바코드에 있는 변수를 JS코드로 가져올 수 있을까?
-->
	<%
		String check = request.getParameter("check");
	
		if(check == null){
			check = "";
		}
	%>
	<input type="hidden" name="check" value="<%=check%>"><!-- 자바변수를 JS로 가져오는 법 -->
	<form name="joinForm" action="join_ok.jsp">
		아이디 : <input type="text" name="id"><p id="result"></p>
		<input type="button" value="완료" onclick="sendIt()">
	</form>
</body>
<script src="//code.jquery.com/jquery-3.5.1.min.js"></script>
<script>
	var check = $("input[name='check']").val();
	
	if(check != ""){
		if(check == "true"){
			$("p#result").text("중복된 아이디입니다.");
		}else{
			$("p#result").text("사용 가능한 아이디입니다.");
		}
	}

	//jsp 파일 내부에서만 쓸 수 있는 문법이다.
<%-- 	var check = '<%=check%>';
	
	<%if(check.equals("false")){%>
		$("#result").text("사용할 수 있는 아이디입니다.");
	<%}else if(check.equals("true")){%>
		$("#result").text("중복된 아이디입니다.");
	<%}%> --%>
	
	function sendIt(){
		if($("input[name='id']").val() == ""){
			alert("아이디를 입력해주세요.");
			return false;
		}	
		
		
		document.joinForm.submit();
	}
</script>
</html>