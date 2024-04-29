package kr.or.ddit.study05.sec02;

import java.util.Random;
import java.util.Scanner;

public class ArrayExample02 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		ArrayExample02 obj = new ArrayExample02();
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
	
	public void method7() {
		//45짜리	temp배열 만들기
		int[] temp = new int[45];
		for (int i = 0; i < temp.length; i++) {
			temp[i] = i+1;
		}
		//배열 섞기
		for(int i=0; i< 10000000; i++) {
			int ran2 = new Random().nextInt(temp.length);
			int sample = temp[0];
			temp[0] = temp[ran2];
			temp[ran2] = sample;
		}

		//6짜리 lotto 배열 만들기
		int[] lotto = new int [6];
		
		//lotto 배열에 temp 0~5까지 값을 복사
		System.arraycopy(temp, 0, lotto, 0, 6);
		//lotto 배열 정렬하기
		
		for (int i = 0; i < lotto.length-1; i++) {
			for (int j = 0; j < lotto.length-1; j++) {
				if(lotto[j]>lotto[j+1]) { //여기 부등호에 따라 오름차순/내림차순 내림차순
					int ex = lotto[j];
					lotto[j] = lotto[j+1];
					lotto[j+1] = ex;
					
				}
			}
		
		}
		for (int c = 0; c < lotto.length; c++) {
			System.out.print(lotto[c] + " ");
		}
	}
	
	public void method6() {
		
		int[] num = {67,55,9,86,98};
		for (int i = 0; i < num.length-1; i++) {
			boolean flag = true;
			for (int j = 0; j < num.length-1; j++) {
				if(num[j]<num[j+1]) { //여기 부등호에 따라 오름차순/내림차순 내림차순
					int temp = num[j];
					num[j] = num[j+1];
					num[j+1] = temp;
					flag = false;
				}
			}
			if(flag) break;
		}
		for (int c = 0; c < num.length; c++) {
			System.out.print(num[c] + " ");
		}
	}
	
	
	public void method5() {
		//버블 정렬
		
		int[] num = {67,55,9,86,98};
		for (int i = 0; i < num.length-1; i++) {
			for (int j = 0; j < num.length-1; j++) {
				if(num[j]<num[j+1]) { //여기 부등호에 따라 오름차순/내림차순 내림차순
					int temp = num[j];
					num[j] = num[j+1];
					num[j+1] = temp;
				}
			}
		}
		for (int c = 0; c < num.length; c++) {
			System.out.print(num[c] + " ");
		}
	}
	
	
	public void method4() {
		//clone()
		
		int[] source= {1,2,3,4,5};
		int[] target = source.clone();
		
			
		
		System.out.println("원본 배열");
		for (int i = 0; i < source.length; i++) {
			System.out.print(source[i]+"\t");
		}
		System.out.println();
		System.out.println("복사 배열");
		for (int i = 0; i < target.length; i++) {
			System.out.print(target[i]+"\t");
		}
		System.out.println();
	}
	
	public void method3() {
		// system.arraycopy
		int[] source= {1,2,3,4,5};
		int[] target= new int[5];
		
		System.arraycopy(source, 0, target, 1, 4);
		
		System.out.println("원본 배열");
		for (int i = 0; i < source.length; i++) {
			System.out.print(source[i]+"\t");
		}
		System.out.println();
		System.out.println("복사 배열");
		for (int i = 0; i < target.length; i++) {
			System.out.print(target[i]+"\t");
		}
		System.out.println();
		
		
	}
	
	public void method2() {
		//깊은 복사
		// 1. 반복문 이용
		// 2. System.arraycoopy()
		// 3. clone()
		
		int[] source = {1,2,3,4,5};
		int[] target = new int[source.length];
		
		for (int i = 0; i < source.length; i++) {
			source[i] = target[i];
		}
	}
	
	public void method1() {
		// 얕은 복사 / 깊은 복사
		// 얕은 복사 (swallow copy)
		// 복사된 배열이나 원본 배열이 변경될 때 서로간의 값이 같이 변경
		
		int[] source= {1,2,3,4,5};
		int[] target = source;
		
		System.out.println("원본 배열");
		for (int i = 0; i < source.length; i++) {
			System.out.print(source[i]+"\t");
		}
		System.out.println();
		System.out.println("복사 배열");
		for (int i = 0; i < target.length; i++) {
			System.out.print(target[i]+"\t");
		}
		System.out.println();
		
		target[2]=10;
		System.out.println("원본 배열");
		for (int i = 0; i < source.length; i++) {
			System.out.print(source[i]+"\t");
		}
		
		System.out.println();
		System.out.println("복사 배열");
		for (int i = 0; i < target.length; i++) {
			System.out.print(target[i]+"\t");
		}
	}
}
