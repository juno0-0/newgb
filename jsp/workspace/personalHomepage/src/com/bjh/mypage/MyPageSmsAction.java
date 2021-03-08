package com.bjh.mypage;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjh.action.Action;
import com.bjh.action.ActionForward;
import com.bjh.mypage.dao.MyPageDAO;

public class MyPageSmsAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		MyPageDAO dao = new MyPageDAO();
		
		String mypagePhone = req.getParameter("phone");
		
		String num = dao.sms(mypagePhone);

		ActionForward forward = new ActionForward();
		String contextPath = req.getContextPath();
		forward.setRedirect(false);
		forward.setPath(contextPath+"/cyan/join.jsp?num="+num);
		
		return forward;
	}
}
