package bank;

public class Bank {
	//객체
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
		
	public Bank() {}	
	
	public Bank(String name, String account, String pw, String phone) {
		this.name = name;
		this.account = account;
		this.pw = pw;
		this.phone = phone;
	}



	//메소드
	//입금
	/**
	 * 
	 * @param money
	 * @throws ArithmeticException
	 */
	public void deposit(int money) {
		if(money < 0) throw new ArithmeticException();
		this.money += money;
	}
	
	//출금
	public boolean withdraw(int money) {
		if(this.money - money < 0) {
			return false;
		}
		this.money -= money;
		return true;
	}
	
	//잔액조회
	public int getBalance() {
		return this.money;
	}
}
