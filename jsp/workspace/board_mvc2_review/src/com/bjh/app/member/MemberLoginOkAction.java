package com.bjh.app.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bjh.action.Action;
import com.bjh.action.ActionForward;
import com.bjh.app.member.dao.MemberDAO;

public class MemberLoginOkAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		ActionForward forward = new ActionForward();
		
		String memberId = req.getParameter("memberId");
		String memberPw = req.getParameter("memberPw");
		
		MemberDAO m_dao = new MemberDAO();
		
		if(m_dao.login(memberId, memberPw)) {
			HttpSession session = req.getSession();
			session.setAttribute("session_id", memberId);
			forward.setRedirect(true);
			forward.setPath(req.getContextPath()+"/board/BoardList.bo");
		}else {
			System.out.println("로그인 실패");
			forward.setRedirect(false);
			forward.setPath("/member/MemberLogin.me?check=false");
		}
		
		return forward;
	}
}
