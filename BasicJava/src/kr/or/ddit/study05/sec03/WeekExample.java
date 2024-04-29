package kr.or.ddit.study05.sec03;

import java.util.Scanner;

public class WeekExample {
	
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		WeekExample obj = new WeekExample();
		obj.process();
	}

	public void process() {
		week(1);
		week(Week.FRI);
	}
	public void week(Week week) {
//		if(week == Week.SUN) {
//			System.out.println("일요일");
//		}
//		if(week == Week.MON) {
//			System.out.println("월요일");
//		}
//		if(week == Week.TUE) {
//			System.out.println("화요일");
//		}
//		if(week == Week.WED) {
//			System.out.println("수요일");
//		}
//		if(week == Week.THU) {
//			System.out.println("목요일");
//		}
//		if(week == Week.FRI) {
//			System.out.println("금요일");
//		}
//		if(week == Week.SAT) {
//			System.out.println("토요일");
//		}
		System.out.println(week.day);
	}
	public void week(int num) {
		if(num == 1) {
			System.out.println("일요일");
		}
		if(num == 2) {
			System.out.println("월요일");
		}
		if(num == 3) {
			System.out.println("화요일");
		}
		if(num == 4) {
			System.out.println("수요일");
		}
		if(num == 5) {
			System.out.println("목요일");
		}
		if(num == 6) {
			System.out.println("금요일");
		}
		if(num == 7) {
			System.out.println("토요일");
		}
	}
}
