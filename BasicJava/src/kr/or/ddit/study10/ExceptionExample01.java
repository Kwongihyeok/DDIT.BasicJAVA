package kr.or.ddit.study10;

import java.util.Scanner;

public class ExceptionExample01 {
	
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		ExceptionExample01 obj = new ExceptionExample01();
		obj.process();
	}

	public void process() {
		 int a = 10;
		 int[] b = {1,2,0};
		 try {
			 System.out.println("ㅁㄴ");
			 for (int i = -1; i < b.length; i++) {
				 double result = a/b[i];
				 System.out.println("결과값 : " + result);
			}
			 
		}
		 //ArithmeticException
		 catch (ArithmeticException e) {
			 System.out.println("잘못된 수가 입력되었습니다.");
		}
		 catch (ArrayIndexOutOfBoundsException e) {
//				System.out.println(e);
				System.err.println("err");
			} 
		 catch (Exception e) {
//			System.out.println(e);
			e.printStackTrace();
		}



		 
		 System.out.println("종료되었습니다.");
	}
}
