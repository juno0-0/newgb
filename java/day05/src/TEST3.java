import java.util.ArrayList;
import java.util.Iterator;

public class TEST3 {
	public static void main(String[] args) {
		ArrayList<String> names = new ArrayList<>();
		names.add("아이유");
		names.add("이지은");
		names.add("IU");
		names.add("조유리");
		names.add("김채원");
		names.add("이채령");
		
		//추가
		names.add("이채원");
		System.out.println(names);
		
		//삽입
		//IU 뒤에 장원영 삽입
		int idx = names.indexOf("IU");
		//add(index, Object o) index 앞에 삽입되므로 +1을 해준다.
		names.add(idx+1, "장원영");
		System.out.println(names);
		
		//수정
		//이지은을 이지금으로 수정
		if(names.contains("이지은")) {
			idx = names.indexOf("이지은");
			names.set(idx, "이지금");
			System.out.println(names);
		}
		
		//삭제
		//이채원 삭제
		if(names.contains("이채원")) {
			names.remove("이채원");
			System.out.println(names);
		}
	}
}
