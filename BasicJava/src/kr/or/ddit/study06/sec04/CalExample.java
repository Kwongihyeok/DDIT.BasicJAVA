package kr.or.ddit.study06.sec04;

import java.util.Scanner;

public class CalExample {
	public static void main(String[] args) {
		Calculator cal = new Calculator();
		
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		String oper = sc.next();
		int b = sc.nextInt();
		double result = cal.cal(oper, a, b);
		System.out.println(result);
	}
}
