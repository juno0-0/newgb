package com.koreait.dao;

import java.util.HashMap;

import com.koreait.vo.MemberVO;

public class Test {
	public static void main(String[] args) {
		MemberDAO dao = new MemberDAO();
		
		System.out.println(dao.checkId("asdsad"));
		
		HashMap<String, String> map = new HashMap<>();
		map.put("id", "abcd");
		map.put("pw", "Aa123456!");
		if(dao.login(map)) {
			System.out.println("로그인 성공");
		}else {
			System.out.println("로그인 실패");
		}
		
		MemberVO vo = new MemberVO();
		vo.setId("test");
		vo.setName("홍길동");
		vo.setPassword("Aa123456!");
		vo.setGender("남성");
		vo.setZipcode("12345");
		vo.setAddress("서울");
		vo.setAddressDetail("어딘가");
		vo.setAddressEtc("...");
		if(dao.join(vo)) {
			System.out.println("회원가입 성공");
		}else {
			System.out.println("회원가입 실패");
		}
		
		System.out.println(dao.select(999));
		
		System.out.println(dao.selectNum("뮤뮤뮤뮤"));
		
		System.out.println(dao.selectPw("뮤뮤뮤뮤"));
		
		System.out.println(dao.selectId(999));
	}
}
