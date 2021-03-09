package com.bjh.mypage.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.json.simple.JSONObject;

import com.bjh.mybatis.config.SqlMapConfig;
import com.bjh.mypage.vo.MyPageVO;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;



public class MyPageDAO {
	SqlSessionFactory ssf = SqlMapConfig.getSqlMapInstance();
	SqlSession session;
	
	//기본 생성자
	public MyPageDAO() {
		session = ssf.openSession(true);
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 * 
	 * true면 중복<br>false면 사용 가능
	 * 
	 */
	//아이디 중복체크
	public boolean checkId(String id) {
		return (Integer)session.selectOne("mypage.checkId", id) == 1;
	}
	
	/**
	 * 
	 * @param m_vo
	 * @return
	 * 
	 * true면 성공<br>false면 실패
	 * 
	 */	
	//회원가입
	public boolean join(MyPageVO m_vo) {
		//여기서 빠져나오지 않음
		return session.insert("mypage.join", m_vo) == 1;
	}
	
	//핸드폰 인증
	public String sms(String mypagePhone) {
		System.out.println("DAO");
		String num = (new Random().nextInt(9000)+1000)+"";//1000~9999
		
//		String api_key = "NCSJ2DN9KV5RBFBT";
//	    String api_secret = "UPWRB6JLN62M6FX1E9ZO7R1BVX4DKZNO";
//	    Message coolsms = new Message(api_key, api_secret);
//
//	    // 4 params(to, from, type, text) are mandatory. must be filled
//	    HashMap<String, String> params = new HashMap<String, String>();
//	    params.put("to", "01046420130");
//	    params.put("from", mypagePhone);
//	    params.put("type", "SMS");
//	    params.put("text", num);
//	    params.put("app_version", "test app 1.2"); // application name and version
//
//	    try {
//	      JSONObject obj = (JSONObject) coolsms.send(params);
//	      System.out.println(obj.toString());
//	    } catch (CoolsmsException e) {
//	      System.out.println(e.getMessage());
//	      System.out.println(e.getCode());
//	    }
		
	    return num;
	}
	
	/**
	 * 
	 * @param mypageId
	 * @param mypagePw
	 * @return
	 * 
	 * true면 로그인 성공<br>false면 로그인 실패
	 * 
	 */
	//로그인
	public boolean login(String mypageId, String mypagePw) {
		HashMap<String, String> map = new HashMap<>();
		map.put("mypageId", mypageId);
		map.put("mypagePw", mypagePw);
		return (Integer)session.selectOne("mypage.login", map) == 1;
	}
	
	public List<String> findId(String mypagePhone){
		return session.selectList("mypage.findId", mypagePhone);
	}
	
}
