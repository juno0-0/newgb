package reviewLessons;

public interface Cafe {
	String[] menu();
	int[] price();
	void sale(String menu) throws Exception;
}
