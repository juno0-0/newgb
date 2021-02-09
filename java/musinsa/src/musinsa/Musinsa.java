package musinsa;


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
		String keyword = "검색 할 옷을 입력하세요 : ";
		String size = "사이즈를 알고 싶은 옷의 번호를 입력하세요 : ";
		WebElement element;
		
		driver.get(url);
		try {Thread.sleep(1000);} catch (InterruptedException e) {}
		
		element = driver.findElement(By.className("head-search-inp"));
		System.out.print(keyword);
		element.sendKeys(sc.nextLine());
		element.sendKeys(Keys.RETURN);
		try {Thread.sleep(1000);} catch (InterruptedException e) {}
		
		element = driver.findElement(By.id("searchList"));
		
		List<WebElement> brandList = element.findElements(By.className("item_title"));
		List<WebElement> nameList = element.findElements(By.className("list_info"));
		List<WebElement> priceList = element.findElements(By.className("price"));
		int rank = 0;
		for (int i = 0; i < brandList.size(); i++) {
			if(brandList.get(i).getText().isEmpty()) {break;}
			if(nameList.get(i).getText().isEmpty()) {break;}
			if(priceList.get(i).getText().isEmpty()) {break;}			
			System.out.println(++rank +". "+ "브랜드명 : "+brandList.get(i).getText()+
							   "\n제품명 : "+nameList.get(i).getText()+
							   "\n가격 : "+priceList.get(i).getText());
		}
		
		System.out.print(size);
		int choice = sc.nextInt();
		
		try {
			element.findElements(By.className("img-block")).get(choice-1).click();
			try {Thread.sleep(1000);} catch (InterruptedException e) {;}
			
			element = driver.findElement(By.className("box_material"));
			List<WebElement> sizeList = element.findElements(By.className("goods_size_val"));
			System.out.println("총장\t어깨너비\t가슴단면\t소매길이");
			System.out.print("=============================");
			for (int i = 0; i < sizeList.size(); i++) {
				if(i%4 == 0) {System.out.println();}
				System.out.print(sizeList.get(i).getText()+"\t");
			}
		} catch (Exception e) {
			System.out.println("알 수 없는 오류 발생");
		}
	}
	
	public static void main(String[] args) {
		Musinsa musinsa = new Musinsa();
		musinsa.operator();
	}
}
