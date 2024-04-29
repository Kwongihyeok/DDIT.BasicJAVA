package kr.or.ddit.study06.sec03;

public class TriangleExample {
	public static void main(String[] args) {
		//삼각형에 좌표값 넣기
		Triangle t1 = new Triangle(new Point(1, 1),new Point(10, 1), new Point(1, 10));

		Triangle t2 = new Triangle(1, 1, 1, 10, 10, 1);
		
		System.out.println(t2);
		System.out.println(t1);
		
		System.out.println(t1.p2.y);
		
	}
}