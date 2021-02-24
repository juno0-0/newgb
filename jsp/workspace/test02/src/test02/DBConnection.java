package test02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public static Connection getDBConnection() {
		Connection conn = null;
		
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "hr";
		String pw = "hr";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection(url, user, pw);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패 : "+e.getMessage());
		} catch (SQLException e) {
			System.out.println("DB 접속 실패 : "+e.getMessage());
		} catch (Exception e) {
			System.out.println("알 수 없는 오류 : "+e.getMessage());
		}
		return conn;
	}
}
