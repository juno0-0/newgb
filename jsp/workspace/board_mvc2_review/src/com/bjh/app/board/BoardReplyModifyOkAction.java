package com.bjh.app.board;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjh.action.Action;
import com.bjh.action.ActionForward;
import com.bjh.app.board.dao.BoardDAO;
import com.bjh.app.board.vo.BoardReplyVO;

public class BoardReplyModifyOkAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		BoardReplyVO r_vo = new BoardReplyVO();
		BoardDAO r_dao = new BoardDAO();
		PrintWriter out = resp.getWriter();
		
		int replyNum = Integer.parseInt(req.getParameter("replyNum"));
		String content = req.getParameter("content");
		
		r_vo.setReplyNum(replyNum);
		r_vo.setReplyContent(content);
		
		if(r_dao.updateReply(r_vo)) {
			out.print("수정 성공");
		}else {
			out.print("수정 실패");
		}
		out.close();
		return null;
	}
}
