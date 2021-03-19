package com.bjh.app.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjh.action.Action;
import com.bjh.action.ActionForward;
import com.bjh.app.member.dao.MemberDAO;
import com.bjh.app.member.vo.MemberVO;

public class MemberJoinOkAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		ActionForward forward = null;
		
		MemberDAO m_dao = new MemberDAO();
		MemberVO m_vo = new MemberVO();
		
		m_vo.setMemberId(req.getParameter("memberId"));
		m_vo.setMemberPw(req.getParameter("memberPw"));
		m_vo.setMemberName(req.getParameter("memberName"));
		m_vo.setMemberAge(req.getParameter("memberAge"));
		m_vo.setMemberGender(req.getParameter("memberGender"));
		m_vo.setMemberEmail(req.getParameter("memberEmail"));
		m_vo.setMemberZipcode(req.getParameter("memberZipcode"));
		m_vo.setMemberAddress(req.getParameter("memberAddress"));
		m_vo.setMemberAddressDetail(req.getParameter("memberAddressDetail"));
		m_vo.setMemberAddressEtc(req.getParameter("memberAddressEtc"));
		
		if(!m_dao.join(m_vo)) {
			PrintWriter out = resp.getWriter();
			resp.setCharacterEncoding("UTF-8");
			out.print("<script>alert('서버가 불안정합니다.')</script>");
			out.close();
		}else {
			forward = new ActionForward();
			
			forward.setRedirect(false);
			forward.setPath("/member/MemberLogin.me");
		}
		
		return forward;
	}
}
