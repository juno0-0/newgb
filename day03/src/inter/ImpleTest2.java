package inter;

public class ImpleTest2 extends SuperImplTest2 implements InterA{//좌에서 우로 갈 때 부모클래스를 먼저 만나기 때문에 부모클래스의 메소드가 호출되는 것
	
//	@Override
//	public void printName() {
//		InterA.super.printName();
//	}
	
	public static void main(String[] args) {
		new ImpleTest2().printName();
	}
}
