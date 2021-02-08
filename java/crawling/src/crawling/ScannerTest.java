package crawling;

import java.util.Scanner;

public class ScannerTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("성별 : ");
		String gender = sc.nextLine();
		
		System.out.println(name);
		System.out.println(gender);
	}
}
