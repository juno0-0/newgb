package day01;

public class MethodTask {
	
	//1~n까지 합을 println()으로 출력하는 메소드
	/**
	 * 
	 * @param end
	 * @throw ArithmeticException
	 * 
	 */
	public void printSumFrom1(int end) {
		
		if(end < 1) {
			throw new ArithmeticException();
		}
		
		int total = 0;
		for (int i = 0; i <= end; i++) {
			total += i+1;
		}
		System.out.println(total);
	}
	
	public void addTest(int n) {
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += i;
		}
		System.out.println(sum);
	}
	
	//나눗셈을 구해주는 메소드
	/**
	 * 
	 * @param num1
	 * @param num2
	 * @return
	 * @throws ArithmeticException
	 */
	public int divFor2Integers(int num1, int num2) {
		return num1/num2;
	}
	
	public double div(double a, double b) {
		if(b==0) {
			System.out.println("분모가 0입니다.");
			//어디서 출력할지 몰라서 println을 쓰면 안된다.
			//사용하는 쪽에서 try-catch를 사용해서 오류 내용을 알려준다.
			return 0;
		}
		return a/b;
	}
	public static void main(String[] args) {
		MethodTask task = new MethodTask();
		try {
			task.printSumFrom1(0);
		} catch (Exception e1) {
			System.out.println("1보다 큰 수를 입력해주세요.");
		}
		try {
			task.divFor2Integers(10, 2);
		} catch (ArithmeticException e) {
			System.out.println("0으로 나눌 수 없습니다.");
		}
		new MethodTask().addTest(100);
		System.out.println(new MethodTask().div(18, 9));
	}
}
