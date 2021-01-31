package zoo;

public class Animal implements Runnable {
	private String sound;

	public Animal() {;}

	public Animal(String sound) {
		this.sound = sound;
	}

	public void makeSound(String sound) {
		System.out.println(sound);
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			makeSound(sound);
			try {Thread.sleep(300);} catch (InterruptedException e) {;}
		}
	}
}
