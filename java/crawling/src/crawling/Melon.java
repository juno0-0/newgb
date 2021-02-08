package crawling;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Melon {
	private WebDriver driver;
	private String url;
	
	//여기서 오타 조심하자
	public static final String WEB_DRIVER_ID ="webdriver.chrome.driver";
	public static final String WEB_DRIVER_PATH ="C:\\chromedriver.exe";
	
	public Melon() {
		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		driver = new ChromeDriver(options);
		
		url = "https://www.melon.com/";
		//new Melon()을 하면 이동할 브라우저의 url이 저장된다.
	}
	
	public void operate() {
		searchSong();
		//드라이버 종료
		try {
			if(driver != null) {
				driver.close();
				driver.quit();
			}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	//태그를 객체로 보는 것이 익숙해져야 한다.
	//내가 원하는 태그를 정확히 가져오는 연습을 해야 아픙로 배울 Javascript도 쉽게 다룰 수 있다.
	public void searchSong() {
		//메인 로직
		
		//노래제목을 Scanner로 입력받고, 검색 결과를 뿌려준 후 사용자가 선택한 노래의 가사를 출력해준다.
		
		//1. 사용자가 입력한 키워드를 멜론 사이트 검색창에 넣어주기
		//2. 입력한 값으로 검색(엔터)해준다.
		//※ 엔터 입력 : 태그객체.sendKeys(Keys.RETURN);
		//3. 검색 결과가 없다면 알맞는 메세지 출력
		//검색한게 해당 사이트에 없으면 NoSuchElementException(셀레니움 패키지 꼭 확인) 발생
		//4. 사용자에게 검색된 곡 정보들을 출력해준다.(10개)
		//5. 사용자가 입력한 번호에 맞는 곡의 가사를 출력해준다.
		//6. 가사가 없거나 성인곡이라면 알맞는 메세지를 출력해준다.
		
		Scanner sc = new Scanner(System.in);
		String searchMsg = "노래 제목 : ";
		String lyricNumMsg = "곡 번호 : ";
		WebElement element = null;
		//변수의 재사용 : 더 이상 사용되지 않는 것을 다시 사용하는 것(직속상관에게 물어보고 사용한다.)
		//장점 : 메모리 효율, 절약
		//단점 : 가독성이 떨어진다.
		
		driver.get(url);//브라우저를 보이지 않는 창으로 연다.
		try {Thread.sleep(1000);} catch (InterruptedException e) {;}
		
		//검색 창 태그 가져오기 ui-autocomplete-input
		element = driver.findElement(By.className("ui-autocomplete-input"));//검색창이 있는 fieldset 태그
		
		//사용자가 입력한 키워드를 멜론 사이트 검색창에 넣어주기
		System.out.print(searchMsg);
		//태그객체.sendKeys(sc.nextLine());//sc.next()는 사용자가 입력한 문자열 값
		element.sendKeys(sc.nextLine());//노래 제목에 띄어쓰기가 있을 수 있어서 nextLine()을 쓴다.
		//sc.nextLine();//위에서 next()를 썼다면 마지막 엔터가 남기 때문에 그걸 먹어주는 애
		
		//엔터 입력
		element.sendKeys(Keys.RETURN);
		
		//검색 결과페이지 로딩 대기
		try {Thread.sleep(1000);} catch (InterruptedException e) {;}
		
		try {
			//곡명으로 검색된 결과를 담고 있는 form태그 객체 frm_searchSong
			//driver로 검색하면 전체, 태그명으로 검색하면 그 태그 안에서 검색
			element = driver.findElement(By.id("frm_searchSong"));//기존의 element에 담겨져 있는건 페이지가 바뀌어서 사용할 일이 없기 때문에 재사용한다.
			
			//곡 번호 가져오기 no
			List<WebElement> numList = element.findElements(By.className("no"));
			
			//곡명 가져오기 fc_gray
			List<WebElement> titleList = element.findElements(By.className("fc_gray"));
			
			//아티스트 가져오기
			//class명이 중복이라 다른 것도 가져오면 부모의 id나 class를 확인해보고 중복이 아니면 가져오자.
			List<WebElement> artistList = element.findElements(By.id("artistName"));
			//부모 태그에서 getText()를 쓰면 그 안에 있는 Text를 가져오는데 없다면 자식으로 가서 Text를 찾아서 있으면 자식의 Text를 가져온다.
			
			//가져온 데이터를 통해 목록 출력
			for(int i=0; i<numList.size();i++) {
				//numList.get(i)까지 하면 태그 객체
				System.out.println(numList.get(i).getText() + ". " +
								   titleList.get(i).getText() + ", 아티스트 : " +
								   artistList.get(i).getText());
			}
			
			//번호 입력
			System.out.print(lyricNumMsg);
			int num = sc.nextInt();
			
			//입력한 번호의 가사 보기 버튼 클릭(입력한 번호 -1번재 방의 가사 버튼) btn_icon_detail
			element.findElements(By.className("btn_icon_detail")).get(num - 1).click();//버튼이 여러개니까 복수
			try {Thread.sleep(1000);} catch (InterruptedException e) {;}
			
			try {
				driver.findElement(By.className("d_register"));//이 버튼이 없으면 가사가 있거나 성인 노래, 있으면 가사가 없는 것
				System.out.println("가사가 없는 곡입니다.");
			} catch (NoSuchElementException e1) {
				//가사 펼치기 클릭 button_more
				try {
					driver.findElement(By.className("button_more")).click();//펼치기 버튼 1개라서 단수, 클릭하려고 가져온거라 담을 필요 없음
					try {Thread.sleep(1000);} catch (InterruptedException e) {;}
					
					//가사 가져와서 출력하기 lyric(on이라는 이름은 on/off에 사용하는 것)
					element = driver.findElement(By.className("lyric"));
					System.out.println(element.getText());
				} catch (Exception e) {
					//가사 펼치기 버튼이 없다면 성인 노래
					System.out.println("성인 노래 가사는 열람하실 수 없습니다.");
				}
			}
			
			//예외하기
		} catch (NoSuchElementException e) {
			System.out.println("검색 결과가 없습니다.");
		} catch (Exception e) {
			System.out.println("알 수 없는 오류");
		}
		
		
		
	}
	
	public static void main(String[] args) {
		Melon melon = new Melon();
		melon.operate();
	}//end main
	
}//end class
