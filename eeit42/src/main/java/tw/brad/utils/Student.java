package tw.brad.utils;

public class Student {
	private String name;
	public Student(String name) {
		this.name=name;
	}
	@Override
	public String toString() {
		return name;
	}
}
