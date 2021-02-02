package day02;

class A{
	int data1;
	double data2;
	
	void setData1(int data1) {
		this.data1 = data1;
		//하나의 응용프로그램에서는 this가 단 하나
		//this가 주소값을 받아준다.
		System.out.println("this : "+this);
	}
}

public class ClassTest1 {
	public static void main(String[] args) {
		A a = new A();
		A b = new A();
	
		System.out.println("a객체 : "+a);
		System.out.println("b객체 : "+b);
		
		a.setData1(10);//104번지
		b.setData1(100);//204번지
		
//		System.out.println(a.data1);
//		System.out.println(b.data1);
	}
}
















