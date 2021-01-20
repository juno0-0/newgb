package day01;

public class MainTest {
	public static void main(String[] args) {
		//main도 메소드
		//여기는 main메소드 선언하는 부분
		//{ }가 있으면 선언, 없으면 사용
		if(args.length == 0) {
			System.out.println("None");
		}else {
			for (int i = 0; i < args.length; i++) {
				System.out.println(args[i]);			
			}
		}
	}
}
