package crawling;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Humoruniv {
	private WebDriver driver;
	private String url;
	
	//System.setProperty()의 매개값
	public static final String WEB_DRIVER_ID ="webdriver.chrome.driver";
	public static final String WEB_DRIVER_PATH ="C:\\chromedriver.exe";
	
	//기본 생성자
	public Humoruniv() {
		//드라이버 설정
		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
		
		//옵션주기
		ChromeOptions options = new ChromeOptions();
		//브라우저 창을 눈에 안보이게 실행
		options.addArguments("headless");
		driver = new ChromeDriver(options);
		
		//접속할 주소
		url = "http://web.humoruniv.com/main.html";
	}
	
	public void operator() {
		happy();
		try {
			if(driver != null) {
				driver.close();
				driver.quit();
			}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public void happy() {
		Scanner sc = new Scanner(System.in);
		WebElement element = null;
		String msg = "메뉴를 선택해주세요.\n1. 웃긴 자료\n2. 공포 베스트\n3. 종료\n선택 : ";
		String choiceMsg = "댓글을 볼 글의 번호를 입력하세요 : ";
		String fearMsg = "본문을 볼 글의 번호를 입력하세요 : ";
		
		//브라우저 열기
		driver.get(url);
		try {Thread.sleep(1000);} catch (InterruptedException e) {;}
		
		System.out.print(msg);
		String check = sc.next();
		if(check.equals("1")) {
			element = driver.findElement(By.className("best_right"));
			element.findElement(By.className("more")).click();
			try {Thread.sleep(1000);} catch (InterruptedException e) {;}
			
			element = driver.findElement(By.id("post_list"));
			List<WebElement> list = element.findElements(By.className("li"));
			int rank = 0;
			for (int i = 0; i < list.size(); i++) {
				System.out.println(++rank + ". " +list.get(i).getText());
			}
			
			try {
				System.out.println(choiceMsg);
				int choice = sc.nextInt();
				
				element.findElements(By.className("li")).get(choice - 1).click();
				try {Thread.sleep(1000);} catch (InterruptedException e) {;}
				
				element = driver.findElement(By.id("wrap_cmt_new"));
				List<WebElement> cmList = element.findElements(By.className("cmt_list"));
				List<WebElement> nickList = element.findElements(By.className("hu_nick_txt"));
				for (int i = 0; i < cmList.size(); i++) {
					System.out.println(nickList.get(i).getText() +":"+ cmList.get(i).getText());
				}
			} catch (Exception e) {
				System.out.println("없는 번호입니다.");
			}
		}else if(check.equals("2")) {
			element = driver.findElement(By.className("wrap_list"));
			element.findElement(By.className("more_small")).click();
			try {Thread.sleep(1000);} catch (InterruptedException e) {;}
			element = driver.findElement(By.id("cnts_list_new"));
			System.out.println("TEST");
			List<WebElement> fearList = element.findElements(By.className("li"));
			int rank = 0;
			for (int i = 0; i < fearList.size(); i++) {
				System.out.println(++rank + ". " + fearList.get(i).getText());
			}
			
			System.out.print(fearMsg);
			int choice = sc.nextInt();
			element.findElements(By.className("li")).get(choice-1).click();
			try {Thread.sleep(1000);} catch (InterruptedException e) {;}
			System.out.println("TEST1");
			element = driver.findElement(By.id("ai_cm_content"));
			System.out.println(element.getText());
		}else if(check.equals("3")){
			System.out.println("프로그램을 종료합니다.");
		}else {
			System.out.println("메뉴 중에 하나를 선택해주세요.");
		}
	}
	
	public static void main(String[] args) {
		Humoruniv h = new Humoruniv();
		h.operator();
		
	}
}
