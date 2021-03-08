package com.bjh.mypage;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjh.action.Action;
import com.bjh.action.ActionForward;
import com.bjh.mypage.dao.MyPageDAO;
import com.bjh.mypage.vo.MyPageVO;

public class MyPageJoinAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		ActionForward forward = null;
		MyPageVO vo = new MyPageVO();
		vo.setMypageId(req.getParameter("mypageId"));
		vo.setMypagePw(req.getParameter("mypagePw"));
		vo.setMypageName(req.getParameter("mypageName"));
		vo.setMypagePhone(req.getParameter("mypagePhone"));
		vo.setMypageEmail(req.getParameter("mypageEmail")+req.getParameter("category"));
		vo.setMypageAddress(req.getParameter("mypageAddress"));
		
		MyPageDAO dao = new MyPageDAO();
		//dao.join(vo)가 문제라서 출력도 안되고 DB에 insert가 안된다.
		if(dao.join(vo)) {
			//성공
			System.out.println("성공");
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/mypage/MyPageLogin.mp");
		}else {
			//실패
			System.out.println("실패");
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter out = resp.getWriter();
			out.print("<script>alert('서버가 불안정합니다. 다시 시도해주세요.')</script>");
			out.close();
		}
		
		return forward;
	}
}
