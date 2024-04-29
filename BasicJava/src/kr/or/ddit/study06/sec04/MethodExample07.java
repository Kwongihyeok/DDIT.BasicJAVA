package kr.or.ddit.study06.sec04;

import java.util.Scanner;

public class MethodExample07 {
	
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		MethodExample07 obj = new MethodExample07();
		obj.process();
	}

	public void process() {
		
		System.out.println(test2());
	}
	
	public int test2() {
		
		int i = 1;
		if(i==1) {
			return 10;
		}
		
		return 0;
		
	}
	
	public void test() {
		int i = 1;
		if(i == 1) {
			System.out.println("종료");
			return;
		}
		System.out.println("234");
	}
}
