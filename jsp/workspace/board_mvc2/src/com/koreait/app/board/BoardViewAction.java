package com.koreait.app.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;
import com.koreait.app.board.dao.BoardDAO;
import com.koreait.app.board.dao.FilesDAO;
import com.koreait.app.board.vo.BoardReplyVO;
import com.koreait.app.board.vo.BoardVO;
import com.koreait.app.board.vo.FilesVO;

public class BoardViewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		
		BoardDAO b_dao = new BoardDAO();
		BoardVO b_vo = null;
		BoardDAO r_dao = new BoardDAO();
		FilesDAO f_dao = new FilesDAO();
		
		ActionForward forward = null;
		
		int boardNum = Integer.parseInt(req.getParameter("boardNum"));
		int page = Integer.parseInt(req.getParameter("page"));
		
		//TABLE_BOARD에서 boardNum이 들어있는 행의 데이터
		b_vo = b_dao.getDetail(boardNum);
		//TABLE_FILES에서 boardNum이 들어있는 행의 데이터
		List<FilesVO> fileList = f_dao.getFileList(boardNum);
		//TABLE_REPLY에서 boardNum이 들어있는 행의 데이터
		List<BoardReplyVO> replyList = r_dao.getReplyList(boardNum);
		
		if(b_vo != null) {
			//조회수가 1씩 증가하는 메소드
			b_dao.updateReadCount(boardNum);
			//requestScope에 등록하기
			req.setAttribute("replies", replyList);
			req.setAttribute("b_vo", b_vo);
			req.setAttribute("page", page);
			if(fileList != null) {
				req.setAttribute("files", fileList);
			}
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/app/board/boardView.jsp");
		}
		return forward;
	}
}