package kr.or.ddit.study06.sec04;



public class Circle {
	//반지름을 파라미터로 받고 원의 넓이를 구하시오
	//넓이 3.14*r*r
	//메소드명 area
	
	
	//반지름을 파라미터로 받고 원의 둘레를 구하시오
	//둘레 2*3.14*r
	//메소드 명 circumference
	
	
	 double PI = Math.PI;

	public double area(int r) {
		
		return PI*r*r;
	}
	
	public double circumference(int r) {
		return 2*PI*r;
	}
}
