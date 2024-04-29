package kr.or.ddit.study06.sec04;

import java.util.Scanner;

public class MethodExample02 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		MethodExample02 obj = new MethodExample02();
		obj.process();
	}

	public void process() {
		int x = sc.nextInt();
		int y = sc.nextInt();
		add(x, y);
		m(x,y);
		x(x,y);
		l(x, y);
	}
	
	public void add(int a, int b) {
		System.out.println("a + b = "+(a+b));
	}
	
	public void m(int a, int b) {
		System.out.println("a - b = "+(a-b));
	}
	
	public void x(int a, int b) {
		System.out.println("a x b = "+(a*b));
	}
	
	public void l(int a, int b) {
		System.out.println("a / b = "+((double)a/b));
	}
}
