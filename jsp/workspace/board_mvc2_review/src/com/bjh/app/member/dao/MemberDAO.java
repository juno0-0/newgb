package com.bjh.app.member.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.bjh.app.member.vo.MemberVO;
import com.bjh.app.mybatis.config.SqlMapConfig;

public class MemberDAO {
	SqlSessionFactory session_f = SqlMapConfig.getSqlMapInstance();
	SqlSession session;
	
	public MemberDAO() {
		session = session_f.openSession(true);
	}
	
	/**
	 * 
	 * @param member
	 * @return
	 * 
	 * true면 가입 성공<br>false면 가입 실패
	 */
	public boolean join(MemberVO member) {
		return session.insert("Member.join", member) == 1;
	}
	
	/**
	 * 
	 * @param memberId
	 * @return
	 * 
	 * true면 중복<br>false면 사용 가능
	 * 
	 */
	public boolean checkId(String memberId) {
		System.out.println(memberId);
		return (Integer)session.selectOne("Member.checkId", memberId) == 1;
	}
	
	/**
	 * 
	 * @param memberId
	 * @param memberPw
	 * @return
	 * 
	 * true면 로그인 성공<br> false면 로그인 실패
	 * 
	 */
	public boolean login(String memberId, String memberPw) {
		HashMap<String, String> map = new HashMap<>();
		map.put("memberId", memberId);
		map.put("memberPw", memberPw);
		return (Integer)session.selectOne("Member.login", map) == 1;
	}
}
