package bank;

import java.awt.Menu;
import java.util.Random;
import java.util.Scanner;

public class ATM {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		//각 은행별로 최대 100명의 고객을 유치할 수 있다.
		Shinhan[] arS = new Shinhan[100];
		Kookmin[] arK = new Kookmin[100];
		Woori[] arW = new Woori[100];
		
		Bank[] arNewMember = {new Shinhan(), new Kookmin(), new Woori()};
		
		Bank[][] arrBank = {arS, arK, arW};
		int cnt = 0;
		//참고
//		int choice = 1;
//		arrBank[choice-1][0] = arNewMember[choice-1];
		
		//메인메뉴 : 은행 선택(신한, 국민, 우리)
		while(true) {
			System.out.println("은행 선택");
			System.out.println("1. 신한은행");
			System.out.println("2. 국민은행");
			System.out.println("3. 우리은행");
			System.out.println("4. 나가기");
			System.out.print("선택 : ");
			int choice = sc.nextInt();
			switch(choice) {
				case 1: case 2: case 3:
					System.out.println("1. 계좌개설");
					System.out.println("2. 입금하기");
					System.out.println("3. 출금하기");
					System.out.println("4. 잔액조회");
					System.out.println("5. 계좌번호 찾기");
					System.out.println("6. 돌아가기");
					System.out.print("선택 : ");
					int select = sc.nextInt();
					if(select == 1) {
						System.out.println("계좌 개설");
						System.out.println("======");
						System.out.print("예금주 : ");
						String name = sc.next();
						System.out.print("비밀번호 : ");
						String pw = sc.next();
						if(pw.length()!=4) continue;
						String account = String.valueOf(new Random().nextInt(899999)+100000);
						System.out.println("계좌번호 : "+account);
						System.out.print("핸드폰번호 : ");
						String phone = sc.next();
						arNewMember[choice-1] = new Shinhan(name, pw, account, phone); 
						arrBank[choice-1][cnt] = arNewMember[choice-1];
						for (int i = 0; i < arrBank.length; i++) {
							for (int j = 0; j < arrBank[0].length; j++) {
								if(arrBank[i][j].account.equals(arNewMember[choice-1].account)) {
									System.out.println("계좌번호 중복");
									continue;
								}
							}
						}
						
					}
					break;
				case 4:
					System.exit(0);
					break;
				default:
					break;
			}
			

	
						

		}//end while



		
		//사용자 메뉴 : 계좌개설, 입금하기, 출금하기, 잔액조회, 계좌번호 찾기, 돌아가기
		
		//계좌 개설 시 필요한 정보
		//1. 예금주
		//2. 비밀번호(비밀번호는 4자리이고, 4자리를 입력할 때 까지 무한반복)
		//3. 계좌번호(계좌번호는 6자리이며, 100000부터 시작한다. 중복검사 후 중복이 없을 때 까지 무한반복)
		//new Random().nextInt() 사용
		//4. 핸드폰 번호(-를 제외하고 입력받으며, 중복검사 후 중복이 없을 때 까지 무한 반복)
		//아스키코드로 검색
		//0(33)~9(42)
		
		//※ 중복검사는 해당 은행의 고객 수 만큼만 반복하여 검사한다.
		
		//계좌번호 찾기 구현방법
		//핸드폰 번호와 비밀번호를 입력한 후 일치하는 고객의 계좌번호를 재발급해준다.
	
		
		
	}
}
