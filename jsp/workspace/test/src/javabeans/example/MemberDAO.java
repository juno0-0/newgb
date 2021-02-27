package javabeans.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class MemberDAO {
	Connection conn;
	PreparedStatement pstm;
	ResultSet rs;
	MemberVO vo;
	
	public ArrayList<MemberVO> select(String name) {
		String query = "SELECT * FROM TEST_MEMBER WHERE NAME = ?";
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		ArrayList<MemberVO> list = new ArrayList<>();
		
		try {
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, name);
			rs = pstm.executeQuery();
			
			rs.next();
			vo = new MemberVO();
			vo.setName(rs.getString(1));
			vo.setBirthday(sdf.format(rs.getDate(2)));
			
			list.add(vo);
			
		} catch (SQLException e) {
			System.out.println("select(String) 쿼리 오류 : "+e.getMessage());
		} catch (Exception e) {
			System.out.println("select(String) 알 수 없는 오류 : "+e.getMessage());
		} finally {
			try {
				if(rs!=null) {rs.close();}
				if(pstm!=null) {pstm.close();}
				if(conn!=null) {conn.close();}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		
		return list;
	}
	
}
