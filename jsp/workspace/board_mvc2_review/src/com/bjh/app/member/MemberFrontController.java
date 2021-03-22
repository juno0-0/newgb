package com.bjh.app.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjh.action.ActionForward;

@SuppressWarnings("serial")
public class MemberFrontController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String requestURI = req.getRequestURI();
		String contextPath = req.getContextPath();
		String command = requestURI.substring(contextPath.length());
		
		ActionForward forward = null;
		// switch문으로 분기처리
		switch(command) {
			//단순 페이지 이동이면 그냥 이름
			//연산이 필요하면 Ok
			case "/member/MemberJoinOk.me":
				try {
					forward = new MemberJoinOkAction().execute(req, resp);
				} catch (Exception e) {
					System.out.println("MemberJoinOkAction");
				}
				break;
			case "/member/MemberJoin.me":
				forward = new ActionForward();
				forward.setRedirect(false);
				forward.setPath("/app/member/joinForm.jsp");
				break;
			case "/member/MemberCheckIdOk.me":
				try {
					forward = new MemberCheckIdOkAction().execute(req, resp);
				} catch (Exception e) {
					System.out.println("MemberCheckIdOkAction");
				}
				break;
			case "/member/MemberLogin.me":
				String check = req.getParameter("check");
				forward = new ActionForward();
				forward.setRedirect(false);
				forward.setPath("/app/member/loginForm.jsp"+ (check != null ? "?check=false" : ""));
				break;
			case "/member/MemberLoginOk.me":
				try {
					forward = new MemberLoginOkAction().execute(req, resp);
				} catch (Exception e) {
					System.out.println("MemberLoginOkAction");
				}
				break;
			case "/member/MemberLogout.me":
				try {
					forward = new MemberLogoutAction().execute(req, resp);
				} catch (Exception e) {
					System.out.println("MemberLogoutAction");
				}
				break;
			default:
				forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath("/app/error/404.jsp");
				break;
		}
		
		// 일괄처리
		if(forward != null) {
			if(forward.isRedirect()) {
				resp.sendRedirect(forward.getPath());
			}else {
				RequestDispatcher dispatcher = req.getRequestDispatcher(forward.getPath());
				dispatcher.forward(req, resp);
			}
		}
	}
}
