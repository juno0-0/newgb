<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>MVC 게시판</title>
	</head>
	<body>
	   	<%-- sessionScope에 session_id가 없다면 로그인 창으로 이동 --%>
		<c:if test="${session_id == null}">
			<script>
				alert("로그인 후 이용이 가능합니다.");
				location.replace("${pageContext.request.contextPath}/member/MemberLogin.me");
			</script>
		</c:if>
		<%-- requestScope에서 값 가져오기 --%>
		<c:set var="totalCnt" value="${requestScope.totalCnt}"/>
		<c:set var="nowPage" value="${requestScope.nowPage}"/>
		<c:set var="startPage" value="${requestScope.startPage}"/>
		<c:set var="endPage" value="${requestScope.endPage}"/>
		<c:set var="realEndPage" value="${requestScope.realEndPage}"/>
		<c:set var="boardList" value="${boardList}"/>
		<center>
			<table border="0" cellpadding="0" cellspacing="0" width="900px" >
				<tr align="right" valign="middle">
					<td>
						${session_id} 님 환영합니다.
						<a href="${pageContext.request.contextPath}/member/MemberLogout.me">로그아웃</a>
					</td>
				</tr>
			</table>
			<br />
			<br />
	         
			<!-- 게시판 리스트 -->
			<table width="900px" border="0" cellpadding="0" cellspacing="0">
				<tr align="center" valign="middle">
					<td><h3>MVC 게시판</h3></td>
				</tr>
				<tr align="right" valign="middle">
					<td>글 개수 : <c:out value="${totalCnt}"/>개</td>
				</tr>
			</table>
	         
			<table border="1" cellpadding="0" cellspacing="0" width="900px" >
				<tr align="center" valign="middle">
					<td width="8%" height="26">
						<div align="center">번호</div>
					</td>
					<td width="50%">
						<div align="center">제목</div>
					</td>
					<td width="14%">
						<div align="center">작성자</div>
					</td>
					<td width="17%">
						<div align="center">날짜</div>
					</td>
					<td width="11%">
						<div align="center">조회수</div>
					</td>
				</tr>
				<c:choose>
					<c:when test="${boardList != null and fn:length(boardList) > 0}">
						<%-- items에는 배열이나 List가 들어간다. --%>
						<c:forEach var="b_bean" items="${boardList}">
							<tr align="center" valign="middle" onmouseover="this.style.backgroudColor='F8F8F8'" onmouseout="this.style.backgroundColor='FFFFFF'">
								<td height="23" style="font-family:Tahoma; font-size:10pt;">
									${b_bean.getBoardNum()}
								</td>
								<td style="font-family:Tahoma; font-size:10pt;">
									<div align="left">
										<%-- 글 제목을 누르면 게시판 상세보기로 이동 --%>
										<a href="${pageContext.request.contextPath}/board/BoardView.bo?boardNum=${b_bean.getBoardNum()}&page=${nowPage}">
											${b_bean.getBoardTitle()}
										</a>
									</div>
								</td>
								<td>
									<div align="center">
										${b_bean.getBoardId()}
									</div>
								</td>
								<td>
									<div align="center">
										${b_bean.getBoardDate()}
									</div>
								</td>
								<td>
									<div align="center">
										${b_bean.getReadCount()}
									</div>
								</td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="5" align="center">등록된 게시물이 없습니다.</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</table>
			<br/>
			<%-- [이전] 1 2 3 ... 10 [다음] --%>
			<table border="0" cellpadding="0" cellspacing="0" width="900px">
				<tr align="center" valign="middle">
					<td>
						<%-- 현재 페이지가 1보다 크다면 [이전]버튼을 만든다. --%>
						<c:if test="${nowPage >1}">
							<a href="${pageContext.request.contextPath}/board/BoardList.bo?page=${nowPage - 1}">[이전]</a>
						</c:if>
				 		<c:forEach var="i" begin="${startPage}" end="${endPage}">
				 			<c:choose>
				 				<c:when test="${i eq nowPage}">
				 					[${i}]&nbsp;
				 				</c:when>
				 				<c:otherwise>
				 					<a href="${pageContext.request.contextPath}/board/BoardList.bo?page=${i}">${i}&nbsp;</a>
				 				</c:otherwise>
				 			</c:choose>
				 		</c:forEach>
						<c:if test="${realEndPage != nowPage}">
							<a href="${pageContext.request.contextPath}/board/BoardList.bo?page=${nowPage + 1}">[다음]</a>
						</c:if>
					</td>
				</tr>
			</table>
			<table border="0" cellpadding="0" cellspacing="0" width="900px">
				<tr align="right" valign="middle">
					<td><a href="${pageContext.request.contextPath}/board/BoardWrite.bo?page=${nowPage}">[글쓰기]</a></td>
				</tr>
			</table>
		</center>
	</body>
</html>