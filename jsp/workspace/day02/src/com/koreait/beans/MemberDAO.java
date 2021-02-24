package com.koreait.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MemberDAO {
	//커넥터
	Connection conn;
	//pstm
	PreparedStatement pstm;
	//rs
	ResultSet rs;
	MemberVO member;
	
	//이름으로 전체 정보를 가져오기
	public ArrayList<MemberVO> select(String name) {
		String query = "SELECT * FROM TBL_MEMBER WHERE NAME = ?";
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		ArrayList<MemberVO> members = new ArrayList<>();
		
		try {
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, name);
			rs = pstm.executeQuery();
			while(rs.next()) {
				member = new MemberVO();
				member.setNum(rs.getInt(1));
				member.setName(rs.getString(2));
				member.setBirthday(sdf.format(rs.getDate(3)));
				
				members.add(member);
			}
		} catch (SQLException e) {
			System.out.println("select(String) 쿼리 오류" + e.getMessage());
		} catch (Exception e) {
			System.out.println("select(String) 오류" + e.getMessage());
		} finally {
			try {
				if(rs!=null) {rs.close();}
				if(pstm!=null) {pstm.close();}
				if(conn!=null) {conn.close();}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		
		
		/*ArrayList<MemberVO> list = new ArrayList<>();
		//가져온 '생년월일시분초를' '월-일'로 변경해서 저장
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		Date date = new Date();
		String query = "SELECT * FROM TBL_TABLE WHERE NAME = ?";
		try {
			//conn 연결 안했음
			pstm = conn.prepareStatement(query);
			pstm.setString(1, name);
			rs = pstm.executeQuery();
			//rs로 받는 행이 여러개인데 while() 안썼음
			member.setNum(rs.getInt(1));
			member.setName(rs.getString(2));
			date = rs.getDate(3);
			member.setBirthday(sdf.format(date));
			
			list.add(member);
		} catch (SQLException e) {
			System.out.println("쿼리문 오류");
		} finally {
			try {
				//if()로 닫혀있는지 확인 안했음
				rs.close();
				pstm.close();
				conn.close();
			} catch (SQLException e) {
				System.out.println("파일이 닫히지 않았습니다.");
			}
		}
		*/
		return members;
	}
}
