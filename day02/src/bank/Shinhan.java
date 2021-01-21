package bank;

public class Shinhan extends Bank{
	
	public Shinhan() {}

	public Shinhan(String name, String pw, String account, String phone) {
		this.name = name;
		this.pw = pw;
		this.account = account;
		this.phone = phone;
	}
	
	//출금 시 수수료 50%
	@Override
	public boolean withdraw(int money) {
		//출금 수수료가 50%이기 때문에 출금할 금액에 1.5배를 부모의 withdraw로 전달한다.
		money *= 1.5;
		return super.withdraw(money);
	}
}
