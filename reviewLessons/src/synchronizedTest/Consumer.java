package synchronizedTest;

public class Consumer {
	public static void main(String[] args) {
		BreadShop shop = new BreadShop();
		
		Thread son = new Thread(shop, "아들");
		Thread mom = new Thread(shop, "엄마");
		
		son.start();
		mom.start();
	}
}
