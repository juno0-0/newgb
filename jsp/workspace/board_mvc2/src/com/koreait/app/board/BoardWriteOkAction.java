package com.koreait.app.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;
import com.koreait.app.board.dao.BoardDAO;
import com.koreait.app.board.dao.FilesDAO;
import com.koreait.app.board.vo.BoardVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class BoardWriteOkAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		BoardVO b_vo = new BoardVO();
		BoardDAO b_dao = new BoardDAO();
		FilesDAO f_dao = new FilesDAO();
		ActionForward forward = null;

		//첨부파일이 저장될 경로(반드시 절대경로)
		String saveFolder = "D:\\0900_gb_bjh\\jsp\\workspace\\board_mvc2\\WebContent\\app\\upload";
		
		int fileSize = 5 * 1024 * 1024;//5M, 파일의 최소단위는 byte
		
		//cos.jar를 추가해야 사용할 수 있다.
		MultipartRequest multi = null;
		
		//request, 저장 경로, 저장될 최대 용량, encoding, 정책
		//DefaultFileRenamePolicy : 파일 업로드 및 다운로드 정책(같은 이름이 존재하면 자동으로 이름이 변경되도록 한다.)
		multi = new MultipartRequest(req, saveFolder, fileSize, "UTF-8", new DefaultFileRenamePolicy());
		
		b_vo.setBoardTitle(multi.getParameter("boardTitle"));
		b_vo.setBoardId(multi.getParameter("boardId"));
		b_vo.setBoardContent(multi.getParameter("boardContent"));
		
		//게시글이 첨부파일의 부모(게시글의 boardNum이 첨부파일의 PK)
		if(b_dao.insertBoard(b_vo)) {
			if(f_dao.insertFiles(b_dao.getBoardNum(), multi)) {
				//첨부파일 추가
				forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath(req.getContextPath() + "/board/BoardList.bo");
			}
		}
		return forward;
	}
}