package zoo;

public class Zoo {
	public static void main(String[] args) {
		Animal pig = new Animal("꿀꿀");
		Animal tiger = new Animal("어흥");
		Animal sheep = new Animal("메");

		Thread pigT = new Thread(pig);
		Thread tigerT = new Thread(tiger);
		Thread sheepT = new Thread(sheep);

		pigT.start();
		tigerT.start();

		try {
			pigT.join();
			tigerT.join();
		} catch (InterruptedException e) {;}

		sheepT.start();
	}
}