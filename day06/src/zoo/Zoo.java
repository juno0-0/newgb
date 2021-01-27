package zoo;

public class Zoo {
	public static void main(String[] args) {
		Runnable p = new Animal("꿀꿀");
		Runnable d = new Animal("멍멍");
		Runnable c = new Animal("야옹");
		
		Thread pig = new Thread(p);
		Thread dog = new Thread(d);
		Thread cat = new Thread(c);
		
		pig.start();
		dog.start();
		
		try {
			pig.join();
			dog.join();
		} catch (InterruptedException e) {;}
		
		cat.start();
		
	}
}
