package kr.or.ddit.study05.sec02;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayExample03 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		ArrayExample03 obj = new ArrayExample03();
		obj.process();
	}

	public void process() {
		//method1();
		//method2();
		//method3();
		//method4();
		method5();
		
	}
	
	public void method5() {
		int[] arr = {2,4,5,1,3};
		System.out.println(Arrays.toString(arr));
		
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public void method4() {
		String[] strlist = {"a","b","c"};
			
		for (int i = 0; i < strlist.length; i++) {
			System.out.print(strlist[i]);
		}
		System.out.println();
		for (String string : strlist) {
			System.out.print(string);
		}
	}
	
	public void method3() {
		int[][] arr = new int[3][];
		arr[0] = new int[4];
		arr[1] = new int[4];
		arr[2] = new int[5];
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		
	}
	
	public void method2() {	
		//점수 -> 국영수
		//홍길동. 강감찬, 이순
		int[][] score = {{80,75,87},
						 {98,90,91},
						 {77,73,68}};
		//홍길동의 국어 점수
		int hong_kor = score[0][0];
		
		//강감찬의 수학점수
		int kang_math = score[1][2];
//		
//		//이순신의 영어점수
		int lee_eng = score[2][1];
//		
		//홍길동의 총점
		int hong_sum= 0;
		System.out.print("홍길동 총점 : ");
		for (int i = 0; i < score[0].length; i++) {
			hong_sum += score[0][i];
		}
		System.out.println(hong_sum);
		//국어 점수 총
		int sum = 0;
		System.out.print("국어점수 총점 : ");
		for (int i = 0; i < score[0].length; i++) {
			 sum += score[i][0];
		}
		
		System.out.println(sum);
		
		System.out.println(hong_kor);
		System.out.println(kang_math);
		System.out.println(lee_eng);
		
	}
	
	public void method1() {
		int[][] arr = new int[3][5];
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				int[] temp = arr[i];
				System.out.print(temp[j]+" ");
				//System.out.print(arr[i][j]+" "); 위 코드 2줄이랑 같음
			}
			System.out.println();
		}
	}
	
}
