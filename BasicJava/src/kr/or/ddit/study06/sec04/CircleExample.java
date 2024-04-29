package kr.or.ddit.study06.sec04;

public class CircleExample {
	 public static void main(String[] args) {
		Circle c1 = new Circle();
		int r =5;
		double area = c1.area(r);
		System.out.println(area);
		
		double circumference = c1.circumference(r);
		System.out.println(circumference);
		System.out.printf("%.1f",circumference);
	}
}
