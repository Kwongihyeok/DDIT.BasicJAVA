package kr.or.ddit.study10;

import java.util.Scanner;

public class ExceptionExample03 {
	
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		ExceptionExample03 obj = new ExceptionExample03();
		obj.process();
	}

	public void process() {
		System.out.println("번호를 고르시오.");
		String[] name = {"홍길동", "이순신", "강감찬"};
		for (int i = 0; i < name.length; i++) {
			System.out.println(i+" "+name[i]);
		}
		while (true) {
			try {
				int sel = sc.nextInt();
				String n = name[sel];
				System.out.println(n);
			} catch (Exception e) {
				System.out.println("없는 번호");
				sc.nextLine();
				continue;
			}
			
		}
		
		
		
	}
}
