<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>MVC 게시판</title>
	</head>
	<body>
		<%-- req.setAttribute()한 것을 변수로 만드는 것 --%>
		<c:set var="b_vo" value="${b_vo}"/>
		<c:set var="files" value="${fileList}"/>
		<c:set var="replies" value="${replies}"/>
		<center>
		<c:choose>
			<c:when test="${session_id eq null}">
			<script>
				alert("로그인 후 이용해주세요");
				location.replace("${pageContext.request.contextPath}/member/MemberLogin.me");
			</script>
			</c:when>
			<c:otherwise>
			<table border="0" cellpadding="0" cellspacing="0" width="900px" >
				<tr align="right" valign="middle">
					<td>
						${session_id} 님 환영합니다.
						<a href="${pageContext.request.contextPath}/member/MemberLogout.me">로그아웃</a>
					</td>
				</tr>
			</table>
			</c:otherwise>
			</c:choose>
			<br />
			<br />
		
			<table width="900px" border="0" cellpadding="0" cellspacing="0">
				<tr align="center" valign="middle">
					<td><h3>MVC 게시판</h3></td>
				</tr>
			</table>
				
			<table width="900px" border="1" cellpadding="0" cellspacing="0">
				<tr height="30px">
					<td align="center" width="150px">제 목</td>
					<td style="padding-left:10px;">${b_vo.getBoardTitle()}</td>
				</tr>
				
				<tr height="30px">
					<td  align="center" width="150px">아이디</td>
					<td style="padding-left:10px;">${b_vo.getBoardId()}</td>
				</tr>
				
				<tr height="200px">
					<td align="center" width="150px">내 용</td>
					<td valign="top" style="padding-top:10px; padding-left:10px;">${b_vo.getBoardContent()}</td>
				</tr>
				<%-- 첨부파일이 없으면 태그 자체가 보이지 않는다. --%>
				<c:if test="${files != null}">
					<tr height="30px">
						<td align="center">첨부파일</td>
						<td>
							<c:forEach var="file" items="${files}">
								<a href="${pageContext.request.contextPath}/board/FileDownload.bo?fileName=${file.getFileName()}">${file.getFileName()}</a>	
							</c:forEach>
						</td>
					</tr>
				</c:if>
			</table>
			<table width="900px" border="0" cellpadding="0" cellspacing="0">
				<tr align="right" valign="middle">
					<td>
						<%-- 로그인 시 session에 등록한 id와 작성자의 id가 같으면  수정, 목록 버튼을 보여준다. --%>
						<c:if test="${b_vo.getBoardId() eq session_id}">
							<a href="${pageContext.request.contextPath}/board/BoardModify.bo?boardNum=${b_vo.getBoardNum()}&page=${page}">[수정]</a>
							<a href="javascript:deleteBoard()">[삭제]</a>
						</c:if>
						<a href="${pageContext.request.contextPath}/board/BoardList.bo?page=${page}">[목록]</a>
					</td>
				</tr>
			</table>
			<%-- 
				method가 post여도 action에 쿼리스트링으로 데이터를 넘길 수도 있다.
				post 방식으로 데이터가 안넘어가는 경우 쿼리스트링으로 넘기자
				(동시에 사용할 수 있다.)
			 --%>
			 
			<%-- 게시글 삭제 form --%>
			<form name="deleteForm" method="post" action="${pageContext.request.contextPath}/board/BoardDelete.bo" enctype="multipart/form-data">
				<input type="hidden" name="boardNum" value="${b_vo.getBoardNum()}">
				<input type="hidden" name="page" value="${page}">
			</form>
			<%-- 댓글 --%>
			<table id=replyTable></table>
		</center>
	</body>
	<script src="//code.jquery.com/jquery-3.5.1.min.js"></script>
	<script src="https://rawgit.com/jackmoore/autosize/master/dist/autosize.min.js"></script>
	<script>
		//게시글 삭제
		function deleteBoard(){
			deleteForm.submit();
		}
	</script>
	<script>
		$(document).ready(function(){getList();});
	
		var check = false;
		var pageContext = "${pageContext.request.contextPath}";
		var boardNum = "${b_vo.getBoardNum()}";
		
		//댓글 추가
		function insertReply(){
			var content = $("textarea[name='replyContent']").val();
			$.ajax({
				url : pageContext + "/board/BoardReplyOk.bo",
				type : "post",
				data : {"boardNum" : boardNum, "content" : content},
				dataType : "text",
				success : function(result){
					alert(result);
					getList();
				}
			});
		}
			
		//댓글 목록
		function getList(){
			$.ajax({
				url : pageContext + "/board/BoardReplyList.bo?boardNum="+boardNum,
				type : "get",
				dataType : "json",
				success : showList
			});
		}
		
		//댓글 보여주기
		function showList(replys){
			//console.log(replys);
			
			var insertReply_HTML = "<tr height='200px'><td align='center' width='80px'><div align='center'>댓 글</div>"
				+"</td><td style='padding-left: 10px;'><textarea name='replyContent' style='height: 85px; width: 750px; resize: none;'></textarea>"
				+"<a href='javascript:insertReply()'>[등록]</a></td></tr>";
				
			var text = insertReply_HTML;
			
			if(replys != null && replys.length != 0){
				//reply : 변수명 
				$.each(replys, function(index, reply){
					//JSON이라서 getMemberId가 아니라 reply.memberId나 reply["memberId"] 
					text += "<tr><td align='center' width='150px;'>"+reply['memberId']+"</td>";
					text += "<td valign='top' style='padding-left: 10px;'>";
					text += "<textarea name='content"+(index+1)+"' id='"+(index+1)+"' class='re' style='height: 85px; width: 750px; resize: none;' readonly>"+reply.replyContent+"</textarea>";
					if("${session_id}" == reply.memberId){
						text += "<a id='ready"+(index+1)+"' href='javascript:updateReply("+(index+1)+")'>[수정]</a>";
						text += "<a id='ok"+(index+1)+"' href='javascript:updateOkReply("+reply.replyNum+", "+(index+1)+")' style='display: none;'>[수정 완료]</a>";
						text += "<a href='javascript:deleteReply("+reply.replyNum+")'>[삭제]</a>";
					}
					text += "</td></tr>";
				});
			}else{
				text += "<tr align='center'><td align='center' width='150px' colspan='2'>댓글이 없습니다.</td></tr>";
			}
			
			$("#replyTable").html(text);
			autosize($("textarea.re"));
			
		}
		
		//댓글 수정
		function updateReply(num){
			if(!check){
				var textarea = $("textarea#"+num);
				var a_ready = $("a#ready"+num);
				var a_ok = $("a#ok"+num);
				
				textarea.removeAttr("readonly");
				a_ready.hide();
				a_ok.show();
				check = true;
			}else{
				alert("수정 중인 댓글이 있습니다.");
			}
		}
		
		//댓글 수정 완료
		function updateOkReply(replyNum, seq){
			var content = $("textarea#"+seq).val();
			
			$.ajax({
				url : pageContext + "/board/BoardReplyModifyOk.bo",
				type : "post",
				data : {"replyNum" : replyNum, "content" : content},
				dataType : "text",
				success : function(result){
					alert(result);
					getList();
					check = false;
				}
			});
		}
		
		
		//댓글 삭제
		function deleteReply(replyNum){
			$.ajax({
				url : pageContext + "/board/BoardReplyDelete.bo?replyNum="+replyNum,
				type : "get",
				dataType : "text",
				success : function(result){
					alert(result);
					getList();
				}
			});
		}
		
		
		
	</script>
	
</html>