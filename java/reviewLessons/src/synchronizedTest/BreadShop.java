package synchronizedTest;

public class BreadShop implements Runnable{
	private int bread = 20;
	
	public BreadShop() {;}
	
	public void eat() {
		bread--;
		System.out.println(Thread.currentThread().getName()+"가 빵을 먹었습니다. " + bread);
	}
	
	@Override
	public synchronized void run() {
		for (int i = 0; i < 10; i++) {
			eat();
			try {Thread.sleep(300);} catch (InterruptedException e) {;}
		}
	}
	
	
}
