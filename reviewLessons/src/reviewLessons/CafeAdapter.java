package reviewLessons;

public abstract class CafeAdapter implements Cafe{
	@Override
	public String[] menu() {
		return null;
	}
	
	@Override
	public int[] price() {
		return null;
	}
	
	@Override
	public void sale(String menu) throws Exception {;}
}
