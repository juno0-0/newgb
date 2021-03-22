package com.bjh.app.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjh.action.Action;
import com.bjh.action.ActionForward;
import com.bjh.app.board.dao.BoardDAO;

public class BoardModifyAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		BoardDAO b_dao = new BoardDAO();
		ActionForward forward = new ActionForward();
		
		int page = Integer.parseInt(req.getParameter("page"));
		int boardNum = Integer.parseInt(req.getParameter("boardNum"));
		
		req.setAttribute("page", page);
		req.setAttribute("b_vo", b_dao.getDetail(boardNum));
		
		forward.setRedirect(false);
		forward.setPath("/app/board/boardModify.jsp");
		
		return forward;
	}
}
