package atm;

public class ATM implements Runnable{
	
	int money = 10_000;
	
	@Override
	public /*synchronized*/ void run() {// run()에 동기화를 걸면 단일 쓰레드처럼 된다.
		for (int i = 0; i < 5; i++) {
			//동기화 블럭
			synchronized (this) {
				withdraw(1000);
			}
			try {Thread.sleep(500);} catch (InterruptedException e){;}
		}
	}
	
	//동기화 키워드(메소드)
	public /*synchronized*/ void withdraw(int money) {
		this.money -= money;
		System.out.println(Thread.currentThread().getName()+"이(가) "+money+"원 출금");
		System.out.println("현재 잔액 "+this.money+"원");
	}
}
