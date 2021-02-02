package day06;

public class ThreadTest {
	public static void main(String[] args) {
		//Runnable implements하는 경우
		Runnable t1 = new Thread2("?");
		Runnable t2 = new Thread2("!");
		
		//start()메소드로 스케줄링하기 위해서 Thread 타입 객체가 필요하다.
		//Thread 생성자에 run메소드가 재정의된 객체를 전달해주면
		//스케줄링 시 해당 run메소드가 자원으로 할당된다.
		Thread thread1 = new Thread(t1);
		Thread thread2 = new Thread(t2);
		
		thread1.start();
		thread2.start();
		
		
		
		//Thread 상속받는 경우
//		//윈도우 + 마침표 = 이모지
//		Thread1 t1 = new Thread1("★");
//		Thread1 t2 = new Thread1("♥");
//		//스케줄링을 따로 하지 않아서 지금 쓰레드는 main뿐 = 단일 쓰레드
//		
//		//t1.run();
//		//t2.run();
//		
//		t1.start();
//		t2.start();
//		
//		
//		try {
//			//join() : 먼저 실행하고 싶은 쓰레드에 붙인다. 다른 쓰레드를 대기 상태로 만든다.
//			//			해당 쓰레드가 모두 종료되어야 다른 쓰레드가 실행된다.
//			t1.join();
//			t2.join();
//		} catch (InterruptedException e) {;}
//		
//		System.out.println("메인쓰레드 종료");
//		
//		
//		
	}
}
