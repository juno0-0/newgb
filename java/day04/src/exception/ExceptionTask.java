package exception;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionTask {
	public static void main(String[] args) {
//		try {
//			System.out.println(10/0);
//		} catch (ArithmeticException e) {
//			//System.out.println(e);// 어떤 예외가 발생했는지 알아보는 법
//			System.out.println("0으로 나눌 수 없습니다.");
//		}

		// 여러번 정수를 입력할 수 있으나,
		// 5개의 정수만 입력하는 프로그램
		// q를 입력하면 나가기
		/*
		 * int[] arInt = new int[5]; Scanner sc = new Scanner(System.in); for (int i =
		 * 0; i < 30; i++) { System.out.print("입력 : "); try { arInt[i] = sc.nextInt();
		 * if(arInt[i] == 'q') {break;} } catch (ArrayIndexOutOfBoundsException e) {
		 * System.out.println("더 이상 입력할 수 없습니다."); break; } catch
		 * (InputMismatchException e1) { System.out.println("종료합니다."); break; } }
		 */

		Scanner sc = new Scanner(System.in);
		int[] arData = new int[5];

		int idx = 0;
		String temp = null;

		while (true) {
			System.out.print(++idx + "번째 정수 입력[q:나가기] : ");

			// 사용자가 입력받은 값을 임시 저장소에 담는다.
			temp = sc.next();

			if (temp.equals("q")) {
				break;
			}

			try {
				// 예외가 발생할 수 있는 문장을 작성한다.
				arData[idx - 1] = Integer.parseInt(temp);
			} catch (NumberFormatException e) {
				// 단순히 예외만 잡을꺼면 Exception으로 잡아도 되는데
				// 이런 상황에는 이렇게 처리하겠다 할 때는 정확한 예외명을 적어준다.
				// temp는 q도 아니고 정수도 아닌 값이 들어있을 때 오는 영역
				System.out.println("정수 또는 \'q\'만 입력해주세요.");
				// idx를 복구시킨다.
				idx--;
			} catch (ArrayIndexOutOfBoundsException e) {
				// 입력한 정수가 5개를 초과했을 때 들어오는 영역
				System.out.println("더 이상 정수를 입력하실 수 없습니다.");
				// Arrays.toString : 배열이 [,]로 구분해서 나온다.
				System.out.println(Arrays.toString(arData));
				// 더 이상의 반복은 무의미하므로 바로 종료해준다.
				break;
			}
		}
	}
}
