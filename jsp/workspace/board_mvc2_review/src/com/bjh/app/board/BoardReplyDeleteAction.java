package com.bjh.app.board;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjh.action.Action;
import com.bjh.action.ActionForward;
import com.bjh.app.board.dao.BoardDAO;

public class BoardReplyDeleteAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		int replyNum = Integer.parseInt(req.getParameter("replyNum"));
		
		BoardDAO r_dao = new BoardDAO();
		PrintWriter out = resp.getWriter();
		
		if(r_dao.deleteReply(replyNum)) {
			out.print("삭제 성공");
		}else {
			out.print("삭제 실패");
		}
		out.close();
		return null;
	}
}
