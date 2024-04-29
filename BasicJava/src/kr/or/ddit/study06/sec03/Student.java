package kr.or.ddit.study06.sec03;

public class Student {
	String nation; //국가
	String roomNo; //방번호
	String name;   //이름
	int age;	   //나이
	
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
		nation = "한국";
		roomNo = "306호";
	}
	public Student(String name, int age, String roomNo) {
		this.name = name;
		this.age = age;
		this.roomNo = roomNo;
		nation = "한국";
		
	}
	
	public Student(String name, int age, String roomNo, String nation) {
		this.name = name;
		this.age = age;
		this.roomNo = roomNo;
		this.nation = nation;
		
	}


	@Override
	public String toString() {
		return "Student [nation=" + nation + ", roomNo=" + roomNo + ", name=" + name + ", age=" + age + "]";
	}
	
	
}
