package com.bjh.app.board;

import java.io.File;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjh.action.Action;
import com.bjh.action.ActionForward;
import com.bjh.app.board.dao.BoardDAO;
import com.bjh.app.board.dao.FilesDAO;
import com.bjh.app.board.vo.BoardVO;
import com.bjh.app.board.vo.FilesVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class BoardModifyOkAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		String saveFolder = "C:\\0900_gb_bjh\\jsp\\workspace\\board_mvc2_review\\WebContent\\app\\upload";
		int fileSize = 1024 * 1024 * 5;
		ActionForward forward = new ActionForward();
		
		try {
			MultipartRequest multi = null;
			multi = new MultipartRequest(req, saveFolder, fileSize, "UTF-8", new DefaultFileRenamePolicy());
			
			BoardVO b_vo = new BoardVO();
			BoardDAO b_dao = new BoardDAO();
			FilesDAO f_dao = new FilesDAO();
			
			int boardNum = Integer.parseInt(multi.getParameter("boardNum"));
			int page = Integer.parseInt(multi.getParameter("page"));
			String boardTitle = multi.getParameter("boardTitle");
			String boardContent = multi.getParameter("boardContent");
			
			for(FilesVO f_vo : f_dao.getFileList(boardNum)) {
				File file = new File(saveFolder, f_vo.getFileName());
				if(file.exists()) {
					file.delete();
				}
			}
			
			f_dao.deleteFile(boardNum);
			
			f_dao.insertFile(boardNum, multi);
			
			b_vo.setBoardNum(boardNum);
			b_vo.setBoardTitle(boardTitle);
			b_vo.setBoardContent(boardContent);
			b_dao.updateBoard(b_vo);

			forward.setRedirect(true);
			forward.setPath(req.getContextPath()+"/board/BoardList.bo?boardNum="+boardNum+"&page="+page);
		} catch (Exception e) {
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter out = resp.getWriter();
			out.println("<script>");
			out.println("alert('게시글 수정 실패. 다시 시도해주세요.')");
			out.println("history.back()");
			out.println("</script>");
			out.close();
			return null;
		}
		
		return forward;
	}
}
