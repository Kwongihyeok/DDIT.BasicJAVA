package kr.or.ddit.study06.sec04;

import java.util.Scanner;

public class Calculator {
	
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Calculator obj = new Calculator();
		obj.process();
	}

	public void process() {
		int a = sc.nextInt();
		String e = sc.next();
		int b =sc.nextInt();
		
		System.out.println(cal(e, a, b));
		
	}
	public double cal(String oper, int a, int b) {
		if(oper.equals("+")) {
			return sum(a, b);
		}else if (oper.equals("/")) {
			return div(a, b);
		}else if(oper.equals("*")) {
			return div(a, b);
		}else if(oper.equals("-")) {
			return minus(a, b);
		}else {
			return 0;
		}
	}
	public double sum(int a, int b) {
		return a+b;
	}
	public double minus(int a, int b) {
		return a-b;
	}
	public double ASD(int a, int b) {
		return a*b;
	}
	public double div(int a, int b) {
		return a/b;
	}
}
