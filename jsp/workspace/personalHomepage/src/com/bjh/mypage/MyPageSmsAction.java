package com.bjh.mypage;


import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjh.action.Action;
import com.bjh.action.ActionForward;
import com.bjh.mypage.dao.MyPageDAO;

public class MyPageSmsAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		System.out.println("Controller");
		MyPageDAO dao = new MyPageDAO();
		
		String mypagePhone = req.getParameter("phone");
		
		String num = dao.sms(mypagePhone);
		
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.println(num);
		out.close();
		
		return null;
	}
}
