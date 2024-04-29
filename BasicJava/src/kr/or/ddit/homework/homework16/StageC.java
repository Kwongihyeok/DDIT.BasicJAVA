package kr.or.ddit.homework.homework16;

import java.util.Random;
import java.util.Scanner;

public class StageC extends Stage {
	@Override
	public int game(int result) {
		Scanner sc = new Scanner(System.in);
		System.out.println("주사위 맞추기 1-6");
		int sel = sc.nextInt();
		Random random = new Random();
		int ran = random.nextInt(5)+1;
		//패배 0, 승리 1 
		if (sel == ran) {
			
				result = 1; //승
			
		}else if (sel != ran) {
				result = 0; //패
			
		}
		return result;
	}
	
	@Override
	public int gameMoney(int money, int result) {
		// TODO Auto-generated method stub
		money -= 10000;
		if (result == 1) {
			money += 100000;
			System.out.println("승리");
		}
		System.out.println("남은 금액" + money);
		return money;
	}
}
