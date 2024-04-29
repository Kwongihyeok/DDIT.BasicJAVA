package kr.or.ddit.study10;

import java.awt.Label;
import java.util.Scanner;

public class ExceptionExample02 {
	
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		ExceptionExample02 obj = new ExceptionExample02();
		obj.process();
	}

	public void process() {
		int sel = 0;
		System.out.println("숫자 입력");
		while (true) {
			
			try {
				sel = sc.nextInt();
			
				break;
			} catch (Exception e) {
				System.out.println("잘못입력되었습니다.");
				sc.nextLine();
				continue;
			}
			
		}
		System.out.println(sel);
			
		
		
	}
}
