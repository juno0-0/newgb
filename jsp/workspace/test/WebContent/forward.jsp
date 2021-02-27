<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forward로 페이지 이동하
기</title>
</head>
<body>
	<form action="controller.jsp">
		<select name="test">
			<option value="네이버">네이버</option>
			<option value="구글">구글</option>
			<option value="다음">다음</option>
		</select>
		<input type="submit" value="이동!">
	</form>
</body>
</html>