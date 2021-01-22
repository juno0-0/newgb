package inter;

public interface InterA {
	 
//	int data = 10; // final static 생략
//	
//	void getData(); //abstract 생략
	
	default void printName() {
		System.out.println("한동석 InterA");
	}
	
}
