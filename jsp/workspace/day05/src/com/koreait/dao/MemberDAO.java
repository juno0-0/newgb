package com.koreait.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.koreait.mybatis.config.SqlMapConfig;
import com.koreait.vo.MemberVO;

public class MemberDAO {
	SqlSessionFactory sqlsession_f = SqlMapConfig.getSqlMapInstance();
	SqlSession sqlsession;
	
	//기본 생성자
	public MemberDAO() {
		//DAO를 객체화하자마자 sqlsession이 할당된다.
		//모든 메소드마다 하지 않기 위해 기본 생성자에 만든 것
		sqlsession = sqlsession_f.openSession(true);//default : false, 자동 커밋 여부
	}
	
	//아이디 중복검사
	public boolean checkId(String id) {
		//mapper.xml에 만든 namespace.id, ?에 넣을 값
		return (Integer)sqlsession.selectOne("Member.checkId", id) == 0;
		//selectOne() : 결과 행이 1개일 때
		//selectList() : 결과 행이 여러 개일 때
	}
	
	//로그인
	/**
	 * {id='id',pw='pw'}
	 * @param map
	 * @return
	 */
	public boolean login(HashMap<String, String> map) {	
		return (Integer)sqlsession.selectOne("Member.login", map) == 1;
	}
	
	//회원가입
	public boolean join(MemberVO vo) {
		return (Integer)sqlsession.insert("Member.join", vo) == 1;
	}
	
	//회원 조회(회원 번호)
	public MemberVO select(int num) {
		return sqlsession.selectOne("Member.select", num);
	}
	
	//회원 번호 조회(아이디로)
	public int selectNum(String id) {
		return sqlsession.selectOne("Member.selectNum", id);
	}
	
	//비밀번호 조회(아이디)
	public String selectPw(String id) {
		return sqlsession.selectOne("Member.selectPw", id);
	}
	
	//아이디 조회(회원번호)
	public String selectId(int num) {
		return sqlsession.selectOne("Member.selectId", num);
	}
}
