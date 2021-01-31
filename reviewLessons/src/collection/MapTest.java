package collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapTest {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("포카칩", 3000);
		map.put("빈츠", 2800);
		map.put("빼빼로", 1500);
		map.put("오레오", 1000);
		
		System.out.println("포카칩 가격 : "+map.get("포카칩"));// Key를 주면 Value가 온다.
		
		System.out.println("===================");
		
		Set<String> key = map.keySet();
		Iterator<String> iterk = key.iterator();
		System.out.println("메뉴!");
		while(iterk.hasNext()) {
			System.out.println(iterk.next());
		}
		
		Collection<Integer> price = map.values();
		System.out.println("가격!");
		int total = 0;
		Iterator<Integer> value = price.iterator();
		while(value.hasNext()) {
			total += value.next();
		}
		
		double avg = (double)total / price.size();
		System.out.println(avg);
		//만약 소수점 3번째 자리까지 출력하고 싶은 경우
		double avg2 = Double.parseDouble(String.format("%.2f", (double)total / price.size()));
		System.out.println(avg2);
		
		//K, V 한 쌍씩 분리하기
		Iterator<Entry<String, Integer>> iter = map.entrySet().iterator();
		while(iter.hasNext()) {
			Entry<String, Integer> entry = iter.next();
			System.out.println(entry.getKey() + ":" + entry.getValue()+"원");
		}
		
	}
}
