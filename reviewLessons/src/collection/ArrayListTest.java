package collection;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {
	public static void main(String[] args) {
		ArrayList<Integer> array = new ArrayList<>();
		array.add(10);
		array.add(20);
		array.add(30);
		array.add(10);		
		array.add(40);
		array.add(50);
		array.add(10);
		array.add(20);

		// 추가하기
		array.add(30);
		System.out.println(array);

		// 삽입하기
		// 30뒤에 100 삽입하기
		int idx = 0;
		String msg = "";
		if (array.contains(30)) {
			idx = array.indexOf(30);
			array.add(idx + 1, 100);// 여기서 idx에 +1을 하지 않으면 30 앞에 들어간다.
			msg = "삽입 성공!";
		} else {
			msg = "값을 찾을 수 없습니다.";
		}
		System.out.println(msg + array);

		// 수정하기
		// 50을 500으로 수정하기
		if (array.contains(50)) {
			idx = array.indexOf(50);
			array.set(idx, 500);
			msg = "수정 성공!";
		} else {
			msg = "값을 찾을 수 없습니다.";
		}
		System.out.println(msg + array);

		// 삭제하기
		// 40을 삭제하기
		if(array.contains(40)) {
			array.remove(new Integer(40));
			msg = "삭제 성공!";
		}else {
			msg = "값을 찾을 수 없습니다.";
		}
		System.out.println(msg + array);
		
		// 마지막에 있는 10을 삭제
		try {
			array.remove(array.lastIndexOf(new Integer(10)));
			msg = "삭제 성공!";
		} catch (Exception e) {
			msg = "값을 찾을 수 없습니다.";
		}
		System.out.println(msg + array);
		
		// 2번째 나오는 10을 삭제하기
		ArrayList<Integer> temp = new ArrayList<>();
		for (int i = 0; i < array.size(); i++) {
			if((array.get(i).intValue()==10)) {
				temp.add(i);
			}
		}
		try {
			array.remove(temp.get(1).intValue());	// 여기서 intValue()를 사용하는 이유는 get()은 Integer를 리턴하기 때문이다.
			msg = "삭제 성공!";
		} catch (Exception e) {
			msg = "값을 찾을 수 없습니다.";
		}
		System.out.println(msg + array);
		
	}
}
