package kr.or.ddit.study07.sec01;

import java.util.Scanner;

public class PhoneMain {
	
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		PhoneMain obj = new PhoneMain();
		obj.process();
	}

	public void process() {
		DmbPhone dmbPhone = new DmbPhone();
		dmbPhone.tell();
		dmbPhone.dmb();
	}
}
