package crawling;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Webtoon {
	private WebDriver driver;
	private String url;
	
	//setProperty의 매개값
	public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
	public static final String WEB_DRIVER_PATH = "C:\\chromedriver.exe";
	
	public Webtoon() {
		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
		ChromeOptions options = new ChromeOptions();
		//headless : 브라우저 창이 내부적으로는 실행되지만 눈에 보이지 않게 하는 옵션 
		options.addArguments("headless");
		driver = new ChromeDriver(options);
		//만약 실행했을 때 브라우저 창을 보고 싶다면
		//driver = new ChromeDriver();
		
		//실행할 브라우저 주소를 url에 저장
		url = "https://comic.naver.com/webtoon/weekday.nhn";
	}
	
	//driver를 닫아주는 메소드
	public void operator() {
		//실행할 메소드
		weekWebtoon();
		try {
			//만약 드라이버가 닫히지 않았다면 여기서 닫아준다.
			if(driver != null) {
				driver.close();
				driver.quit();
			}
		} catch (Exception e) {
			//위에서도 driver가 닫히지 않을 경우 강제로 예외 발생
			throw new RuntimeException(e.getMessage());
		}
	}
	

	
	public void weekWebtoon() {
		Scanner sc = new Scanner(System.in);
		String day = "어떤 웹툰이 업데이트 되는지 궁금한 요일을 입력하세요(월~일) : ";
		
		//실행과 동시에 url로 이동한다.
		driver.get(url);
		//페이지가 이동하는 경우 컴파일 속도가 더 빠르기 때문에 기다려준다.
		try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
		
		System.out.print(day);
		switch(sc.next()) {
			case "월": craw(1); break;
			case "화": craw(2); break;
			case "수": craw(3); break;
			case "목": craw(4); break;
			case "금": craw(5); break;
			case "토": craw(6); break;
			case "일": craw(7); break;
			default: System.out.println("잘못 입력하셨습니다."); break;
		}
	}
	
	public void craw(int num) {
		Scanner sc = new Scanner(System.in);
		WebElement element;
		String episodes = "몇 화까지 나온지 궁금한 웹툰 번호를 입력하세요 : ";
		
		driver.findElement(By.className("category_tab")).findElements(By.tagName("li")).get(num).click();
		try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
		
		int cnt = 0;
		//월요 웹툰 전체가 들어있는 변수
		element = driver.findElement(By.className("img_list"));
		//제목이 들어있는 리스트
		List<WebElement> name = element.findElements(By.tagName("dt"));
		//작가가 들어있는 리스트
		List<WebElement> writer = element.findElements(By.className("desc"));
		//평점이 들어있는 리스트
		List<WebElement> score = element.findElements(By.tagName("strong"));
		
		//웹툰명, 작가명, 평점 출력
		for (int i = 0; i < score.size(); i++) {
			System.out.println(++cnt + ". 웹툰명 : " + name.get(i).findElement(By.tagName("a")).getAttribute("title") + ", 작가명 : " + writer.get(i).getText() + ", 평점 : " + score.get(i).getText() + "점");
		}
		
		//긁어온 웹툰 이름들에 번호를 매겨서 그 웹툰이 몇 화까지 나온지 알 수 있게 한다.
		System.out.print(episodes);
		int choice = sc.nextInt();
		
		//choice를 이용하여 해당 웹툰 클릭
		element.findElements(By.className("thumb")).get(choice - 1).click();
		try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
		
		element = driver.findElement(By.className("viewList"));
		List<WebElement> a_few_episodes = element.findElements(By.className("title"));
		
		for (int i = 0; i < a_few_episodes.size(); i++) {
			System.out.println(a_few_episodes.get(i).getText());
		}
	}
	
	public static void main(String[] args) {
		Webtoon webtoon = new Webtoon();
		webtoon.operator();
	}
}
