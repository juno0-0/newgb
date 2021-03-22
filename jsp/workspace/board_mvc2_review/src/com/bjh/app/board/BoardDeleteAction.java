package com.bjh.app.board;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjh.action.Action;
import com.bjh.action.ActionForward;
import com.bjh.app.board.dao.BoardDAO;
import com.bjh.app.board.dao.FilesDAO;
import com.bjh.app.board.vo.FilesVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class BoardDeleteAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		String saveFolder = "C:\\0900_gb_bjh\\jsp\\workspace\\board_mvc2_review\\WebContent\\app\\upload"; 
		int fileSize = 1024 * 1042 * 5;
		BoardDAO b_dao = new BoardDAO();
		FilesDAO f_dao = new FilesDAO();
		ActionForward forward = new ActionForward();
		MultipartRequest multi;
		
		multi = new MultipartRequest(req, saveFolder, fileSize, "UTF-8", new DefaultFileRenamePolicy());
		
		int boardNum = Integer.parseInt(multi.getParameter("boardNum"));
		int page = Integer.parseInt(multi.getParameter("page"));
		
		for(FilesVO f_vo : f_dao.getFileList(boardNum)) {
			File file = new File(saveFolder, f_vo.getFileName());
			if(file.exists()) {
				file.delete();
			}
		}
		
		f_dao.deleteFile(boardNum);
		b_dao.deleteBoard(boardNum);
		
		forward.setRedirect(true);
		forward.setPath(req.getContextPath()+"/board/BoardList.bo?page="+page);
		
		return forward;
	}
}
