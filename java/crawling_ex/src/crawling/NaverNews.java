package crawling;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class NaverNews {
	private WebDriver driver;
	private String url;
	
	public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
	public static final String WEB_DRIVER_PATH = "C://chromedriver.exe";
	
	public NaverNews() {
		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		driver = new ChromeDriver(options);
		
		url = "http://news.naver.com";
	}
	
	public void operator() {
		news();
		try {
			if(driver!=null) {
				driver.close();
				driver.quit();
			}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public void news() {
		Scanner sc = new Scanner(System.in);
		String searchMsg = "읽어보고 싶은 기사의 번호를 선택하세요 : ";
		
		WebElement element = null;
		driver.get(url);
		try {Thread.sleep(1000);} catch (InterruptedException e) {;}
		
		element = driver.findElement(By.className("main_component"));
		List<WebElement> list = element.findElements(By.className("hdline_article_tit"));
		
		int rank = 0;
		for (int i = 0; i < list.size(); i++) {
			System.out.println(++rank + ". " +list.get(i).getText());
		}
		
		System.out.print(searchMsg);
		try {
			int choice = sc.nextInt();
			
			element.findElements(By.className("lnk_hdline_article")).get(choice-1).click();
			try {Thread.sleep(1000);} catch (InterruptedException e) {;}
			
			element = driver.findElement(By.id("articleBodyContents"));
			System.out.println(element.getText());
		} catch (Exception e) {
			System.out.println("해당하는 기사가 없습니다.");
			return;
		}
		
		
		
	}

	public static void main(String[] args) {
		NaverNews n = new NaverNews();
		n.operator();
	}
	
}

