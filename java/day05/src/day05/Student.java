package day05;

public class Student {
	int num;
	String name;
	
	public Student() {;}

	public Student(int num, String name) {
		this.num = num;
		this.name = name;
	}	
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student) {
			Student st = (Student)obj;
			if(st.num==this.num) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return this.num;
	}
}
