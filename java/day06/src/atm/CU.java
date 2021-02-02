package atm;

public class CU {
	public static void main(String[] args) {
		ATM atm = new ATM();
		
		Thread mom = new Thread(atm, "엄마");
		Thread son = new Thread(atm, "아들");
		
		mom.interrupt();//쓰레드를 종료시켜주는 메소드
		
		mom.start();
		son.start();
	}
}
