package join.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MemberDAO {
	
	Context context;
	DataSource dataSource;
	
	Connection conn;
	PreparedStatement pstm;
	ResultSet rs;
	
	public boolean login(String id, String pw) {
		String query = "SELECT COUNT(*) FROM TABLE_MEMBER WHERE ID = ? AND PW = ?";
		boolean check = false;
		try {
			context = new InitialContext(null);
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/oracle");
			conn = dataSource.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, id);
			pstm.setString(2, pw);
			rs = pstm.executeQuery();
			System.out.println("문제 찾기3");
			rs.next();
			
			if(rs.getInt(1) == 1) {
				check = true;
			}
		} catch (NamingException e) {
			System.out.println("login(String, String) 오류");
		}catch (SQLException e) {
			System.out.println("??? 오류");
		} catch (Exception e) {
			System.out.println("login(String, String) 알 수 없는 오류 : "+e.getMessage());
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
	
	public boolean dupCheck(String id) {
		String query = "SELECT COUNT(*) FROM TABLE_MEMBER WHERE ID = ?";
		boolean check = false;
		
		try {
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, id);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				if(rs.getInt(1) == 0) {
					//check가 true면 중복이 아닌 것
					check = true;
				}
			}
		} catch (SQLException e) {
			System.out.println("dupCheck(String) 오류");
		} catch (Exception e) {
			System.out.println("dupCheck(String) 알 수 없는 오류 : "+e.getMessage());
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
	
	public boolean join(MemberVO vo) {
		String quert = "INSERT INTO TABLE_MEMBER VALUES(MEMBER_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?)";
		int n = 0;
		boolean check = false;
		try {
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(quert);
			pstm.setString(1, vo.getId());
			pstm.setString(2, vo.getName());
			pstm.setString(3, vo.getPassword());
			pstm.setString(4, vo.getGender());
			pstm.setString(5, vo.getZipcode());
			pstm.setString(6, vo.getAddress());
			pstm.setString(7, vo.getAddressDetail());
			pstm.setString(8, vo.getAddressEtc());
			n = pstm.executeUpdate();
			
			if(n != 0) {
				check = true;
			}
		} catch (SQLException e) {
			System.out.println("join(MemberVO) 오류");
		} catch (Exception e) {
			System.out.println("join(MemberVO) 알 수 없는 오류 : "+e.getMessage());
		} finally {
			try {
				if(pstm!=null) {pstm.close();}
				if(conn!=null) {conn.close();}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return check;
	}
}
