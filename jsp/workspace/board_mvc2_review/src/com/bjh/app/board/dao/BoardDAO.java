package com.bjh.app.board.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.bjh.app.board.vo.BoardReplyVO;
import com.bjh.app.board.vo.BoardVO;
import com.bjh.app.mybatis.config.SqlMapConfig;

public class BoardDAO {
	SqlSessionFactory session_f = SqlMapConfig.getSqlMapInstance();
	SqlSession session;
	
	public BoardDAO() {
		session = session_f.openSession(true);
	}
	
	//게시글 총 개수
	public int getBoardCnt() {
		return session.selectOne("Board.boardCnt");
	}
	
	//startRow부터 endRow까지 가져오는 메소드
	public List<BoardVO> listAll(int startRow, int endRow) {
		HashMap<String, Integer> map = new HashMap<>();
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		
		return session.selectList("Board.listAll", map);
	}
	
	//조회수 증가
	public void updateReadCount(int boardNum) {
		session.update("Board.updateReadCount", boardNum);
	}
	
	//게시글 등록
	public boolean insertBoard(BoardVO vo) {
		return session.insert("Board.insertBoard", vo) == 1;
	}
	
	//현재 시퀀스 번호 가져오기
	public int getBoardNum() {
		return session.selectOne("Board.getBoardNum");
	}
	
	//게시글 상세보기
	public BoardVO getDetail(int boardNum) {
		return session.selectOne("Board.getDetail", boardNum);
	}
	
	//게시글 삭제하기
	public boolean deleteBoard(int boardNum) {
		return session.delete("Board.deleteBoard", boardNum) == 1;
	}
	
	//게시글 수정하기
	public boolean updateBoard(BoardVO vo) {
		return session.update("Board.updateBoard", vo) == 1;
	}
	
	//댓글 불러오기
	public List<BoardReplyVO> getReplyList(int boardNum){
		return session.selectList("Board.replyList", boardNum);
	}
	
	//댓글 추가하기
	public boolean insertReply(BoardReplyVO vo) {
		return session.insert("Board.insertReply", vo) == 1;
	}
	
	//댓글 삭제하기
	public boolean deleteReply(int replyNum) {
		return session.delete("Board.deleteReply", replyNum) == 1;
	}
	
	//댓글 수정하기
	public boolean updateReply(BoardReplyVO vo) {
		return session.update("Board.updateReply", vo) == 1;
	}
}
