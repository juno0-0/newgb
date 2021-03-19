<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<td class="td1">실시간 정보 확인</td>
			<td class="td2"><div id="ranking">키워드</div></td>
		</tr>
	</table>
</body>
<script>
	window.onload = function(){
		var favorit = new Array();
		var obj = "";
		var ranking = document.getElementById("ranking");
		
		//Ajax
		var httpRequest = new XMLHttpRequest();
		
		httpRequest.open("GET", "data.json", true);
		httpRequest.send();
		
		httpRequest.onreadystatechange = function(){
			if(httpRequest.readyState == XMLHttpRequest.DONE){
				if(httpRequest.status == 200){
					obj = JSON.parse(httpRequest.responseText);
					
					for(let i=0; i<obj.favorit.length; i++){
						favorit[i] = "["+obj.favorit[i].rank+"]"+obj.favorit[i].name;
					}
				}
			}
		}
		var i = 0;
		var interval = setInterval(function(){
			if(i == obj.favorit.length){i=0;}
			ranking.innerHTML = "<h3>"+favorit[i]+"</h3>";
			i++;
		},500);
		
		var timeout = setTimeout(function(){
			clearInterval(interval);
		},10000);
		
		
	}
</script>
</html>