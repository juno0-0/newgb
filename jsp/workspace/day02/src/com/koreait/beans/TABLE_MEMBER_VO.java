package com.koreait.beans;

public class TABLE_MEMBER_VO {
	private int num;
	private String id;
	
	public TABLE_MEMBER_VO() {
		this.id = "입력된 ID가 없습니다.";
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
