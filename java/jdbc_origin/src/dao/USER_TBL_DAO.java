package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import org.json.simple.JSONObject;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import vo.USER_TBL_VO;

public class USER_TBL_DAO {
	public static String session_id;
	//static으로 만든 이유는 모든 객체가 공유할 수 있게끔 하기 위해서
	private final static int KEY = 5;
	//String id = "hds";
	
	//[Statement]
	//String query = "SELECT * FROM USER_TBL WHERE ID = \'"+id+"\'";
	
	//[PreparedStatement]
	//String query = "SELECT * FROM USER_TBL WHERE ID = ?";
	//pstm.setString(1, id);
	
	Connection conn;	//접속에 성공한 DB의 연결 객체
	PreparedStatement pstm;	//JAVA에서 문자열로 작성한 쿼리문을 저장하고, 
							//?에 필요한 값을 채운 후 쿼리를 실행시켜 준다.
	ResultSet rs;	//조회 결과값을 담을 수 있는 객체
	
	//아이디 검사
	public boolean checkId(String id) {
		//COUNT(컬럼명) : 집계함수
		//COUNT(*) : 결과 행의 개수
		String query = "SELECT COUNT(*) FROM USER_TBL WHERE ID = ?";
		boolean check = false;
		try {
			//커넥션 객체 가져오기
			conn = DBConnecter.getConnection();
			//가져온 커넥션 객체를 통해 PreparedStatement 실행
			pstm = conn.prepareStatement(query);
			//?에 들어갈 값 설정
			pstm.setString(1, id);	//JDBC의 인덱스는 1부터 시작
			//완성된 쿼리문을 실행, 결과가 있다면 rs객체에 넣기
			rs = pstm.executeQuery(); //쿼리문 보내기
			
			//결과 행 1개 불러오기
			rs.next();	//행, 행이 여러개면 while로 반복하지만 집계함수는 결과가 1개라서 그냥 사용
			//첫번째 결과 열 가져오기
			if(rs.getInt(1) == 1) {	//열, 열의 개수만큼 사용, 컬럼의 인덱스나 컬럼명을 준다.
				//아이디 검사 후 존재한다면 1, 존재하지 않으면 0
				check = true;
			}
			
		} catch (SQLException e) {
			System.out.println("checkId() 쿼리문 오류");
		} catch (Exception e) {
			System.out.println("checkId() 알 수 없는 오류");
		} finally { //외부 저장소 닫을 때는 무조건 finally
			try {
				if(rs!=null) {rs.close();}
				if(pstm!=null) {rs.close();}
				if(conn!=null) {rs.close();}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());//닫히지 않으면 예외가 발생하고 e.getMessage()로 오류 내용 보여주기
			}
		}
		return check;
	}
	
	//회원가입(암호화 사용)
	public boolean join(USER_TBL_VO user) {
		//INSERT
		//회원 번호는 SEQ 사용
		//USER_SEQ.NEXTVAL : 시퀀스 가져오기
		//쿼리문 작성
		String query = "INSERT INTO USER_TBL VALUES(USER_SEQ.NEXTVAL,?,?,?,?,?)";
		boolean check = false;
		
		
		//사용자가 입력한 아이디를 DB에서 검사한다.
		//회원가입 안에 중복체크를 하면 실패했을 때 join에서 왜 회원가입에 실패한지 모른다.
		//또 입력을 전부 다 하고 회원가입을 누르면 중복된다고 나와서 비효율적이다.
		//회원가입 버튼을 눌렀을 때 실행하지 않고 중복확인 버튼을 누르면 실행되게 한다.
		//view에서 사용
//		if(checkId(user.getId())) {
//			//if가 true일 때 중복이 있다는 뜻
//			return check;
//		}
		
		
		try {
			//DB 연결 객체
			conn = DBConnecter.getConnection();
			//쿼리문 저장하기
			pstm = conn.prepareStatement(query);
			//SELECT외의 INSERT, UPDATE, DELETE 쿼리문은 결과 건수를 가져와 확인하면 된다.
			//executeQuery() : SELECT의 결과를 리턴해주는 메소드, ResultSet 타입으로 리턴
			//executeUpdate() : UPDATE, INSERT, DELETE의 결과 건수를 리턴해주는 메소드, int 타입으로 리턴
			//SELECT는 executeQuery() 나머지는 executeUpdate()
			//?에 값 넣어주기
			//회원 번호는 SEQ를 사용하기 때문에 쿼리문에 입력함 
			int idx = 0;
			pstm.setString(++idx, user.getId());
			//pw는 암호화 메소드 사용
			pstm.setString(++idx, encrypt(user.getPw()));
			pstm.setString(++idx, user.getName());
			pstm.setInt(++idx, user.getAge());
			pstm.setString(++idx, user.getPhoneNumber());
			//쿼리문 전송(executeUpdate()는 int로 리턴된다.)
			if(pstm.executeUpdate() == 1) {
				check = true;				
			}
		} catch (SQLException e) {
			System.out.println("join() 쿼리문 오류");
		} catch (Exception e) {
			System.out.println("join() 알 수 없는 오류");
		} finally {
			try {
				//사용한거 닫아주기
				if(pstm!=null) {pstm.close();}
				if(conn!=null) {conn.close();}
			} catch (SQLException e) {
				//만약 안닫힌게 있다면 RuntimeException 발생
				throw new RuntimeException(e.getMessage());
			}
		}
		//회원가입에 성공!
		return check;
	}
	
	//로그인
	//보통 로그인을 하면 id나 회원번호를 기억한다.(PK)
	//전체 정보를 기억하면 메모리 소모가 너무 크기 때문에
	//서버에 Session이란 공간에 id를 저장해 놓는다.
	public boolean login(String id, String pw) {
		//성공 실패만 필요하기 때문에 1, 0으로 리턴하는 COUNT(*)를 사용한다.
		String query = "SELECT COUNT(*) FROM USER_TBL WHERE ID = ? AND PW = ?";
		boolean check = false;
		try {
			conn = DBConnecter.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, id);
			pstm.setString(2, encrypt(pw));
			rs = pstm.executeQuery();
			
			rs.next();
			if(rs.getInt(1) == 1) {
				check = true;
				//로그인된 회원의 id를 저장
				session_id = id;//session_id가 null이면 로그인이 안된 상태
			}
			
		} catch (SQLException e) {
			System.out.println("login() 쿼리문 오류");
		} catch (Exception e) {
			System.out.println("login() 알 수 없는 오류");
		} finally { //외부 저장소 닫을 때는 무조건 finally
			try {
				if(rs!=null) {rs.close();}
				if(pstm!=null) {rs.close();}
				if(conn!=null) {rs.close();}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());//닫히지 않으면 예외가 발생하고 e.getMessage()로 오류 내용 보여주기
			}
		}
		return check;
	}
	
	//로그아웃
	public boolean logout() {
		if(session_id != null) {
			session_id = null;
			return true;
		}
		System.out.println("히옹");
		return false;
	}
	
	//마이페이지
	public USER_TBL_VO select(String pw) {
		
		//로그인이 안되면 애초에 마이페이지를 볼 수 없기 때문에 필요가 없다.
//		if(session_id == null) {
//			return null;
//		}
		
		USER_TBL_VO user = null;
		//한명이면 모델객체, 여러명이면 ArrayList
		//비밀번호는 중복검사를 하지 않아서 session_id에 있는 ID까지 비교한다.(비밀번호가 같으면 정보가 여러개 나오니까)
		String query = "SELECT * FROM USER_TBL WHERE ID = ? AND PW = ?";
		
		try {
			conn = DBConnecter.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, session_id);
			pstm.setString(2, encrypt(pw));
			rs = pstm.executeQuery();
			
			if(rs.next()) {
				user = new USER_TBL_VO();
				user.setId(rs.getString("ID"));
				user.setPw(rs.getString("PW"));
				user.setName(rs.getString("NAME"));
				user.setAge(rs.getInt("AGE"));
				user.setPhoneNumber(rs.getString("PHONENUMBER"));
			}
			
		} catch (SQLException e) {
			System.out.println("select() 쿼리문 오류");
		} catch (Exception e) {
			System.out.println("select() 알 수 없는 오류");
		} finally { //외부 저장소 닫을 때는 무조건 finally
			try {
				if(rs!=null) {rs.close();}
				if(pstm!=null) {rs.close();}
				if(conn!=null) {rs.close();}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());//닫히지 않으면 예외가 발생하고 e.getMessage()로 오류 내용 보여주기
			}
		}
		return user;
	}
	
	//목록(회원 전체 목록)
	//결과가 여러개이기 때문에 ArrayList를 사용
	public ArrayList<USER_TBL_VO> selectAll() {
		ArrayList<USER_TBL_VO> list = new ArrayList<>();
		//테이블의 모든 행 검색하는 쿼리문
		String query = "SELECT * FROM USET_TBL";
		
		try {
			conn = DBConnecter.getConnection();
			pstm = conn.prepareStatement(query);
			rs = pstm.executeQuery();
			//결과가 여러개라 while문에 rs.next()를 써서 계속 행을 불러오기
			while(rs.next()) {
				//USER_TBL_VO 객체를 만들어서 값을 넣어주기
				USER_TBL_VO user = new USER_TBL_VO();
				user.setId(rs.getString("ID"));
				user.setPw(rs.getString("PW"));
				user.setName(rs.getString("NAME"));
				user.setAge(rs.getInt("AGE"));
				user.setPhoneNumber(rs.getString("PHONENUMBER"));
				//user 객체를 ArrayList에 추가하기
				list.add(user);
			}
		} catch (SQLException e) {
			System.out.println("selectAll() 쿼리문 오류");
		} catch (Exception e) {
			System.out.println("selectAll() 알 수 없는 오류");
		} finally { //외부 저장소 닫을 때는 무조건 finally
			try {
				if(rs!=null) {rs.close();}
				if(pstm!=null) {rs.close();}
				if(conn!=null) {rs.close();}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());//닫히지 않으면 예외가 발생하고 e.getMessage()로 오류 내용 보여주기
			}
		}
		//ArrayList를 리턴
		return list;
	}
	
	//삭제(회원 탈퇴)
	public boolean delete(String pw) {
		String query = "DELETE FROM USER_TBL WHERE ID = ? AND PW = ?";
		
		boolean check = false;
		
		try {
			conn = DBConnecter.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, session_id);
			pstm.setString(2, encrypt(pw));
			if(pstm.executeUpdate() == 1) {
				check = true;
			}
		} catch (SQLException e) {
			System.out.println("delete() 쿼리문 오류");
		} catch (Exception e) {
			System.out.println("delete() 알 수 없는 오류");
		} finally { //외부 저장소 닫을 때는 무조건 finally
			try {
				if(pstm!=null) {rs.close();}
				if(conn!=null) {rs.close();}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());//닫히지 않으면 예외가 발생하고 e.getMessage()로 오류 내용 보여주기
			}
		}
		return check;
	}
	
	//아이디 찾기
	//핸드폰 번호와 비밀번호로 아이디 조회
	public String findId(String phone, String pw) {
		
		String query = "SELECT ID FROM USER_TBL WHERE PHONENUMBER = ? AND PW = ?";
		//찾은 id를 저장할 임시 저장공간
		String id = null;
		try {
			conn = DBConnecter.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, phone);
			pstm.setString(2, encrypt(pw));
			rs = pstm.executeQuery();
			//phone와 pw가 일치하는게 있다면 rs.next 실행, 없다면 아무것도 안나옴
			if(rs.next()) {
				//결과를 id라는 변수에 담아서 리턴할꺼
				id = rs.getString("ID");
			}
			
		} catch (SQLException e) {
			System.out.println("findId() 쿼리문 오류");
		} catch (Exception e) {
			System.out.println("findId() 알 수 없는 오류");
		} finally { //외부 저장소 닫을 때는 무조건 finally
			try {
				if(rs!=null) {rs.close();}
				if(pstm!=null) {rs.close();}
				if(conn!=null) {rs.close();}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());//닫히지 않으면 예외가 발생하고 e.getMessage()로 오류 내용 보여주기
			}
		}
		//찾은 id 리턴, phone와 pw가 둘 다 만족하는게 없다면 null이 리턴된다.
		return id;
	}
	
	//수정(비밀번호 변경 : 로그인 된 상태에서)
	//현재 비밀번호, 새로운 비밀번호
	public boolean changePw(String pw, String new_pw) {
		String query = "UPDATE USER_TBL SET PW = ? WHERE ID = ? AND PW = ?";
		boolean check = false;
		try {
			conn = DBConnecter.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, encrypt(new_pw));
			pstm.setString(2, session_id);
			pstm.setString(1, encrypt(pw));
			if(pstm.executeUpdate() == 1) {
				check = true;
			}
		} catch (SQLException e) {
			System.out.println("changePw(String, String) 쿼리문 오류");
		} catch (Exception e) {
			System.out.println("changePw(String, String) 알 수 없는 오류");
		} finally { //외부 저장소 닫을 때는 무조건 finally
			try {
				if(pstm!=null) {rs.close();}
				if(conn!=null) {rs.close();}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());//닫히지 않으면 예외가 발생하고 e.getMessage()로 오류 내용 보여주기
			}
		}
		return check;
	}
	
	//수정(비밀번호 변경 : 임시비밀번호로 변경)
	//회원번호를 통해 임시 비밀번호로 비밀번호 변경
	//view에서 따로 쓰지 않는다.
	private void changePw(int user_number, String tempPw) {
		String query = "UPDATE USER_TBL SET PW = ? WHERE USER_NUMBER = ?";
		try {
			conn = DBConnecter.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, encrypt(tempPw));
			pstm.setInt(2, user_number);
			
			pstm.executeUpdate();
		} catch (SQLException e) {
			System.out.println("changePw(int, String) 쿼리문 오류");
		} catch (Exception e) {
			System.out.println("changePw(int, String) 알 수 없는 오류");
		} finally { //외부 저장소 닫을 때는 무조건 finally
			try {
				if(pstm!=null) {rs.close();}
				if(conn!=null) {rs.close();}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());//닫히지 않으면 예외가 발생하고 e.getMessage()로 오류 내용 보여주기
			}
		}
	}
	
	//비번 찾기(ID와 핸드폰 번호를 전달 받는다.)
	//임시 비밀번호 6자리 생성(Random 사용)
	//SMS API를 사용하여 JSON으로 데이터(수신번호, 발신번호, 내용 등) 전송
	//전송된 임시 비밀번호로 UPDATE(여기서 위의 수정(비밀번호 변경 : 임시비밀번호로 변경)를 사용)
	//본인 핸드폰에 온 문자 확인 후 임시비밀번호 확인
	public void findPw(String id, String phoneNumber) {
		String query = "SELECT USER_NUMBER FROM USER_TBL WHERE ID = ? AND PHONENUMBER = ?";
		
		try {
			conn = DBConnecter.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, id);
			pstm.setString(2, phoneNumber);
			
			rs = pstm.executeQuery();
			
			if(rs.next()) {
				//임시 비밀번호 생성
				Random r = new Random();
				String temp = "0123456789abcdefghijklmnopqrstuvwxyz~!@#$%^&*()_+=[] {};:/?";
				final int TEMP_PW_LENGTH = 6;
				String temp_pw = "";
				for (int i = 0; i < TEMP_PW_LENGTH; i++) {
					temp_pw += temp.charAt(r.nextInt(temp.length()));
				}
				//비밀번호 변경
				changePw(rs.getInt(1), temp_pw);
				
				//SMS 문자 전송
				String api_key = "NCSJ2DN9KV5RBFBT";
			    String api_secret = "UPWRB6JLN62M6FX1E9ZO7R1BVX4DKZNO";
			    Message coolsms = new Message(api_key, api_secret);

			    // 4 params(to, from, type, text) 얘네는 반드시 입력해야 함
			    HashMap<String, String> params = new HashMap<String, String>();
			    params.put("to", "01046420130");
			    params.put("from", "01046420130");
			    params.put("type", "SMS");
			    params.put("text", "[테스트]\n임시 비밀번호 : "+temp_pw+"\n노출될 수 있으니 반드시 비밀번호를 변경해 주세요.");
			    params.put("app_version", "JAVA SDK v2.2"); // application name and version

			    try {
			      JSONObject obj = (JSONObject) coolsms.send(params);
			      System.out.println(obj.toString());
			    } catch (CoolsmsException e) {
			      System.out.println(e.getMessage());
			      System.out.println(e.getCode());
			    }
				
				//ctrl + shift + o : 자동 import
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	//암호화
	//복호화는 보안때문에 어차피 안하기 때문에 만들지도 않는다.
	public String encrypt(String pw) {
		String en_pw = "";
		for (int i = 0; i < pw.length(); i++) {
			en_pw += (char)(pw.charAt(i) * KEY);
		}
		return en_pw;
	}
}
