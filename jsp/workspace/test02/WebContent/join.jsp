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
		String check = request.getParameter("check");
	
		if(check == null){
			check = "";
		}
	%>

	<form name="formTag" action="join_ok.jsp">
		아이디 : <input type="text" name="id"><p id="result"></p>
		<input type="button" value="완료" onclick="sendIt()">
	</form>
</body>
<script src="//code.jquery.com/jquery-3.5.1.min.js"></script>
<script>
	var check = '<%=check%>';
	
	<%if(check.equals("true")){%>
		$("#result").text("중복된 아이디입니다.");
	<%}else{%>
		$("#result").text("사용할 수 있는 아이디입니다.");
	<%}%>

	function sendIt(){
		if($("input[name='id']").val() == ""){
			alert("이름을 입력해주세요.");
			return false;
		}
		
		document.formTag.submit();
	}
</script>
</html>