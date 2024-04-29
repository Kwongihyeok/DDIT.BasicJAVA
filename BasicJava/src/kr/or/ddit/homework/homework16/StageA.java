package kr.or.ddit.homework.homework16;

import java.util.Random;
import java.util.Scanner;

public class StageA extends Stage{
	//홀짝 게임
	
		@Override
		public int game(int result) {
			Scanner sc = new Scanner(System.in);
			System.out.println("홀 or 짝 ");
			String sel = sc.next();
			Random random = new Random();
			int ran = random.nextInt(10)+1;
			//패배 0, 승리 1 
			if (sel.equals("홀")) {
				if (ran % 2==0) {
					result = 0; //패
				}else {
					result = 1; //승
				}
			}else if (sel.equals("짝")) {
				if (ran % 2==0) {
					result = 1; //승
				}else {
					result = 0; //패
				}
			}
			return result;
		}
		
		@Override
		public int gameMoney(int money, int result) {
			// TODO Auto-generated method stub
			money -= 2000;
			if (result == 1) {
				money += 4000;
				System.out.println("승리");
			}
			System.out.println("남은 금액" + money);
			return money;
		}
}
