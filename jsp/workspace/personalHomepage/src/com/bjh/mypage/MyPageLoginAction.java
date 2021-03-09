package com.bjh.mypage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bjh.action.Action;
import com.bjh.action.ActionForward;
import com.bjh.mypage.dao.MyPageDAO;

public class MyPageLoginAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		ActionForward forward = new ActionForward();
		HttpSession session = req.getSession();
		
		String id = req.getParameter("mypageId");
		String pw = req.getParameter("mypagePw");
		
		MyPageDAO dao = new MyPageDAO();
		if(dao.login(id, pw)) {
			//성공
			session.setAttribute("mypageId", id);
			forward.setRedirect(false);
			forward.setPath("/mypage/MyPageLoginOk.mp");
		}else {
			//실패
			forward.setRedirect(false);
			forward.setPath("/mypage/MyPageLoginFail.mp?check=false");
		}
		return forward;
	}
}
