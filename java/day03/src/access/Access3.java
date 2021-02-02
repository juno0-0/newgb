package access;

import day03.Access1;

//Access1과 다른 패키지
public class Access3 extends Access1 {
	// public이 붙은 클래스가 2개 존재할 수 없음.
	public static void main(String[] args) {
		Access1 a1 = new Access1();
		// 패키지가 다르기 때문에 public만 사용할 수 있다.
		Access3 a3 = new Access3();
		// 상속을 받아서 자식 객체로 접근하면 protected를 쓸 수 있다.
	}
}
