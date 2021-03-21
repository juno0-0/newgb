package com.bjh.app.board;

import java.io.File;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.bjh.action.Action;
import com.bjh.action.ActionForward;
import com.bjh.app.board.dao.BoardDAO;
import com.bjh.app.board.dao.FilesDAO;
import com.bjh.app.board.vo.BoardVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;

public class BoardWriteOkAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		BoardVO b_vo = new BoardVO();
		BoardDAO b_dao = new BoardDAO();
		FilesDAO f_dao = new FilesDAO();
		ActionForward forward = new ActionForward();
		
		String saveFolder = "C:\\0900_gb_bjh\\jsp\\workspace\\board_mvc2_review\\WebContent\\app\\upload";
		
		int fileSize = 1024 * 1024 * 5;
		
		MultipartRequest multi = null;
		
		multi = new MultipartRequest(req, saveFolder, fileSize, "UTF-8", new DefaultFileRenamePolicy());
		
		b_vo.setBoardTitle(multi.getParameter("boardTitle"));
		b_vo.setBoardContent(multi.getParameter("boardContent"));
		b_vo.setBoardId(multi.getParameter("boardId"));
		
		if(b_dao.insertBoard(b_vo)) {
			if(f_dao.insertFile(b_dao.getBoardNum(), multi)) {
				forward.setRedirect(true);
				forward.setPath(req.getContextPath()+"/board/BoardList.bo");
			}
		}
		
		return forward;
	}
	
}
