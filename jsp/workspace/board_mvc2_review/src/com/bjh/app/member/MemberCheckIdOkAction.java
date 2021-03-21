package com.bjh.app.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjh.action.Action;
import com.bjh.action.ActionForward;
import com.bjh.app.member.dao.MemberDAO;

public class MemberCheckIdOkAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		String memberId = req.getParameter("id");
		System.out.println("id : "+memberId);
		MemberDAO m_dao = new MemberDAO();
		PrintWriter out = resp.getWriter();
		
		if(m_dao.checkId(memberId)) {
			out.print("not-ok");
		}else {
			out.print("ok");
		}
		out.close();
		
		return null;
	}
}
