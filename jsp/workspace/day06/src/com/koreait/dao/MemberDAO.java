package com.koreait.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.koreait.mybatis.config.SqlMapConfig;
import com.koreait.vo.MemberVO;

public class MemberDAO {
	SqlSessionFactory sqlsession_f = SqlMapConfig.getSqlMapInstance();
	SqlSession sqlsession;
	
	public MemberDAO() {
		sqlsession = sqlsession_f.openSession(true);
	}
	
	//회원번호로 비밀번호 조회
	public String findPw(int num) {
		return sqlsession.selectOne("Member.findPw", num);
	}
	//전체 회원 조회
	public List<MemberVO> listAll(){
		return sqlsession.selectList("Member.listAll");
	}
	
	//회원번호로 정보 조회
	public MemberVO getMember(int num) {
		return sqlsession.selectOne("Member.getMember", num);
	}
	
	//회원 이름 수정(회원번호)
	//회원 상세보기(마이페이지-select)를 통해 가져온 모델 객체에 바로 수정하기 때문에
	//수정된 모델 객체를 전달받는 것이 편하다.
	public boolean modify(MemberVO vo) {
		return sqlsession.update("Member.update", vo) == 1;
	}
	
	//회원 삭제(회원번호)
	public boolean delete(MemberVO vo) {
		return sqlsession.delete("Member.delete", vo) == 1;
	}
}
