package com.koreait.app.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;
import com.koreait.app.board.dao.BoardDAO;

public class BoardDeleteAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		ActionForward forward = new ActionForward();
		
		BoardDAO b_dao = new BoardDAO();
		
		int boardNum = Integer.parseInt(req.getParameter("boardNum"));
		int page = Integer.parseInt(req.getParameter("page"));
		
		b_dao.deleteBoard(boardNum);
		
		//수정이나 삭제는 redirect로 응답하는게 좋다.
		//req.setAttribute()는 redirect를 사용하면 쓸 수 없기 때문에 get방식으로 전달한다.
		forward.setRedirect(true);
		//여기서 바로 boardList.jsp로 넘어가면 자료를 가져오지 않았기 때문에 글이 없다고 나온다.
		forward.setPath(req.getContextPath()+"/board/BoardList.bo?page="+page);
		
		return forward;
	}
}
