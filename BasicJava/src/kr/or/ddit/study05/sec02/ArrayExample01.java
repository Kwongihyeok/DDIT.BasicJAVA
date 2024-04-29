package kr.or.ddit.study05.sec02;

import java.util.Scanner;

public class ArrayExample01 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		ArrayExample01 obj = new ArrayExample01();
		obj.process();
	}

	public void process() {
//		method1();
//		method2();
//		method3();
//		method4();
//		method5();
//		method6();
		method7();
	}
	public void method1() {
		//변수 5개 만들고 각각에 0~100 사이 값을 넣을것
		//총합 구하기
		int a = 100; 
		int b = 79;
		int c = 32;
		int d = 55;
		int e = 24;
		int sum = a+b+c+d+e;
	}
	
	public void method2() {
		int[] students = new int[5];
		students[0] = 100;
		students[1] = 79;
		students[2] = 32;
		students[3] = 55;
		students[4] = 24;
		int sum = 0;
		for (int i = 0; i < students.length; i++) {
			sum += students[i];
		}
	}
	
	public void method3() {
		int[] array = new int[3];
		array[0] = 3;
		array[1] = 2;
		array[2] = 1;
		
	}
	
	public void method4() {
		int[] array= {1,2,3,4,5};
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		
		for (int j = array.length; j >= 0; j++) {
			System.out.println(array[j]);
		}
		
	}
	
	public void method5() {
		int a = 10;
		int b = 7;
		
		int c = a;
	    a = b;
	    b = c;
		System.out.println("a: "+ a+" b : "+b);
		
		
	}
	
	public void method6() {
		int[] score = {80, 90, 97, 60, 94};
		int max = 0;
		//int max = Integer.MIN_VALUE;
		//int max = Integer.MAX_VALUE;
		int min= 0;
		
		
		for (int i = 0; i < score.length; i++) {
			if(max<score[i]) {
				max = score[i];
			}
		}
		min = score[0];
		for (int j = 0; j < score.length; j++) {
			if (min>score[j]) {
				min = score[j];
			}
		}
		
		System.out.println(min);
		System.out.println(max);
	}
	
	public void method7() {
		//거스름돈을 입력 받아 화폐 단위 별로 개수를 구하시오.
		// ex)77000원 -> 10000 7개 5000원 1개 1000원 2
		
		int[] coin = {10000,5000,1000,500,100,50,10};
		int A = 77650;
		for (int i = 0; i < coin.length; i++) {
			if (A/coin[i] >0) {
				System.out.println(coin[i]+"원"+A/coin[i]+"개");
				A = A%coin[i];
			}
		}
	}
	
}
