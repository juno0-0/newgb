package com.koreait.app.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;
import com.koreait.app.board.dao.BoardDAO;

public class BoardListOkAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// 필요하지 않아도 일단 쓰고 시작하자
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		BoardDAO b_dao = new BoardDAO();
		ActionForward forward = new ActionForward();
		
		String temp = req.getParameter("page");
		
		//요청한 페이지가 없다면 default로 1페이지를 응답해주고
		//요청한 페이지가 있다면 해당 페이지로 응답해준다.
		int page = temp == null ? 1 : Integer.parseInt(temp);
		
		//한 페이지 당 ?개의 게시글이 보이도록 설정
		//세로
		int boardSize = 10;
		//가로
		int pageSize = 10;
		
		//한 페이지에서 가장 마지막 행 번호
		int endRow = page * boardSize;	// 10 20 30 40 ...
		
		//한 페이지에서 가장 첫번째 행 번호
		int startRow = endRow - (boardSize - 1);	// 1 11 21 31 ...
		
		//페이지 번호(가로)
		//여기서 int startPage = page를 사용하면 startPage가 계속 변화되지만
		//한 페이지에 1~10, 11~20, 21~30 이런식으로 표현하려면 1~10까지는 시작값이 항상 일정해야 하기 때문에
		//아래 식을 사용한다.
		int startPage = ((page - 1) / pageSize) * pageSize  + 1;	// 1 11 21 31 ...
		//					(1 - 1) / 10 = 0(몫)
		//					(2 - 1) / 10 = 0(몫)
		//					(3 - 1) / 10 = 0(몫)
		//					(4 - 1) / 10 = 0(몫)
		//					(5 - 1) / 10 = 0(몫)
		
		int endPage = startPage + (pageSize - 1);	// 10 20 30 40 ...
		
		//게시글의 총 개수
		int totalCnt = b_dao.getBoardCnt();
		
		//게시글이 87개일 경우 endPage를 사용하면 마지막 페이지 번호가 10이 나온다.
		//readEndPage를 사용하면 마지막 페이지가 9가 나온다.
		//totalCnt에서 -1을 하는 이유는 10 20 30 ... 때문이다.
		int realEndPage = (totalCnt - 1) / pageSize + 1;
		
		endPage = endPage > realEndPage ? realEndPage : endPage;

		//request에 담아서 응답한다.
		req.setAttribute("totalCnt", totalCnt);
		req.setAttribute("startPage", startPage);
		req.setAttribute("endPage", endPage);
		req.setAttribute("nowPage", page);
		req.setAttribute("realEndPage", realEndPage);
		req.setAttribute("boardList", b_dao.getBoardList(startRow, endRow));
		
		forward.setRedirect(false);
		forward.setPath("/app/board/boardList.jsp");
		
		return forward;
	}

}

















