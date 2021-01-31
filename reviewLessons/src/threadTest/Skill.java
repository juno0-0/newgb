package threadTest;

public class Skill implements Runnable{
	
	CoolDownTime cool = CoolDownTime.getInstance();
	
	public Skill() {;}
	
	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			cool.useSkill();
			try {Thread.sleep(300);} catch (InterruptedException e) {;}
		}
		System.out.println("게임 종료");
	}
	
}
