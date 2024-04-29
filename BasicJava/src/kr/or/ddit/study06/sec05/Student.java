package kr.or.ddit.study06.sec05;

public class Student {
	static int year = 2020;
	static String roomNo = "306";
	String name;
	int age;
	
	//method
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
		
	}
	@Override
	public String toString() {
		return "Strudent [name=" + name + ", age=" + age + "]";
	}
	
	public static void main(String[] args) {
		System.out.println(year);
	}
	
}
