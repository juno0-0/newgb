<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구단 만들기</title>
</head>
<body>
<!--
	1단 부터 100단까지 중 사용자에게 입력받은 단수로 구구단 출력하기.
	입력받은 값이 정수인지 아닌지 판단, 값을 입력했는지 안했는지 판단.
	다른 페이지 이동 없이 현재 페이지에서만 기능 구현
	자바스크립트 사용 가능(Number.isInteger(값) : boolean) 
-->

	<form name="frm">
		<input type="text" id="dan" name="dan"/>
		<input type="button" value="확인" onclick="sentIt()">
	</form>
	
	<c:set var="dan" value="${param.dan}" scope="request"/>
	
	<c:if test="${!empty dan}">
		<c:choose>
			<c:when test="${dan > 0 && dan < 101}">
				<c:forEach var="i" begin="1" end="9">
					<c:out value="${dan} * ${i} = ${dan*i}"/>
					<br>
				</c:forEach>
			</c:when>
			<c:otherwise>
				1~100까지 골라주세요.
			</c:otherwise>
		</c:choose>
	</c:if>
</body>
<script>
	document.addEventListener("keydown", function(key){
		if(key.keyCode == 13){
			key.preventDefault();
		}
	})

	function sentIt(){
		var frm = document.frm;
		var dan = frm.dan.value;
		var check = dan % 1 == 0;
		
		if(!check || dan == "" || !Number.isInteger(Number.parseInt(dan))){
			alert("정수만 입력해주세요.");
			frm.dan.focus();
			return false;
		}
		/* 3.0, 4.0 이런걸 거르기 위해서 */
		frm.dan.value = parseInt(dan);
		frm.submit();
	}
</script>
</html>