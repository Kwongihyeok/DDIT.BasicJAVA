package kr.or.ddit.study11;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class DateExample {
	
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		DateExample obj = new DateExample();
		obj.process();
	}

	public void process() {
//		method01();
//		method2();
//		method3();
//		method4();
//		method5();
		method6();
	}
	
	public void method6() {
		Calendar cal = Calendar.getInstance();
//		cal.add(Calendar.MONTH,1);
		cal.set(Calendar.MONTH, 5);
		int day = cal.get(Calendar.DAY_OF_WEEK);
		//int day = cal.get(Calendar.MONTH);
		int year = cal.get(Calendar.YEAR);
		Date date = cal.getTime();
		System.out.println(day);
	}
	
	public void method5() {
		//일수를 입력받고 그만큼 지난 날짜를 구하시오
		Date date = new Date();
		int day = sc.nextInt();
		Date date2 = new Date(date.getTime()+(long)1000*60*60*24*day);
		System.out.println(date2);
	}
	
	public void method4() {
		//날짜를 String 으로 입력 받고
		// 몇일 몇분 몇초가 남았는지 출력하시오.
		System.out.println("날짜를 입력하시오");
		String str = sc.next();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date insert_date = sdf.parse(str);
			Date now_date = new Date();
			long time = insert_date.getTime()-now_date.getTime();
			
			int sec = 1000;
			int min = sec * 60;
			int hour = min * 60;
			int day = hour * 24;
			int year = day * 365;

			int int_result_day = (int)(time/day);
			time %= day;
			int int_result_hour = (int)(time/hour);
			time %= hour;
			int int_result_min = (int)(time/min);
			time %= min;
			int int_result_sec = (int)(time/sec);
			
			System.out.println(int_result_day+","+int_result_hour+","+int_result_min+","+int_result_sec);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void method3() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String str = "2024-04-23";
		try {
			Date date = sdf.parse(str);
			System.out.println(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void method2() {
		//Date -> String
		//date2String
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss");
		
		Date date = new Date();
		String str = sdf.format(date);
		System.out.println(str);
				
	}
	public void method01() {
		Date date = new Date();
		System.out.println(date);
		long time = date.getTime();
		System.out.println(time);
		
		//몇년 몇일 몇시 몇분 몇초
		
		int sec = 1000;
		int min = sec * 60;
		int hour = min * 60;
		int day = hour * 24;
		int year = day * 365;

		int int_result_year	= (int)(time/year);
		time %= year;
		int int_result_day = (int)(time/day);
		time %= day;
		int int_result_hour = (int)(time/hour);
		time %= hour;
		int int_result_min = (int)(time/min);
		time %= min;
		int int_result_sec = (int)(time/sec);
		System.out.println(int_result_year+","+int_result_day+","+int_result_hour+","+int_result_min+","+int_result_sec);
		
		
		
	}
}
