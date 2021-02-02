package review_lessons_bank;

import java.util.Random;
import java.util.Scanner;

public class ATM {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int bank_choice = 0;
		int user_choice = 0;
		
		
		String name = "";
		String pw = "";
		String account = "'";
		String phone = "";
		Bank temp = null;
		int money = 0;

		boolean accountDup;
		boolean pwCheck;
		boolean phoneDup;
		boolean phoneCheck;

		// 각 은행별 개설 가능한 최대 수
		Shinhan[] arS = new Shinhan[100];
		Kookmin[] arK = new Kookmin[100];
		Woori[] arW = new Woori[100];

		// up casting
		Bank[][] arrB = { arS, arK, arW };

		// 어떤 은행타입인지 알려주는 배열
		Bank[] whatBank = { new Shinhan(), new Kookmin(), new Woori() };

		// 각 은행별 개설된 계좌 개수 확인하는 배열
		int[] bankCnt = { 0, 0, 0 };

		while (true) {
			System.out.println("1. 신한은행\n2. 국민은행\n3. 우리은행\n4. 나가기");
			System.out.print("선택 : ");
			bank_choice = sc.nextInt();
			if (bank_choice == 4) {
				break;
			}
			while (true) {
				System.out.println("1. 계좌개설\n2. 입금하기\n3. 출금하기\n4. 잔액조회\n5. 계좌번호 찾기\n6. 돌아가기");
				user_choice = sc.nextInt();
				switch (user_choice) {
				// 계좌생성
				case 1:
					System.out.print("계좌주 : ");
					name = sc.next();

					// pw가 4자리가 아니면 무한 반복
					while (true) {
						System.out.print("비밀번호 : ");
						pw = sc.next();
						if (pw.length() == 4) {
							break;
						}
					}

					// 계좌번호 랜덤생성, 중복검사 후 중복이면 무한반복
					while (true) {
						// 중복검사 flag
						accountDup = true;
						account = new Random().nextInt(900000) + 100000 + "";
						for (int i = 0; i < arrB.length; i++) {// 은행 개수만큼
							for (int j = 0; j < bankCnt[i]; j++) {
								// 계좌번호가 중복이면 accountDup를 false로 바꾸고 2번 반복문 탈출
								if (arrB[i][j].account.equals(account)) {
									accountDup = false;
									break;
								}
							}
							// accountDup가 false면 1번 반목문 탈출
							if (!accountDup) {
								break;
							}
						}
						// accountDup가 false면 다시 계좌번호 생성
						if (!accountDup) {
							continue;
						}
						break;
					}
					// 핸드폰번호 입력, 0~9외에 다른게 들어오면 무한반복, 중복검사 후 중복이면 무한반복
					while (true) {
						// 중복검사 flag
						phoneDup = false;
						phoneCheck = false;
						System.out.print("핸드폰번호 : ");
						phone = sc.next();
						for (int i = 0; i < phone.length(); i++) {
							// 아스키코드로 0~9가 아니면 다시 입력
							if (phone.charAt(i) < 48 || phone.charAt(i) > 57) {
								phoneCheck = true;
								break;
							}
						}
						// phoneCheck가 true면 다시 입력
						if (phoneCheck) {
							continue;
						}

						for (int i = 0; i < arrB.length; i++) {
							for (int j = 0; j < bankCnt[i]; j++) {
								// 다른 객체의 phone과 중복이면 phoneDup를 true로 바꾸고 2번 반복문 탈출
								if (arrB[i][j].phone.equals(phone)) {
									phoneDup = true;
									break;
								}
							}
							// phoneDup가 true면 1번 반복문 탈출
							if (phoneDup) {
								break;
							}
						}
						// phoneDup가 true면 다시 핸드폰번호 입력
						if (phoneDup) {
							continue;
						}
						break;
					}

					arrB[bank_choice - 1][bankCnt[bank_choice - 1]] = whatBank[bank_choice - 1];
					temp = arrB[bank_choice - 1][bankCnt[bank_choice - 1]];
					temp.name = name;
					temp.pw = pw;
					temp.account = account;
					temp.phone = phone;

					System.out.println("입력한 정보");
					System.out.println("name : " + temp.name);
					System.out.println("pw : " + temp.pw);
					System.out.println("account : " + temp.account);
					System.out.println("phone : " + temp.phone);
					// 다음 입력을 위해 1 증가
					bankCnt[bank_choice - 1]++;
					break;
				// 입금하기
				case 2:
					accountDup = false;
					// 계좌번호 입력받고 입금
					System.out.print("계좌번호 : ");
					account = sc.next();
					for (int i = 0; i < arrB.length; i++) {
						for (int j = 0; j < bankCnt[i]; j++) {
							// 입력받은 계좌번호가 있는지 확인
							if (arrB[i][j].account.equals(account)) {
								// 있으면 accountDup를 true로 바꾸고 temp에 배열을 넣고 2번 반복문 탈출
								accountDup = true;
								temp = arrB[i][j];
								break;
							}
						}
						// 입력받은 계좌번호가 없으면 continue;
						if (!accountDup) {
							System.out.println("잘못된 계좌번호입니다.");
							break;
						}
					}

					if (!accountDup) {
						continue;
					}
					System.out.print("입금액 : ");
					money = sc.nextInt();
					if (money < 1) {
						System.out.println("입금할 수 없는 금액입니다.");
					}
					temp.deposit(money);
					System.out.println("입금 성공!");
					System.out.println(temp.name);
					System.out.println(temp.money);
					break;
				//출금하기
				case 3:
					accountDup = false;
					pwCheck = false;
					// 계좌번호 입력받고 출금
					System.out.print("계좌번호 : ");
					account = sc.next();
					for (int i = 0; i < arrB.length; i++) {
						for (int j = 0; j < bankCnt[i]; j++) {
							// 입력받은 계좌번호가 있는지 확인
							if (arrB[i][j].account.equals(account)) {
								// 있으면 accountDup를 true로 바꾸고 temp에 배열을 넣고 2번 반복문 탈출
								accountDup = true;
								temp = arrB[i][j];
								break;
							}
						}
						// 입력받은 계좌번호가 없으면 continue;
						if (!accountDup) {
							System.out.println("잘못된 계좌번호입니다.");
							break;
						}
					}

					if (!accountDup) {
						continue;
					}
					
					System.out.print("비밀번호 : ");
					pw = sc.next();
					if(temp.pw.equals(pw)) {
						pwCheck = true;
					}else {
						System.out.println("비밀번호가 틀렸습니다.");
						continue;
					}
					
					System.out.print("출금액 : ");
					money = sc.nextInt();
					
					if(temp.money - money < 0) {
						System.out.println("잔액 부족");
					}
					temp.withdraw(money);
					System.out.println("출금 성공!");
					System.out.println(temp.name);
					System.out.println(temp.money);
					break;
				//잔액조회
				case 4:
					accountDup = false;
					pwCheck = false;
					// 계좌번호 입력받고 출금
					System.out.print("계좌번호 : ");
					account = sc.next();
					for (int i = 0; i < arrB.length; i++) {
						for (int j = 0; j < bankCnt[i]; j++) {
							// 입력받은 계좌번호가 있는지 확인
							if (arrB[i][j].account.equals(account)) {
								// 있으면 accountDup를 true로 바꾸고 temp에 배열을 넣고 2번 반복문 탈출
								accountDup = true;
								temp = arrB[i][j];
								break;
							}
						}
						// 입력받은 계좌번호가 없으면 continue;
						if (!accountDup) {
							System.out.println("잘못된 계좌번호입니다.");
							break;
						}
					}

					if (!accountDup) {
						continue;
					}
					
					System.out.print("비밀번호 : ");
					pw = sc.next();
					if(temp.pw.equals(pw)) {
						pwCheck = true;
					}else {
						System.out.println("비밀번호가 틀렸습니다.");
						continue;
					}
					System.out.println(temp.inquiry()+"원");
					break;
				//계좌번호 찾기
				//핸드폰번호, 비밀번호 입력받고 계좌 새로 발급
				case 5:
					phoneCheck = false;
					System.out.print("핸드폰번호 : ");
					phone = sc.next();
					//핸드폰번호 확인
					for (int i = 0; i < arrB.length; i++) {
						for (int j = 0; j < bankCnt[i]; j++) {
							//입력한 번호가 있으면 phoneCheck가 true
							if(arrB[i][j].phone.equals(phone)) {
								temp = arrB[i][j];
								phoneCheck = true;
								break;
							}
							
						}
						//phoneCheck가 false면 1번 반복문 탈출
						if(!phoneCheck) {System.out.println("없는 번호입니다.");break;}
					}
					//phoneCheck가 false면 처음으로 돌아감
					if(!phoneCheck) {continue;}
					System.out.print("비밀번호 : ");
					pw = sc.next();
					if(!temp.pw.equals(pw)){
						System.out.println("비밀번호가 틀렸습니다.");
						continue;
					}
					account = new Random().nextInt(900000) - 100000 + "";
					for (int i = 0; i < arrB.length; i++) {
						for (int j = 0; j < bankCnt[i]; j++) {
							if(arrB[i][j].account.equals(account)) {continue;}
							temp.account = account;
							break;
						}
						break;
					}
					System.out.println(temp.name);
					System.out.println(temp.account);
					break;
				default:
					System.out.println("다시 시도해주세요.");
					break;
				}
				if(user_choice==6) {break;}
			}
			
		}
	}
}
