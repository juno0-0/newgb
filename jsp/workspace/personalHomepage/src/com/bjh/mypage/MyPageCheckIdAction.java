package com.bjh.mypage;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjh.action.Action;
import com.bjh.action.ActionForward;
import com.bjh.mypage.dao.MyPageDAO;

public class MyPageCheckIdAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		MyPageDAO dao = new MyPageDAO();
		
		String id = req.getParameter("id");
		
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		if(dao.checkId(id)) {
			//중복
			out.print("not-ok");
		}else {
			//사용 가능
			out.print("ok");
		}
		
		return null;
	}
}
