package kr.or.ddit.study05.sec01;

import java.util.Scanner;

public class ReferensType3 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		ReferensType3 obj = new ReferensType3();
		obj.process();
	}

	public void process() {
		method1();
	}
	
	public void method1() {
		int a = 10;
		{
			int b = 12;
			int[] c;
			
			c= new int []{1,2,3};
			
		}
		String d = "test";
		{
			String[] e = new String[3];
			
			e[0] = d;
			
			String f = "test2";
			
			e[1] = f;
			
			e[2] = "test";
		}
	}
}
