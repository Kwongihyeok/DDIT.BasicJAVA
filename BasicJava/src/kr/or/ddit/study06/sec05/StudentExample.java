package kr.or.ddit.study06.sec05;

public class StudentExample {
	
	static int a = 10;
	int b = 20;
	public static void main(String[] args) {
		
		Student s1 = new Student("김민강",20);
 		
 		s1.age = 24;
 		
 		
		Student s2 = new Student("서지윤",20);
 		
 		System.out.println(s1.year+" "+s1.toString());
 		s1.year++;
 		System.out.println(s1.year+" "+s2.toString());
// 	
// 		StudentExample se = new StudentExample();
// 		int b = se.b;
//		
		   
									
		
	}

	
}
