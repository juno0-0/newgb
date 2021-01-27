package bakery;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Bakery {
	public static void main(String[] args) {
		BreadMaker maker = new BreadMaker();
		BreadPlate plate = BreadPlate.getInstance();
		Thread makerThread = new Thread(maker);		
		String[] menu = {"빵먹기","나가기"};

		//이미지 아이콘 만들기
		//사이즈 조정 : Image클래스로 변환해서 설정해야 함.
		ImageIcon icon = new ImageIcon("src/img/main.gif");
		
		makerThread.start();
		
		while(true) {
			//옵션을 보여준다.
			int choice = JOptionPane.showOptionDialog(null, "", "빵집", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, menu, null);
			//부모컴포넌트, 메시지, 타이틀, DEFAULT, 기본이미지를 없애는 것, 이미지객체, 버튼배열, 처음에 선택되어 있는 버튼
			//버튼을 누르면 버튼배열의 인덱스가 리턴, x를 누르면 -1
			
			//여기서 break;를 쓰면 나가기를 눌러도 빵은 계속 만들어짐
			if(choice == 1||choice == -1) {System.exit(0);}
			
			plate.eatBread();
		}
	}
}
