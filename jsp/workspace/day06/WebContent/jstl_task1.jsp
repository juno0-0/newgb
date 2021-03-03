<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL TASK1</title>
</head>
<body>
<!--
	사용자에게 이름을 입력받고 확인버튼을 눌렀을 때
	admin일 경우 "관리자", member일 경우 "일반 회원", 그 외에는 "비회원(전달받은 이름)"을 출력한다.
	
	※ 다른 페이지 없이 현재 페이지 하나에서만 처리하고, 결과가 출력될 때에는 input태그와 submit버튼이 나오게 해서는 안된다.
	※ form태그의 속성은 action을 생략하면 현재 페이지로 이동이 된다.
	※el과 jstl만 사용한다(자바스크립트 금지)
-->
	<!-- submit해서 넘어온 name을 변수로 담음 -->
	<c:choose>
		<c:when test="${empty param.name}">		
			<form>
				이름 : <input type="text" name="name">
				<button>확인</button>
			</form>
		</c:when>
		<c:when test="${param.name == 'admin'}">관리자</c:when>
		<c:when test="${param.name == 'member'}">일반 회원</c:when>
		<c:otherwise>비회원 : (<c:out value="${param.name}"/>)</c:otherwise>
	</c:choose>
	
	
</body>
</html>