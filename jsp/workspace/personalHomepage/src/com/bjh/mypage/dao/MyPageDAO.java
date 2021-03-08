package com.bjh.mypage.dao;

import java.util.HashMap;
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
	public boolean join(MyPageVO m_vo) {
		//여기서 빠져나오지 않음
		return session.insert("mypage.join", m_vo) == 1;
	}
	
	public String sms(String mypagePhone) {
		String num = new Random().nextInt(10000)+"";
		
		String api_key = "NCSJ2DN9KV5RBFBT";
	    String api_secret = "UPWRB6JLN62M6FX1E9ZO7R1BVX4DKZNO";
	    Message coolsms = new Message(api_key, api_secret);

	    // 4 params(to, from, type, text) are mandatory. must be filled
	    HashMap<String, String> params = new HashMap<String, String>();
	    params.put("to", mypagePhone);
	    params.put("from", mypagePhone);
	    params.put("type", "SMS");
	    params.put("text", num);
	    params.put("app_version", "test app 1.2"); // application name and version

	    try {
	      JSONObject obj = (JSONObject) coolsms.send(params);
	      System.out.println(obj.toString());
	    } catch (CoolsmsException e) {
	      System.out.println(e.getMessage());
	      System.out.println(e.getCode());
	    }
		
	    return num;
	}
}
