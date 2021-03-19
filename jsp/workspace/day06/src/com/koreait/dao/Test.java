package com.koreait.dao;

import java.util.HashMap;
import java.util.List;

import com.koreait.vo.MemberVO;

public class Test {
	public static void main(String[] args) {
		MemberDAO dao = new MemberDAO();
//		MemberVO vo = new MemberVO();
		
		MemberVO vo = dao.getMember(21);
		
		if(dao.delete(vo)) {
			System.out.println("성공");
		}else {
			System.out.println("실패");
		}
		
//		String msg = "";
//		HashMap<String, String> map = new HashMap<>();
//		map.put("name", "가나다라마");
//		map.put("num", "21");
//		if(dao.modify(vo)) {
//			msg = "수정 성공";
//		}else {
//			msg = "수정 실패";
//		}
//		System.out.println(msg);
		
//		dao.listAll().forEach(memberVO -> System.out.println(memberVO));
//		
//		List<MemberVO> list = dao.listAll();
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//		}
	}
}
