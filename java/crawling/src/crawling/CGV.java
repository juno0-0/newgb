package crawling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CGV {
	private WebDriver driver;
	private WebElement el;
	
	public static final String WEB_DRIVER_ID ="webdriver.chrome.driver";
	public static final String WEB_DRIVER_PATH ="C:\\chromedriver.exe";
	
	public static void main(String[] args) {
		CGV cgv = new CGV();
		WebElement el1 = null;
		WebElement el2 = null;
		
		//드라이버 설정
		//자바가 실행될 때 같이 실행된다.
		try {
			System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);//외부에 있는걸 가지고 올 때는 항상 try catch를 쓴다.
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		//WebDriver
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");//브라우저가 내부적으로만 돌고 눈에 보이지 않는 창으로 열리게 하는 것(quit() 써야함), 무한정 대기 상태가 되는 버그가 발생할 수 있다.
		
		cgv.driver = new ChromeDriver(options);	//options을 따로 만들었으면 초기값으로 넣어준다.
		
//		cgv.driver = new ChromeDriver();
		
		String url = "http://www.cgv.co.kr/movies/";	//크롤링 할 사이트 주소
		
		cgv.driver.get(url);	//크롤링 할 url로 가서 시작한다.
		
		try {Thread.sleep(1000);} catch (InterruptedException e) {}	//http 응답 속도보다 자바 컴파일 속도가 더 빠르기 때문에 기다려주는 것
		
		//더보기 버튼 클래스 이름 : btn-more-fontbold
		el1 = cgv.driver.findElement(By.className("btn-more-fontbold"));	//이 통채로가 url에 있는 더보기 버튼이 되는 것
		//url에서 클래스 이름이 Btn-more-fontbold인 태그를 찾아라라는 뜻
		//매개변수가 처음보는 타입이면 일단 타입쓰고 ctrl+space 해본다.
		el1.click();	//더보기 버튼을 클릭한다. 이게 동적
		
		try {Thread.sleep(1000);} catch (InterruptedException e) {}	//url에 접속하는 것보다 먼저 처리되면 오류가 날 수 있으므로 잠깐 기다리는 것
		
		//영화 정보 가지고 있는 div 태그 : sect-movie-chart
		el2 = cgv.driver.findElement(By.className("sect-movie-chart"));	//이 통채로가 모든 영화 정보를 가지고 있는 div 태그
		
		int rank = 0;
		
		//가져온 태그 안에 찾을 자식 태그가 있다면 또 한 번 findElement()를 사용할 수 있다.
		for(WebElement film : el2.findElements(By.className("title"))) {
			//이 통채로가 모든 영화 제목을 가지고 있는 태그, title이란 클래스를 가진 태그가 여러개이기 때문에 findElements를 사용
			System.out.println(++rank + ". " +film.getText());
		}
		
		try {
			if(cgv.driver != null) {
				//사용한 드라이버를 닫는 메소드
				//드라이버 연결 종료
				cgv.driver.close();//드라이버 연결을 해제하는 것, 메모리에서 해제
				
				//프로세스 종료
				cgv.driver.quit();//자바를 실행하면 브라우저가 열리는데 close만 하면 열린 브라우저가 연결만 해제되고 닫히지 않지만 quit를 쓰면 브라우저가 닫힌다.
			}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		
		
		
		
	}//end main
}//end class
