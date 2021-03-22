package com.bjh.app.board;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bjh.action.Action;
import com.bjh.action.ActionForward;
import com.bjh.app.board.dao.BoardDAO;
import com.bjh.app.board.vo.BoardReplyVO;

public class BoardReplyOkAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		HttpSession session = req.getSession();
		
		BoardReplyVO r_vo = new BoardReplyVO();
		BoardDAO r_dao = new BoardDAO();
		PrintWriter out = resp.getWriter();
		
		String replyContent = req.getParameter("content");
		int boardNum = Integer.parseInt(req.getParameter("boardNum"));
		String memberId = (String)session.getAttribute("session_id");
		
		r_vo.setReplyContent(replyContent);
		r_vo.setBoardNum(boardNum);
		r_vo.setMemberId(memberId);
		
		if(r_dao.insertReply(r_vo)) {
			out.print("추가 성공");
		}else {
			out.print("추가 실패");
		}
		out.close();
		return null;
	}
}
