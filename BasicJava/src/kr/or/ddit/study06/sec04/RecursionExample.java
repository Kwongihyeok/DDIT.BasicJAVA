package kr.or.ddit.study06.sec04;

import java.util.Date;
import java.util.Scanner;

public class RecursionExample {
	
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		RecursionExample obj = new RecursionExample();
		obj.process();
	}

	public void process() {
//		method(5);
//		int add = add(5);
//		System.out.println(add);
//		
//		long mul = mul(5);
//		System.out.println(add);
		Date d1 = new Date();
		long fibo = fibo(100);
		//50 28423
		Date d2 = new Date();
		System.out.println(fibo);
		System.out.println(d2.getTime()-d1.getTime());
	}
	long[] fiboList = new long[3000];
	public long fibo2(int num) {
		if(num == 1) return 1;
		if(num == 2) return 2;
		if (fiboList[num] != 0) {
			return fiboList[num];
		}
		long result = fibo2(num-1) + fibo(num-2);
		fiboList[num] = result;
		return result;
	}
	
	public long fibo(int num) {
		if(num == 1) return 1;
		if(num == 2) return 2;
		return fibo(num-1)+fibo(num-2);
	}

	public long mul(int num) {
		if (num == 1) return 1;
		return num * mul(num-1);
	}
	
	public int add(int num) {
		if (num == 1) return 1;
		return num + add(num-1);
	}
	
	public void method(int num) {
		System.out.println(num);
		if(num>0) {
			method(num-1);
		}
		
	}
}

