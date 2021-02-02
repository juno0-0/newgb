package threadTest;

public class CoolDownTime {
	int coolTime = 10;
	boolean SkillTime = true;
	
	private static CoolDownTime ct = new CoolDownTime();
	
	private CoolDownTime() {;}
	
	public static CoolDownTime getInstance() {
		return ct;
	}
	
	public synchronized void startCool() {
		if(coolTime == 0) {
			System.out.println("쿨타임");
			try {wait();} catch (InterruptedException e) {;}
		}
		coolTime = 10;
		System.out.println("스킬을 사용할 수 있습니다.");
	}
	
	public synchronized void useSkill() {
		if(!SkillTime) {
			System.out.println("스킬이 준비되지 않았습니다."+coolTime);
		}else if(coolTime > 1) {
			System.out.println("아직 쿨타임이 끝나지 않았습니다.");
		}else {
			SkillTime = false;
			coolTime--;
			System.out.println("매직 클로!");
			this.notify();
		}
	}
}
