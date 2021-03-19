package com.koreait.beans;

public class MemberVO {
//	CREATE TABLE TBL_MEMBER(
//			NUM NUMBER NOT NULL,
//			NAME VARCHAR2(200),
//			BIRTHDAY DATE,
//			CONSTRAINT MEMBER_PK PRIMARY KEY(NUM)
//	);
	
	private int num;
	private String name;
	private String birthday;
	
	public MemberVO() {
		//초기값 설정하기
		this.name = "이름이 없습니다.";
		this.birthday = "생일이 등록되지 않았습니다.";
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	
}
