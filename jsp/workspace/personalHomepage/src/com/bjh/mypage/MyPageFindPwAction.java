package com.bjh.mypage;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjh.action.Action;
import com.bjh.action.ActionForward;
import com.bjh.mypage.dao.MyPageDAO;

public class MyPageFindPwAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		ActionForward forward = new ActionForward();
		
		String mypageId = req.getParameter("mypageId");
		String mypagePhone = req.getParameter("mypagePhone");
		
		MyPageDAO dao = new MyPageDAO();
		if(dao.findPw(mypageId, mypagePhone)) {
			forward.setRedirect(false);
			forward.setPath("/mypage/MyPageFindPwOk.mp?mypageId="+mypageId);
		}else {
			forward.setRedirect(false);
			forward.setPath("/mypage/MyPageFindPwNo.mp?check=false");
		}
		return forward;
	}
}
