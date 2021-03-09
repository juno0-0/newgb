package com.bjh.mypage;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjh.action.Action;
import com.bjh.action.ActionForward;
import com.bjh.mypage.dao.MyPageDAO;

public class MyPageFindIdAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		ActionForward forward = new ActionForward();
		
		MyPageDAO dao = new MyPageDAO();
		
		String mypagePhone = req.getParameter("mypagePhone");
		List<String> list = dao.findId(mypagePhone);
		if(!list.isEmpty()) {
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter out = resp.getWriter();
			for (int i = 0; i < list.size(); i++) {
				out.print(list.get(i));			
			}
			req.setAttribute("list", list);
			forward.setRedirect(false);
			forward.setPath("/mypage/MyPageFindIdOk.mp");
		}else {
			forward.setRedirect(false);
			forward.setPath("/mypage/MyPageFindIdCheck.mp?check=false");
		}
		
		
		
		
		
		return forward;
	}
}
