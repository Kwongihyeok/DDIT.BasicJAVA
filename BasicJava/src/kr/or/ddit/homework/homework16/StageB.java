package kr.or.ddit.homework.homework16;

import java.util.Random;
import java.util.Scanner;

public class StageB extends Stage {
	@Override
	public int game(int result) {
		Scanner sc = new Scanner(System.in);
		System.out.println("가위바위");
		Random random = new Random();
		//패배 0, 승리 1 
	      int com=random.nextInt(3);
	      String com2="", num2="";
	      System.out.print("0(가위),1(바위),2(보)중 하나를 입력하세요: ");
	      int num=sc.nextInt();
	      if(com==0) {
	         com2="가위";
	      }
	      else if(com==1) {
	         com2="바위";
	      }
	      else if(com==2) {
	         com2="보";
	      }
	      
	      if(num==0) {
	         num2="가위";
	      }
	      else if(num==1) {
	         num2="바위";
	      }
	      else if(num==2) {
	         num2="보";
	      }
	      System.out.print("컴퓨터: "+com2+", 사람: "+num2+", 결과: ");
	      
	      if(com==num)
	      {
	    	  result = 0;
	      }
	      else if((com==1&&num==2)||(com==0&&num==1)||(com==2&&num==0)) {
	    	  result = 1;
	      }
	      else if((num==1&&com==2)||(num==0&&com==1)||(num==2&&com==0)) {
	    	  result = 0;
	      }	
		return result;
	}
	
	@Override
	public int gameMoney(int money, int result) {
		// TODO Auto-generated method stub
		money -= 6000;
		if (result == 1) {
			money += 20000;
			System.out.println("승리");
		}
		System.out.println("남은 금액" + money);
		return money;
	}
}
