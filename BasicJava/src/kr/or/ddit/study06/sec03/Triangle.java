package kr.or.ddit.study06.sec03;

public class Triangle {
//	Point p1 = new Point(1, 1);
//	Point p2 = new Point(10, 10);
//	Point p3 = new Point(0, 10);
//	
	Point p1;
	Point p2;
	Point p3;
	
	double area;
	public Triangle(Point p1, Point p2, Point p3) {
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
		area = ((p1.x*p2.y + p2.x*p3.y + p3.x*p1.y) -
				(p1.x*p3.y + p2.x*p1.y + p3.x*p2.y)) /2.0;
//		if (area<0) {
//			area  = -area;
//		}
		area = Math.abs(area);
	}
	public Triangle(int x1, int y1, int x2, int y2, int x3, int y3) {
//		this.p1 = new Point(x1, y1);
//		this.p2 = new Point(x2, y2);
//		this.p3 = new Point(x3, y3);
		this (new Point (x1, y1), new Point (x2, y2), new Point (x3, y3));
		
	}
	
	
	@Override
	public String toString() {
		return p1+","+ p2+","+ p3+ ","+ area;
	}
		
}
