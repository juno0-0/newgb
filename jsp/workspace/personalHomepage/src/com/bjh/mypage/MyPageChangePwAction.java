package com.bjh.mypage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjh.action.Action;
import com.bjh.action.ActionForward;
import com.bjh.mypage.dao.MyPageDAO;

public class MyPageChangePwAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		ActionForward forward = new ActionForward();
		
		String newMypagePw = req.getParameter("newMypagePw");
		String mypageId = req.getParameter("mypageId");
		
		MyPageDAO dao = new MyPageDAO();
		if(dao.changePw(newMypagePw, mypageId)) {
			forward.setRedirect(false);
			forward.setPath("/mypage/MyPageChangePwOk.mp");
			
		}else {
			forward.setRedirect(false);
			forward.setPath("/mypage/MyPageChangePwNo.mp?mypageId="+mypageId);
		}
		
		return forward;
	}
}
