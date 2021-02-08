package view;

import dao.USER_TBL_DAO;
import vo.USER_TBL_VO;

public class Test {
	public static void main(String[] args) {
		USER_TBL_DAO dao = new USER_TBL_DAO();
		USER_TBL_VO vo = new USER_TBL_VO();
		
		
		
		if(dao.login("hds", "iscu!_")) {
			System.out.println("로그인 성공");
		}else {
			System.out.println("로그인 실패");
		}
		
//		dao.findPw("hds", "01046420130");
		
//		System.out.println(dao.findId("01046420130", "1111"));
		
//		vo.setAge(10);
//		vo.setId("hds");
//		vo.setName("한동석");
//		vo.setPw("1234");
//		vo.setPhoneNumber("01046420130");
//		
//		if(dao.join(vo)) {
//			System.out.println("회원가입 성공");
//		}else {
//			System.out.println("회원가입 실패");
//		}
		
//		if(dao.login("hds", "1234")) {
//			System.out.println("로그인 성공");
//			System.out.println(USER_TBL_DAO.session_id+"님 환영합니다.");
		
//			if(dao.delete("1234")) {
//				System.out.println("회원탈퇴 성공");
//				dao.logout();
//			}
			
//			if(dao.changePw("1234", "1111")) {
//				System.out.println("비밀번호 변경 다시 로그인해주세요.");
//				dao.logout();
//				
//				if(dao.login("hds1", "1111")) {
//					System.out.println("로그인 성공");
//					System.out.println(USER_TBL_DAO.session_id+"님 환영합니다.");
//				}else {
//					System.out.println("로그인 실패");
//				}
//			}else {
//				System.out.println("비밀번호가 잘못되었습니다.");
//			}
//			
//		}else {
//			System.out.println("로그인 실패");
//		}
//		
//		if(dao.logout()) {
//			System.out.println("로그아웃 성공");
//		}else {
//			System.out.println("로그인 후 이용이 가능합니다.");
//		}
	}
}
