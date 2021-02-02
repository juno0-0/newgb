package obj;

public class Student {
	public int num;
	String name;
	
	public Student() {}

	public Student(int num, String name) {
		this.num = num;
		this.name = name;
	}
	
	@Override
	//반드시 equals()를 재정의할 때는 hashCode()도 재정의해야 한다.
	public boolean equals(Object obj) {
		if(obj instanceof Student) {
			Student std = (Student) obj;
			if(this.hashCode() == std.hashCode()) {
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
