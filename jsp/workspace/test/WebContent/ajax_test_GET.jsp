<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>GET 방식의 요청</h1>
	<button onclick="sendIt()">GET 방식으로 요청 보내기!</button>
	<p id="text"></p>
</body>
<script>
	function sendIt(){
		var httpRequest = new XMLHttpRequest();
		
		httpRequest.open("GET", "request_ajax.jsp?name=iu&age=29", true);
		httpRequest.send();
		
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