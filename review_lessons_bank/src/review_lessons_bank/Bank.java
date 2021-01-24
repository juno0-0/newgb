package review_lessons_bank;

public class Bank {
	//돈
	int money;
	//예금주
	String name;
	//계좌번호
	String account;
	//비밀번호
	String pw;
	//핸드폰번호
	String phone;
	
	//입금
	public void deposit(int money){
		if(money < 0) {
			throw new ArithmeticException();
		}
		this.money += money;
	}
	
	//출금
	public void withdraw(int money) {
		if(this.money - money < 0) {
			throw new ArithmeticException();
		}
		this.money -= money;
	}
	
	//잔액조회
	public int inquiry() {
		return money;
	}
}
