package obj;

import java.util.Random;

public class ObjectTest {
	public static void main(String[] args) {
		String data1 = "ABC";//값 우선
		String data2 = "ABC";
		
		String data3 = new String("ABC");//필드 우선
		String data4 = new String("ABC");
		
		//==은 주소비교
		System.out.println(data1 == data2);
		System.out.println("===어떻게 컨스턴트 풀의 주소를 가져오는가?===");
		System.out.println(data3 == data4);
		//컨스턴트 풀에 해당 값이 있으면 같은 값을 호출할 때 같은 주소를 보내준다.
		System.out.println(data3.intern() == data4.intern());
		System.out.println(data1 == data3.intern());
		System.out.println("==================================");
		System.out.println(data3.equals(data4));
		
		System.out.println("===========");
		System.out.println(data1.hashCode());
		System.out.println(data2.hashCode());
		System.out.println("===========");
		System.out.println(data3.hashCode());
		System.out.println(data4.hashCode());
		System.out.println("===========");
		
		
		Random r1 = new Random();
		Random r2 = new Random();
		
		System.out.println(r1 == r2);
		System.out.println(r1.equals(r2));
		
		
		
	}
}
