package inter;

public class InplTest implements InterA, InterB{
	
	@Override
	public void printName() {
		InterA.super.printName();
	}
	
	public static void main(String[] args) {
		new InplTest().printName();
	}

}
