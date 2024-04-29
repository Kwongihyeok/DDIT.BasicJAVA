package kr.or.ddit.study11;

import java.util.Scanner;

public class StringExample {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		StringExample obj = new StringExample();
		obj.process();
	}

	public void process() {
		//method1();
		method2();
		//method3();
		// method4();
		// method5();
		// method6();
		//method7();
		// method8();
		// method9();
		

	}
	
	public void method1() {
		String test = "abcd";
		test =test.toUpperCase();
		System.out.println(test);
		
		test =test.toLowerCase();
		System.out.println(test);
		
		if(test.equals("abcd")) {
			System.out.println("같다");
		}
	}
	
	public void method2() {
		String test = "abc";
		String[] tokens = test.split("");
		for(String token : tokens) {
			token = token.trim();
			System.out.println(token);
		}		
	}
	
	public void method3() {
		String space = " a b c \n\n\r";
		System.out.println(space);
		space = space.trim();
		System.out.println(space);
		
	}

	public void method4() {
		String str = "ㅇㅇㅇ 바보";
		str = str.replace("바보", "**");
		System.out.println(str);
	}
	
	public void method5() {
		String str = "123456";
		str = str.substring(4);
		System.out.println(str);
		
		String str1 = "123456";
		str1 = str1.substring(2,3);
		System.out.println(str1);
		
	}
	
	public void method6() {
		String str = "Book1.csv";
		if(str.startsWith("Book1")) {
			System.out.println("Book1로 시작합니다.");
		}
		if(str.endsWith(".csv")) {
			System.out.println(".csv로 끝납니다.");
		}
		
	}
	
   public void method7() {
	      String test = "문자열 test 입니다.";
	    
	      if (test.contains("test")) {
	         System.out.println("test 문자가 포함되어 있다.");
	      }
	   }
	
	public void method8() {
		String str = null;
		
		if(str == null || str.isEmpty()) {
			System.out.println("빈 문자열");
		 }
		}
	
	public void method9() {
		System.out.println("계속 하시겠습니까(y/n)");
		String yn = sc.next();
		//if(yn.equals("y")) {
		if(yn.equalsIgnoreCase("y")) {
			System.out.println("계속");
		}
		else if(yn.equals("n")) {
			System.out.println("종료 합니다.");
		}
		
	}
	
	
	
}
