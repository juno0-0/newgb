package reviewLessons;

import java.util.Random;

public class Starbucks {
	String[] menu;
	int[] price;
	
	public void register(Cafe c) {
		menu = c.menu();
		price = c.price();
		
		if(price == null) {
			System.out.println("무료 나눔입니다.");
			return;
		}
		
		System.out.println("====확인중====");
		for (int i = 0; i < menu.length; i++) {
			System.out.println(menu[i]+":"+price[i]+"원");
		}
		System.out.println("메뉴, 가격 이상 없음");
		
		try {
			c.sale(menu[new Random().nextInt(menu.length)]);
			System.out.println("판매 방식 이상 없음");
		} catch (Exception e) {
			System.out.println("등록 실패");
			return;
		}
		System.out.println("정상 등록되었습니다.");
	}
}
