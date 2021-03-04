package com.koreait.app.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.action.ActionForward;

public class MemberFrontController extends HttpServlet {
   /**
    * JVM의 메모리에서만 머물러 있던 객체를 시스템이 종료되거나 네트워크로 통신을 할 때에도 그대로 사용할 수 있도록
    * 영구화 목적으로 직렬화를 사용한다.
    * 직렬화 된 객체는 byte형태로 변환되어 있으며, 다시 사용하고 싶을 때에는 역직렬화를 통해서 객체로 변환된다.
    * 이 때 SUID(serialVersionUID)라는 값을 고정시켜 구분점으로 사용해서 사용자가 원하는 객체가 맞는 지 판단하게 된다.
    * 자주 변경되는 클래스 객체에는 사용하지 않는 것이 좋다.
    */
   private static final long serialVersionUID = 1L;
   //GET방식이나 POST방식으로 들어와도 실행되는건 같기 때문에 doProcess를 만들고 그걸 사용한다.
   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      doProcess(req, resp);
   }
   
   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      doProcess(req, resp);
   }
   
   protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	  //URI를 얻어온다.
      String requestURI = req.getRequestURI();
      //절대경로를 얻어온다(www.naver.com 같은거)
      String contextPath = req.getContextPath();
      //URI에서 절대경로를 제외한 나머지를 얻어온다.
      //ex) www.naver.com【/news】이 부분을 얻어오는 것
      String command = requestURI.substring(contextPath.length());
      
      //전송방식과 경로를 가지고 있는 객체
      ActionForward forward = null;
      
      //절대경로를 제외한 나머지 URI를 분기한다.
      if(command.equals("/member/MemberJoin.me")) {
         try {
        	//MemberJoinOkAction이라는 Controller에 선언한 리턴타입이 ActionForward인 execute(rep, resq)를 실행한다. 
            forward = new MemberJoinOkAction().execute(req, resp);
         } catch (Exception e) {;}
      }else if(command.equals("/member/MemberCheckIdOk.me")) {
         try {
       	    //MemberCheckIdOkAction이라는 Controller에 선언한 리턴타입이 ActionForward인 execute(rep, resq)를 실행한다. 
            forward = new MemberCheckIdOkAction().execute(req, resp);
         } catch (Exception e) {;}
      }else {
         forward = new ActionForward();
         forward.setRedirect(false);
         forward.setPath("/app/error/404.jsp");
      }
      
      if(forward != null) {
         if(forward.isRedirect()) {
        	//전송 방식이 Redirect일 경우
            resp.sendRedirect(forward.getPath());
         }else {
        	//전송 방식이 Forward일 경우
            RequestDispatcher dispatcher = req.getRequestDispatcher(forward.getPath());
            dispatcher.forward(req, resp);
         }
      }
   }
}