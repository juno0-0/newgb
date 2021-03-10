package com.bjh.mypage;

import java.io.IOException;
import java.util.List;

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
			try {
				forward = new MyPageLoginAction().execute(req, resp);
			} catch (Exception e) {;}
			
		}else if(command.equals("/mypage/MyPageLoginFail.mp")){
			String check = req.getParameter("check");
			forward = new ActionForward();
			//false로 주고
			forward.setRedirect(true);
			//상대경로로 주면 레이아웃이 깨지고 true주고 절대경로 주면 레이아웃이 안깨짐
			forward.setPath(req.getContextPath()+"/cyan/login.jsp" + (check != null ? "?check=false" : ""));
			
		}else if(command.equals("/mypage/MyPageLoginOk.mp")){
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath(req.getContextPath()+"/cyan/index.jsp");
			
		}else if(command.equals("/mypage/MyPageSMS.mp")){
			try {
				forward = new MyPageSmsAction().execute(req, resp);
			} catch (Exception e) {;}
			
		}else if(command.equals("/mypage/MyPageFindId.mp")){
			try {
				forward = new MyPageFindIdAction().execute(req, resp);
			} catch (Exception e) {;}
			
		}else if(command.equals("/mypage/MyPageFindIdOk.mp")){
			
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/cyan/successId.jsp?check=true");
		}else if(command.equals("/mypage/MyPageFindIdCheck.mp")){
			String check = req.getParameter("check");
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath(req.getContextPath()+"/cyan/findId.jsp"+(check != null ? "?check=false" : ""));
			
		}else if(command.equals("/mypage/MyPageFindPw.mp")){
			try {
				forward = new MyPageFindPwAction().execute(req, resp);
			} catch (Exception e) {;}
			
		}else if(command.equals("/mypage/MyPageFindPwOk.mp")){
			String mypageId = req.getParameter("mypageId");
			forward = new ActionForward();
			forward.setRedirect(true);
			//나중에 session에 넣어서 넘기는걸로 수정
			forward.setPath(req.getContextPath()+"/cyan/changePw.jsp?mypageId="+mypageId);
			
		}else if(command.equals("/mypage/MyPageFindPwNo.mp")){
			String check = req.getParameter("check");
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath(req.getContextPath()+"/cyan/findPw.jsp"+(check != null ? "?check=false" : ""));
			
		}else if(command.equals("/mypage/MyPageChangePw.mp")){
			try {
				forward = new MyPageChangePwAction().execute(req, resp);
			} catch (Exception e) {;}
		}else if(command.equals("/mypage/MyPageChangePwOk.mp")){
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath(req.getContextPath()+"/cyan/index.jsp");
			
		}else if(command.equals("/mypage/MyPageChangePwNo.mp")){
			String mypageId = req.getParameter("mypageId");
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/cyan/changePw.jsp?mypageId="+mypageId);
			
		}else {
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
