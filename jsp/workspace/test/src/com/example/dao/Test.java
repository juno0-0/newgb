package com.example.dao;

import java.util.List;

import com.example.vo.VO;

public class Test {
	public static void main(String[] args) {
		DAO dao = new DAO();
		System.out.println("test");
		List<VO> list = dao.test("iu");
		System.out.println(list.get(0).getName());
		System.out.println(list.get(2).getName());
//		for(int i=0; i<list.size(); i++) {
//			System.out.println(list.get(i).getName());
//		}
		
		/*
		if(dao.deleteNum(103)) {
			System.out.println("삭제 성공");
		}else {
			System.out.println("삭제 실패");
		}
		
		
		
		HashMap<String, String> map = new HashMap<>();
		map.put("id", "jo");
		map.put("new_address", "서울시 강남구 역삼동");
		if(dao.modifyAddress(map)) {
			System.out.println("수정 완료");
		}else {
			System.out.println("수정 실패");
		}
		
		if(dao.checkId("jo")) {
			System.out.println("사용가능한 아이디입니다.");
		}else {
			System.out.println("중복된 아이디입니다.");
		}
		
		map.put("id", "jo");
		map.put("pw", "Bb123456!");
		
		if(dao.login(map)) {
			System.out.println("로그인 성공");
		}else {
			System.out.println("로그인 실패");
		}
		
		System.out.println(dao.list(map).getName());
		
		System.out.println(dao.findId(103));
		
		
		}
	
		VO vo = new VO();
		vo.setId("iu");
		vo.setName("문채원");
		vo.setPassword("Bb123456!");
		vo.setGender("여성");
		vo.setZipcode("55555");
		vo.setAddress("서울시");
		vo.setAddressDetail("어딘가");
		vo.setAddressEtc("...");
		
		if(dao.join(vo)) {
			System.out.println("회원가입 성공");
		}else {
			System.out.println("회원가입 실패");
		}
			*/
		
	}
}
