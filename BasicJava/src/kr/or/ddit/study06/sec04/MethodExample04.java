package kr.or.ddit.study06.sec04;

import java.util.Scanner;

public class MethodExample04 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		MethodExample04 obj = new MethodExample04();
		obj.process();
	}

	public void process() {
		// 스캐너를 통해 a, b 값을 입력 받고
		// add 메소드를수정하여 a+b 값을 리턴 받아 출력하시오
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		System.out.println(add(a, b));
		System.out.println(minus(a, b));
		System.out.println(mul(a, b));
		System.out.println(div(a, b));
		
	}
	
	public int add(int a, int b) {
		int c = a+b;
		return c;
	}
	
	public int minus(int a, int b) {
		return a-b;
	}
	
	public int mul(int a, int b) {
		return a*b;
	}
	
	public double div(int a, int b) {
		return (double)a/b;
	}
}
