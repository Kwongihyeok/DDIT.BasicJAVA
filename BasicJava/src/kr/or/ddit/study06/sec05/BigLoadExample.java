package kr.or.ddit.study06.sec05;

import java.util.Date;

public class BigLoadExample {
	public static void main(String[] args) {
		Date d1 = new Date();
		
		BigLoad b1 = BigLoad.getInstance();
		BigLoad b2 = BigLoad.getInstance();
		BigLoad b3 = BigLoad.getInstance();
		
		
		Date d2 = new Date();
		System.out.println(d2.getTime() - d1.getTime());
		
		
	}
}
