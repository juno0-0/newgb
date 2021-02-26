package com.koreait.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class TABLE_MEMBER_DAO {
	
	Context context;//naming 패키지
	DataSource dataSource;//uql 패키지
	
	Connection conn;
	PreparedStatement pstm;
	ResultSet rs;
	
	public boolean login(String id, String pw) {
		boolean check = false;
		try {
			context = new InitialContext(null);//null을 꼭 넣어준다.
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/oracle");// context.xml에 설정한 name을 넣어준다.
			
			conn = dataSource.getConnection();
			String query = "SELECT COUNT(*) FROM TABLE_MEMBER WHERE ID = ? PASSWORD = ?";
			pstm = conn.prepareStatement(query);
			pstm.setString(1, id);
			pstm.setString(2, pw);
			
			rs = pstm.executeQuery();
			
			rs.next();
			
			if(rs.getInt(1)==1) {
				check = true;
			}
			
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				//커넥션 풀에서 close()의 역할은 해제가 아니라 반납이다.★★★
				if(rs != null) {rs.close();}
				if(pstm != null) {pstm.close();}
				if(conn != null) {conn.close();}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		
		return check;
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 * 중복이면 true, 중복이 없으면 false
	 */
	//아이디 중복 검사
	public boolean check(String id) {
		boolean result = false;
		conn = DBConnection.getConnection();
		
		String query = "SELECT COUNT(*) FROM TABLE_MEMBER WHERE id=?";
		try {
			pstm = conn.prepareStatement(query);
			pstm.setString(1, id);
			rs = pstm.executeQuery();
			rs.next();
			if(rs.getInt(1) == 1) {
				result = true;
			}
		} catch (SQLException e) {
			System.out.println("check()에서 쿼리 오류"+e.getMessage());
		} catch (Exception e) {
			System.out.println("check()에서 오류");
		} finally {
			try {
				if(rs != null) {rs.close();}
				if(pstm != null) {pstm.close();}
				if(conn != null) {conn.close();}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return result;
	}
	public boolean join(TABLE_MEMBER_VO member) {
		String query = "INSERT INTO TABLE_MEMBER VALUES(MEMBER_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?)";
		boolean check = false;
		
		try {
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, member.getId());
			pstm.setString(2, member.getName());
			pstm.setString(3, member.getPassword());
			pstm.setString(4, member.getGender());
			pstm.setString(5, member.getZipcode());
			pstm.setString(6, member.getAddress());
			pstm.setString(7, member.getAddressDetail());
			pstm.setString(8, member.getAddressEtc());
			
			if(pstm.executeUpdate() == 1) {
				check = true;
			}
			
		} catch (SQLException e) {
			System.out.println("join(TABLE_MEMVER_VO) 오류 : "+e.getMessage());
		} catch (Exception e) {
			System.out.println("join(TABLE_MEMVER_VO) 알 수 없는 오류 : "+e.getMessage());
		} finally {
			try {
				if(pstm!=null) {pstm.close();}
				if(conn!=null) {conn.close();}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return check;
		/*conn = DBConnection.getConnection();
		
		boolean result = false;
		String query = "INSERT INTO TABLE_MEMBER VALUES(MEMBER_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?)";
		//아이디, 이름, 비밀번호, 성별, 우편번호, 주소, 디테일주소, ETC주소
		
		try {
			pstm = conn.prepareStatement(query);
			pstm.setString(1, vo.getId());
			pstm.setString(2, vo.getName());
			pstm.setString(3, vo.getPassword());
			pstm.setString(4, vo.getGender());
			pstm.setString(5, vo.getZipcode());
			pstm.setString(6, vo.getAddress());
			pstm.setString(7, vo.getAddressDetail());
			pstm.setString(8, vo.getAddressEtc());
			int resultCnt = pstm.executeUpdate();
			
			if(resultCnt == 1) {
				result = true;
			}
		} catch (SQLException e) {
			System.out.println("join()에서 쿼리 오류"+e.getMessage());
		} catch (Exception e) {
			System.out.println("join()에서 오류");
		} finally {
			try {
				if(pstm != null) {pstm.close();}
				if(conn != null) {conn.close();}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return result;*/
	}
}
