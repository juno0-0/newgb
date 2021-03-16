package com.koreait.app.board.vo;

public class BoardReplyVO {
	private int replyNum;
	private int boardNum;
	private String memberId;
	private String replyContent;
	
	public BoardReplyVO() {;}

	public final int getReplyNum() {
		return replyNum;
	}

	public final void setReplyNum(int replyNum) {
		this.replyNum = replyNum;
	}

	public final int getBoardNum() {
		return boardNum;
	}

	public final void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}

	public final String getMemberId() {
		return memberId;
	}

	public final void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public final String getReplyContent() {
		return replyContent;
	}

	public final void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
}
