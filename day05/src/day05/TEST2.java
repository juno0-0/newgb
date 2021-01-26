package day05;

import java.util.ArrayList;
import java.util.Iterator;

public class TEST2 {
	ArrayList<String> all = new ArrayList<>();
	
	public ArrayList<String> nameTest(String name) {
		all.add(name);
		return all;
	}

	public static void main(String[] args) {
		TEST2 t = new TEST2();
		t.nameTest("홍길동");
		t.nameTest("고길동");
		System.out.println(t.all);
	}
	
	
}
