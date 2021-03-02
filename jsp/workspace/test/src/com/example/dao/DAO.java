package com.example.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.example.mybatis.config.SqlMapConfig;
import com.example.vo.VO;

public class DAO {
	SqlSessionFactory sqlsession_f = SqlMapConfig.getSqlMapInstance();
	SqlSession sqlsession;
	
	public DAO() {
		sqlsession = sqlsession_f.openSession(true);
	}
	
	//회원가입
	public boolean join(VO vo) {
		return (Integer)sqlsession.insert("TABLE_MEMBER.join", vo) == 1;
	}
	
	//중복체크
	public boolean checkId(String id) {
		return (Integer)sqlsession.selectOne("TABLE_MEMBER.checkId", id) == 0;
	}
	
	//로그인
	public boolean login(HashMap<String, String> map) {
		return (Integer)sqlsession.selectOne("TABLE_MEMBER.login", map) == 1;
	}
	
	//회원 번호로 아이디 조회하기
	public String findId(int num) {
		return sqlsession.selectOne("TABLE_MEMBER.findId", num);
	}
	
	//id와 pw로 모든 정보 조회하기
	public VO list(HashMap<String, String> map) {
		return sqlsession.selectOne("TABLE_MEMBER.list", map);
	}
	
	//id가 일치하면 주소 바꾸기
	public boolean modifyAddress(HashMap<String, String> map) {
		return sqlsession.update("TABLE_MEMBER.modifyAddress",map) == 1;
	}

	//회원번호로 정보 삭제하기
	public boolean deleteNum(int num) {
		return (Integer)sqlsession.delete("TABLE_MEMBER.deleteNum", num) == 1;
	}
	
	//id가 일치하는 모든 정보 불러오기
	public List<VO> test(String id) {
		return sqlsession.selectList("TABLE_MEMBER.test", id);
	}
	
}
