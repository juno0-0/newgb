package day03;

public class AbstTest {
	public static void main(String[] args) {

		Shape s = new Shape() { // 클래스인데 이름이 없음 = 익명클래스

			@Override
			public double getArea(double w, double h) { // 메소드는 클래스 안에서 선언할 수 있음
				return 0;
			}
		};
	}
}
