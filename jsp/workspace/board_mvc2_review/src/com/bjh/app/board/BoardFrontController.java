package com.bjh.app.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjh.action.ActionForward;

@SuppressWarnings("serial")
public class BoardFrontController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		ActionForward forward = null;
		
		String uri = req.getRequestURI();
		String contextPath = req.getContextPath();
		String command = uri.substring(contextPath.length());
		
		switch(command) {
			case "/board/BoardList.bo":
				//boardList는 DB에서 데이터를 가져와서 화면에 뿌려야 하기 때문에 바로 컨트롤러로 간다.
				try {
					forward = new BoardListOkAction().execute(req, resp);
				} catch (Exception e) {
					System.out.println("BoardListOkAction");
				}
				break;
			case "/board/BoardWrite.bo":
				req.setAttribute("page", req.getParameter("page"));
				forward = new ActionForward();
				forward.setRedirect(false);
				forward.setPath("/app/board/boardWrite.jsp");
				break;
			case "/board/BoardWriteOk.bo":
				try {
					forward = new BoardWriteOkAction().execute(req, resp);
				} catch (Exception e) {
					System.out.println("BoardWriteOkAction");
				}
				break;
			case "/board/BoardView.bo":
				try {
					forward = new BoardViewAction().execute(req, resp);
				} catch (Exception e) {
					System.out.println("BoardViewAction");
				}
				break;
			case "/board/FileDownload.bo":
				try {
					forward = new FileDownloadAction().execute(req, resp);
				} catch (Exception e) {
					System.out.println("FileDownloadAction");
				}
				break;
			case "/board/BoardDelete.bo":
				try {
					forward = new BoardDeleteAction().execute(req, resp);
				} catch (Exception e) {
					System.out.println("BoardDeleteAction");
				}
				break;
			case "/board/BoardModify.bo":
				try {
					forward = new BoardModifyAction().execute(req, resp);
				} catch (Exception e) {
					System.out.println("BoardModifyAction");
				}
				break;
			case "/board/BoardModifyOk.bo":
				try {
					forward = new BoardModifyOkAction().execute(req, resp);
				} catch (Exception e) {
					System.out.println("BoardModifyOkAction");
				}
				break;
			case "/board/BoardReplyList.bo":
				try {
					forward = new BoardReplyListAction().execute(req, resp);
				} catch (Exception e) {
					System.out.println("BoardReplyListAction");
				}
				break;
			case "/board/BoardReplyOk.bo":
				try {
					forward = new BoardReplyOkAction().execute(req, resp);
				} catch (Exception e) {
					System.out.println("BoardReplyOkAction");
				}
				break;
			case "/board/BoardReplyDelete.bo":
				try {
					forward = new BoardReplyDeleteAction().execute(req, resp);
				} catch (Exception e) {
					System.out.println("BoardReplyDeleteAction");
				}
				break;
			case "/board/BoardReplyModifyOk.bo":
				try {
					forward = new BoardReplyModifyOkAction().execute(req, resp);
				} catch (Exception e) {
					System.out.println("BoardReplyModifyOkAction");
				}
				break;
			default:
				forward = new ActionForward();
				forward.setRedirect(false);
				forward.setPath("/app/error/404.jsp");
				break;
		}
		
		if(forward != null) {
			if(forward.isRedirect()) {
				resp.sendRedirect(forward.getPath());
			}else {
				RequestDispatcher dispatcher = req.getRequestDispatcher(forward.getPath());
				dispatcher.forward(req, resp);
			}
		}
		
	}
	
	
}
