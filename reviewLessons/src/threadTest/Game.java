package threadTest;

import javax.swing.JOptionPane;

public class Game {
	public static void main(String[] args) {
		Skill skill = new Skill();
		CoolDownTime cool = CoolDownTime.getInstance();
		Thread t = new Thread(skill);
		String[] menu = {"매직 클로", "나가기"};
		
		t.start();
		
		while(true) {
			int choice = JOptionPane.showOptionDialog(null, "", "TEST", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, 
					null, menu, null);
			if(choice == 1||choice == -1) {System.exit(0);}
			cool.useSkill();
		}
	}
}
