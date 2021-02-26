<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean class="com.koreait.beans.TABLE_MEMBER_DAO" id="dao" />
<!-- 외부에서 전달받은 사용자가 입력한 ID값을 DB에서 조회한다. -->
<!-- Ajax로 통신할 때 responseText를 사용하면 태그까지 가져온다. -->
<!-- 따라서 태그는 모두 지워주고 필요한 데이터만 out객체를 사용하여 출력해준다. -->
	<%
		//TABLE_MEMBER_DAO에 있는 checkID()함수의 리턴 값에 따라서
		//true라면 "중복된 아이디" body에 출력
		//false라면 "사용가능한 아이디" body에 출력
		String id = request.getParameter("id");
		if(!dao.check(id)){
			//중복된 아이디가 없다면 ok 출력
			out.println("ok");
		}else{
			//중복된 아이디가 있다면 not-ok 출력
			out.println("not-ok");
		}
	%>