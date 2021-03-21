package com.bjh.app.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjh.action.Action;
import com.bjh.action.ActionForward;
import com.bjh.app.board.dao.BoardDAO;
import com.bjh.app.board.dao.FilesDAO;
import com.bjh.app.board.vo.BoardVO;
import com.bjh.app.board.vo.FilesVO;

public class BoardViewAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		BoardDAO b_dao = new BoardDAO();
		BoardVO b_vo = new BoardVO();
		FilesDAO f_dao = new FilesDAO();
		ActionForward forward = new ActionForward();
		
		int boardNum = Integer.parseInt(req.getParameter("boardNum"));
		int page = Integer.parseInt(req.getParameter("page"));
		
		b_vo = b_dao.getDetail(boardNum);
		List<FilesVO> fileList = f_dao.getFileList(boardNum);
		b_dao.updateReadCount(boardNum);
		req.setAttribute("b_vo", b_vo);
		req.setAttribute("page", page);
		if(fileList != null) {
			req.setAttribute("fileList", fileList);
		}
		
		forward.setRedirect(false);
		forward.setPath("/app/board/boardView.jsp");
		
		return forward;
	}
}
