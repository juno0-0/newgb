package com.koreait.app.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;
import com.koreait.app.member.dao.MemberDAO;

//컨트롤러
public class MemberCheckIdOkAction implements Action{

   @Override
   public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
	  //요청할 데이터 문자셋 타입 인코딩
      req.setCharacterEncoding("UTF-8");
      
      //사용자가 입력한 id 받아오기
      String id = req.getParameter("id");
      MemberDAO m_dao = new MemberDAO();
      
      //JSP페이지 <body>에 출력할 정보를 저장 
      PrintWriter out = resp.getWriter();
      
      //응답할 페이지 타입 설정
      resp.setContentType("text/html;charset=utf-8");
      
      //DAO의 checkId() 실행
      //회원가입에 실패하면 true, 성공하면 false
      if(m_dao.checkId(id)) {
         //not-ok
         out.println("not-ok");
      }else {
         //ok
         out.println("ok");
      }
      out.close();
      //페이지 이동을 하지 않을 것이라서 null을 리턴
      return null;
   }

}