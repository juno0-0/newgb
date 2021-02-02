package dao;
//JDBC : Java Database Connectivity

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnecter {
	
	public static Connection getConnection() {
		Connection conn = null;
		//url, id, pw
		//연결을 하려면 오라클 드라이버가 필요하다.
		try {
			//만약 DB접속이 계속해서 실패하면 localhost대신 본인 서버 IP주소를 입력한다.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String user = "hr";
			String pw = "hr";
			conn = DriverManager.getConnection(url, user, pw);
			System.out.println("DB 연결 성공");
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		} catch (SQLException e) {
			System.out.println("DB 접속 실패");
		} catch (Exception e) {
			System.out.println("getConnection() 알 수 없는 오류");
		}
		
		return conn;
	}
	
}
