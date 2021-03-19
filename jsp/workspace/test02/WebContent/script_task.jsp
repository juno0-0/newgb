<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스크립트 실습</title>
</head>
<body>
<!--
   아래의 모양과 같이 테이블 만들기
   
   □
   □□
   □□□
   □□□□
   □□□□□
   □□□□□
   □□□□
   □□□
   □□
   □
   10행 5열
-->
	<%-- <table>
		<%for(int i=0; i<5; i++){%>
			<tr>
			<%for(int j=0; j<i+1; j++){%>
				<td>ㅁ</td>
			<%}%>
			</tr>
		<%}%>
		<%for(int i=0; i<5; i++){%>
			<tr>
			<%for(int j=i; j<5; j++){%>
				<td>ㅁ</td>
			<%}%>
			</tr>
		<%}%>
	</table> --%>
	<table border="1" style="border-collapse: collapse;">
		<%for(int i=0; i<5; i++){%>
			<tr>
			<%for(int j=0; j<i+1; j++){%>
				<td><%=i%>행<%=j%>열</td>
			<%}%>
			</tr>
		<%}%>
		<%for(int i=0; i<5; i++){%>
			<tr>
			<%for(int j=i; j<5; j++){%>
				<td><%=i+5%>행<%=j-i%>열</td>
			<%}%>
			</tr>
		<%}%>
	</table>
</body>
</html>