package com.koreait.beans;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TABLE_MEMBER_DAO {
	Connection conn;
	PreparedStatement pstm;
	ResultSet rs;

	/**
	 * 
	 * @param id
	 * @return
	 * 중복이면 true, 중복이 없으면 false
	 */
	//아이디 중복검사
	public boolean dupCheck(String id) {
		String query = "SELECT COUNT(*) FROM TABLE_MEMBER WHERE ID = ?";
		boolean check = false;
		
		try {
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, id);
			rs = pstm.executeQuery();
			while(rs.next()) {
				if(rs.getInt(1) == 1) {
					check = true;
				}
			}
		} catch (SQLException e) {
			System.out.println("dupCheck(String) 쿼리 오류" + e.getMessage());
		} catch (Exception e) {
			System.out.println("dupCheck(String) 오류" + e.getMessage());
		} finally {
			try {
				if(rs!=null) {rs.close();}
				if(pstm!=null) {pstm.close();}
				if(conn!=null) {conn.close();}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return check;
	}
	
	public int join(TABLE_MEMBER_VO vo) {
		String query = "INSERT INTO TABLE_MEMBER VALUES(MEMBER_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?)";
		int n = 0;
		try {
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, vo.getId());
			pstm.setString(2, vo.getName());
			pstm.setString(3, vo.getPassword());
			pstm.setString(4, vo.getGender());
			pstm.setString(5, vo.getZipcode());
			pstm.setString(6, vo.getAddress());
			pstm.setString(7, vo.getAddressDetail());
			pstm.setString(8, vo.getAddressEtc());
			n = pstm.executeUpdate();
		} catch (SQLException e) {
			System.out.println("join() 쿼리 오류 : "+e.getMessage());
		} catch (Exception e) {
			System.out.println("join() 오류 : "+e.getMessage());
		} finally {
			try {
				if(pstm!=null) {pstm.close();}
				if(conn!=null) {pstm.close();}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return n;
	}
}
