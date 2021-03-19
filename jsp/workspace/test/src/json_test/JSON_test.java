package json_test;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSON_test {
	public String json = null;
	
	public void jsonAdd() {
		JSONObject json_in = new JSONObject();
		JSONObject json_out = new JSONObject();
		
		json_in.put("name", "이지은");
		json_in.put("age", "29");
		json_in.put("job", "singer");
		
		json_out.put("iu", json_in);
		
		json = json_out.toJSONString();
	}
	
	public static void main(String[] args) throws ParseException {
		JSON_test j = new JSON_test();
		j.jsonAdd();
		
		JSONParser p = new JSONParser();
		
		JSONObject json_in = new JSONObject();
		JSONObject json_out = new JSONObject();
		
		json_out = (JSONObject)p.parse(j.json);
		json_in = (JSONObject)json_out.get("iu");
		
		String name = (String)json_in.get("name");
		String age = (String)json_in.get("age");
		String job = (String)json_in.get("job");
		
		System.out.println("이름 : "+name+", 나이 : "+age+", 직업 : "+job);
	}
}
