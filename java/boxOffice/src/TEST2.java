
public class TEST2 {
	public static void main(String[] args) {
		int a = 5;
		boolean b = false;
		for (int i = 0; i <= a; i++) {
			if(i==a) {
				System.out.println("같다");
				b = true;
				break;
			}
		}
		
		if(b) {
			System.out.println(++a);
		}
		
		
		String str = "가나다라마바사아자차카타파하";
		System.out.println(str.substring(3));
		
		String test = "486\t캐치 미 이프 유 캔\t2003-01-24\t0\t1,807,612\t44";
		System.out.println(test.substring(test.indexOf("\t")+2));
		
	}
}
