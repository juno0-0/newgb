<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>3행 5열 만들기</h3>
	<table>
		<%for(int i=0; i<3; i++){%>
			<tr>
			<%for(int j=0; j<5; j++){%>
				<td><%=i%>행 <%=j%>열</td>
			<%}%>
			</tr>
		<%}%>
	</table>
</body>
</html>