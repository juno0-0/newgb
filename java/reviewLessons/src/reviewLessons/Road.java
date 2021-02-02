package reviewLessons;

public class Road{
	public static void main(String[] args) {
		Starbucks gangnam = new Starbucks();
		gangnam.register(new Cafe() {
			boolean check = false;
			
			@Override
			public void sale(String menu) throws Exception {
				String[] checkMenu = menu();
				for (int i = 0; i < checkMenu.length; i++) {
					if(checkMenu[i].equals(menu)) {
						check = true;
					}
				}
				if(check) {
					throw new Exception();
				}
			}
			
			@Override
			public int[] price() {
				int[] p = {3000, 3500, 4000};
				return p;
			}
			
			@Override
			public String[] menu() {
				String[] str = {"아메리카노", "카페라떼", "카페모카"};
				return str;
			}
		});
		System.out.println("=====================================");
		Starbucks hannam = new Starbucks();
		hannam.register(new CafeAdapter() {
			@Override
			public String[] menu() {
				String[] menu = {"둥글레차","홍차","녹차"};
				return super.menu();
			}
		});
	}
}
