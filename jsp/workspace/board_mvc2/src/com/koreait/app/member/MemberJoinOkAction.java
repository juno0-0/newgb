package com.koreait.app.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;
import com.koreait.app.member.dao.MemberDAO;
import com.koreait.app.member.vo.MemberVO;

import sun.security.provider.certpath.ResponderId;


//Controller
public class MemberJoinOkAction implements Action{
	//Ok가 붙는건 연산이 필요한것, 없는건 단순 페이지 이동
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		//전송할 데이터 인코딩 설정
		req.setCharacterEncoding("UTF-8");
		
		ActionForward forward = null;
		
		MemberVO m_vo = new MemberVO();
		MemberDAO m_dao = new MemberDAO();
		
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
			//응답할 페이지 타입을 설정
			resp.setContentType("text/html; charset=UTF-8");
			//<body>태그에 출력
			out.print("<script>alert('서버가 불안정합니다. 잠시 후 다시 시도해주세요.');</script>");
			//buffer가 비워지지 않았을 수도 있으니 close() 사용
			out.close();
		}else {
			forward = new ActionForward();
			
			//true면 Redirect, false면 Forward
			forward.setRedirect(false);
			forward.setPath("/member/MemberLogin.me");
			//Front-Controller에서 Forward 방식으로 /member/MemberLogin.me로 전달한다.
		}
		//alert창 띄우고 페이지이동 : 오류, 절대 불가능
		//alert창 띄우는 것도 응답이고 페이지이동도 응답이라 응답을 2번 하게 되는 것
		//컨트롤러에서 응답은 반드시 한 번만 가능하다.
		//alert창을 띄우고 싶으면 페이지 이동을 한 뒤 이동한 페이지에서 띄운다.
		
		return forward;
	}
}