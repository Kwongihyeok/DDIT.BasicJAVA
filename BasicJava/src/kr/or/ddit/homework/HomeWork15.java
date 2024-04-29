package kr.or.ddit.homework;

import java.util.Calendar;
import java.util.Scanner;

public class HomeWork15 {
	
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		HomeWork15 obj = new HomeWork15();
		obj.process();
	}

	public void process() {
		Calendar cal = Calendar.getInstance();
		int month = sc.nextInt();
		month += 1;
		while(true) {
			// < 이전달     다음달>
			//달 입력
			System.out.println("시작은 무조건 현재월 입력");
			
			//첫날의 요일 구하기
			cal.set(month, 1);
			int day = cal.get(Calendar.DAY_OF_WEEK);
			int year = cal.get(Calendar.YEAR);
			int mon = cal.get(Calendar.MONTH);
			//입력달 마지막일
			int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
			//출력
			System.out.println("---------------------"+year+"년 "+(mon+1)+"월------------------------");
			System.out.println("일\t월\t화\t수\t목\t금\t토");
			System.out.println("------------------------------------------------------");
			System.out.println("< 이전달\t\t\t\t\t\t다음달 >");
			System.out.println("------------------------------------------------------");
			for (int i = 1; i < day; i++) {
				System.out.print("\t");
			}
			for (int i = 1; i <= lastDay; i++) {
				System.out.print(i+"\t");
				
				if (day%7==0) {
					System.out.println();	
				}
				day++;
			}
			System.out.println();
			System.out.println("------------------------------------------------------");
			String str = sc.next();
			if (str.equals(">")) {
				cal.add(Calendar.MONTH,1);
			}
			else if (str.equals("<")) {
				cal.add(Calendar.MONTH,-1);
			}
			
		}
	}
}
