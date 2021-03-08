package com.bjh.mypage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjh.action.ActionForward;

public class MyPageFrontController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ActionForward forward = null;
		
		String uri = req.getRequestURI();
		String contextPath = req.getContextPath();
		String command = uri.substring(contextPath.length());
		if(command.equals("/mypage/MyPageCheckIdOk.mp")) {
			try {
				//여기로 안들어오고 else로 빠짐
				forward = new MyPageCheckIdAction().execute(req, resp);
			} catch (Exception e) {;}
		}else if(command.equals("/mypage/MyPageJoin.mp")){
			try {
				forward = new MyPageJoinAction().execute(req, resp);
			} catch (Exception e) {;}
		}else if(command.equals("/mypage/MyPageLogin.mp")){
			System.out.println("회원가입 성공!");
		}else if(command.equals("/mypage/MyPageSMS.mp")){
			try {
				forward = new MyPageSmsAction().execute(req, resp);
			} catch (Exception e) {;}
		}else {
			System.out.println("여기는 else");
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/cyan/error/404.jsp");
		}
		
		if(forward != null) {
			if(forward.isRedirect()) {
				resp.sendRedirect(forward.getPath());
			}else {
				RequestDispatcher rd = req.getRequestDispatcher(forward.getPath());
				rd.forward(req, resp);
			}
		}
	}
	
}
