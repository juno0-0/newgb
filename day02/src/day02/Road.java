package day02;

public class Road {
	//null은 아직 어떤 주소값을 할당할 지 모를 때 쓰는 주소 초기값이다.
	//선언 후 누적연결 사용 시 초기화 방법
	//String data = "";
	//선언 후 대입 사용 시 초기화 방법
	//String data1 = null;
	
	//null은 주소값을 초기화할 때 쓰는 값(주소값에 뭘 넣을지 모를 때)
	//바로 값을 넣을꺼면 null로 초기화하고 바로 연결할꺼면 ""로 초기화
	public static void main(String[] args) {
		//[casting]
		Car matiz = new Car();
		SuperCar ferrari = new SuperCar();
		
		//up casting
		Car noOptionFerrari = new SuperCar();
		
		//down casting
		SuperCar fullOptionFerrari = (SuperCar)noOptionFerrari;
		//fullOptionFerrari.openRoof();
		
		//SuperCar brokenFerrari = (SuperCar)new Car();//오류(casting exception)
		
		System.out.println(matiz instanceof Car);
		System.out.println(matiz instanceof SuperCar);
		System.out.println(ferrari instanceof Car);
		System.out.println(ferrari instanceof SuperCar);
		
		//up casting된 객체는 타입은 부모, 값은 자식이라 둘 다 참
		System.out.println(noOptionFerrari instanceof Car);
		System.out.println(noOptionFerrari instanceof SuperCar);
		
		//down casting된 객체는 자식 타입
		System.out.println(fullOptionFerrari instanceof Car);
		System.out.println(fullOptionFerrari instanceof SuperCar);
		
//		SuperCar ferrari = new SuperCar();
//		//자식 생성자는 메모리에 올라갈 때 부모 생성자부터 올리고 올라감
//		ferrari.brand = "FERRARI";
//		ferrari.color = "RED";
//		ferrari.price = 30000;
//		
//		ferrari.enginStart();
//		ferrari.enginStop();
		
		//JSP에선 거의 쓰지 않고 Spring에서 주로 씀
//		Car myCar = new Car("벤틀리", "white", 30000);
//		Car dadyCar = new Car("벤츠", "black", 15000);
//		Car momCar = new Car("yellow", 50000);
	}
}
