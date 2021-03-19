package com.bjh.mypage;

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
	
		//1,2,3만 무한반복 되다 
		for (int i = 0; i < list.size(); i++) {
			String temp = list.get(i);
			String temp2 = "";
			for (int j = 0; j < temp.length(); j++) {
				if(j > 3) {
					temp2 += "*";
					continue;
				}
				temp2 += temp.charAt(j);
			}
			list.set(i, temp2);
		}
		
		if(!list.isEmpty()) {
			resp.setContentType("text/html; charset=UTF-8");
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
