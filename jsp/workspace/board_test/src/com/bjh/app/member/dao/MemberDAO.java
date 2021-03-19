package com.bjh.app.member.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.bjh.app.member.vo.MemberVO;
import com.bjh.mybatis.config.SqlMapConfig;

public class MemberDAO {
	private static final int KEY = 3;
	
	SqlSessionFactory sessionf = SqlMapConfig.getSqlMapInstance();
	SqlSession session;
	
	public MemberDAO() {
		session = sessionf.openSession(true);
	}
	
	//암호화
	public String encrypt(String memberPw) {
		String en_pw = "";
		for (int i = 0; i < memberPw.length(); i++) {
			en_pw += (char)(memberPw.charAt(i) * KEY);
		}
		return en_pw;
	}
	//복호화
	public String decrypt(String en_pw) {
		String de_pw = "";
		for (int i = 0; i < en_pw.length(); i++) {
			de_pw += (char)(en_pw.charAt(i) * KEY);
		}
		return de_pw;
	}
	
	//회원가입
	/**
	 * 
	 * @param member
	 * @return
	 * 
	 * true : 회원가입 성공<br>false : 회원가입 실패
	 */
	public boolean join(MemberVO member) {
		return session.insert("Member.join", member) == 1;
	}
	
}
