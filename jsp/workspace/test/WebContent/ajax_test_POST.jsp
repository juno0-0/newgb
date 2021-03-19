<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>POST 방식의 요청</h1>
	<button onclick="sendIt()">POST 방식으로 요청 보내기!</button>
	<p id="text"></p>
</body>
<script>
	function sendIt(){
		var httpRequest = new XMLHttpRequest();
		
		httpRequest.open("POST", "request_ajax.jsp", true);
		//서버로 전송할 데이터 타입의 형식을 지정한다.
		httpRequest.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
		httpRequest.send("name=iu&age=29");
		
		httpRequest.onreadystatechange = function(){
			if(httpRequest.readyState == XMLHttpRequest.DONE){
				if(httpRequest.status == 200){
					document.getElementById("text").innerHTML = httpRequest.responseText;
				}
			}
		}
	}
</script>
</html>