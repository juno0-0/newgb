package review_lessons_bank;

public class Woori extends Bank{
	//조회 시 전재산 반토막
	@Override
	public int inquiry() {
		this.money *= 0.5;
		return super.inquiry();
	}
}
