package crawling;

import java.util.List;
import java.util.Scanner;

import javax.swing.text.AbstractDocument.BranchElement;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Musinsa {
	private WebDriver driver;
	private String url;
	
	public static final String WEB_DRIVER_ID ="webdriver.chrome.driver";
	public static final String WEB_DRIVER_PATH ="C:\\chromedriver.exe";
	
	public Musinsa() {
		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		driver = new ChromeDriver(options);
		
		url = "https://store.musinsa.com/";
	}
	
	public void operator() {
		search();
		try {
			if(driver != null) {
				driver.close();
				driver.quit();
			}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public void search() {
		Scanner sc = new Scanner(System.in);
		String keyword = "검색 할 의류를 입력하세요. : ";
		String size = "번호를 선택하세요 : ";
		WebElement element;
		
		driver.get(url);
		
		element = driver.findElement(By.className("head-search-inp"));
		System.out.print(keyword);
		element.sendKeys(sc.nextLine());
		element.sendKeys(Keys.RETURN);
		try {Thread.sleep(1000);} catch (InterruptedException e) {}
		
		element = driver.findElement(By.className("result-list-content"));
		
		List<WebElement> brandList = element.findElements(By.className("item_title"));
		List<WebElement> nameList = element.findElements(By.className("list_info"));
		List<WebElement> priceList = element.findElements(By.className("price"));
		int rank = 0;
		for (int i = 0; i < brandList.size(); i++) {
			if(brandList.get(i).getText().isEmpty()) {break;}
			System.out.println(++rank +". "+ "브랜드명 : "+brandList.get(i).getText()+
							   " 제품명 : "+nameList.get(i).getText()+
							   " 가격 : "+priceList.get(i).getText());
		}
		
		System.out.println(size);
		int choice = sc.nextInt();
		
		
		
		
	}
	
	public static void main(String[] args) {
		Musinsa musinsa = new Musinsa();
		musinsa.operator();
	}
}
