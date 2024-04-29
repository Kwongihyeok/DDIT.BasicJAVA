package kr.or.ddit.study06.sec03;

public class StudentExample {
	public static void main(String[] args) {
		Student s1 = new Student("권기혁", 26);
		
		System.out.println(s1);
		
		Student s2 = new Student("허주희", 20,"406호");
		System.out.println(s2);
		
		
		Student s3 = new Student("노아", 20,"406호","미국");
		System.out.println(s3);
		
	}
	
}
