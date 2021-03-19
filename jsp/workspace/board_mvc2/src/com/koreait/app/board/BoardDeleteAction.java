package com.koreait.app.board;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;
import com.koreait.app.board.dao.BoardDAO;
import com.koreait.app.board.dao.FilesDAO;
import com.koreait.app.board.vo.FilesVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class BoardDeleteAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		ActionForward forward = new ActionForward();
		
		//리눅스 서버로 서비스 제공 시 업로드 경로는 아래와 같이 사용하여 작업한다.
		//req.getServletContext().getRealPath("/") : 루트패스
		//String saveFolder = req.getServletContext().getRealPath("/")+"/upload";
		
		BoardDAO b_dao = new BoardDAO();
		FilesDAO f_dao = new FilesDAO();
		
		//form태그에서 enctype을 multipart/form-data를 썼기 때문에 MultipartRequest로 받는다.
		MultipartRequest multi = null;
		
		String saveFolder = "D:\\0900_gb_bjh\\jsp\\workspace\\board_mvc2\\WebContent\\app\\upload";
		int fileSize = 5 * 1024 * 1024;
		
		multi = new MultipartRequest(req, saveFolder, fileSize, "UTF-8", new DefaultFileRenamePolicy());
		
		int boardNum = Integer.parseInt(multi.getParameter("boardNum"));
		int page = Integer.parseInt(multi.getParameter("page"));
		
		//지금의 경우 DB를 먼저 삭제하면 getFileList(boardNum)을 찾을 수 없기 때문에 업로드 폴더에 있는 파일부터 삭제한다.
		//업로드 폴더에 파일 삭제
		for(FilesVO file : f_dao.getFileList(boardNum)) {
			File f = new File(saveFolder, file.getFileName());
			if(f.exists()) {//경로에 파일이 존재하는지 확인한다.
				f.delete();
			}
		}
		
		//DB 파일 삭제
		f_dao.deleteFile(boardNum);
		
		//게시글 삭제
		b_dao.deleteBoard(boardNum);
		
		//수정이나 삭제는 redirect로 응답하는게 좋다.
		//req.setAttribute()는 redirect를 사용하면 쓸 수 없기 때문에 get방식으로 전달한다.
		forward.setRedirect(true);
		//여기서 바로 boardList.jsp로 넘어가면 자료를 가져오지 않았기 때문에 글이 없다고 나온다.
		forward.setPath(req.getContextPath()+"/board/BoardList.bo?page="+page);
		
		return forward;
	}
}
