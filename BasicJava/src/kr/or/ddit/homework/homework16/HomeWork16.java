package kr.or.ddit.homework.homework16;

import java.util.Scanner;

public class HomeWork16 {
	
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		HomeWork16 obj = new HomeWork16();
		obj.process();
	}

	public void process() {
		/*
		 * Stage class를 만들고
		game () , gameMoney();

		StageA StageB StageC 에 상속 받으시오.
		StageA 홀짝 게임
		게임비 2000 보상 4000
		StageB 가위바위보 게임비 6000 보상 20000
		StageC 주사위 숫자 맞추기 게임 게임비 1만 보상 100000
		*/
 		int money = 10000;
 	
		while(money<200000) {
			System.out.println("1. Stage A");
			System.out.println("2. Stage B");
			System.out.println("3. Stage C");
			
			int sel = sc.nextInt();
			Stage stage = null;
			if (sel == 1 && money >= 2000) {
				stage = new StageA();
			}if (sel == 2 && money >= 6000) {
				stage = new StageB();
			}if (sel == 3 && money >= 10000) {
				stage = new StageC();
			}
			int result =3;
			result = stage.game(result);
			money = stage.gameMoney(money, result);
			if (money < 2000) {
				break;
			}
		}
	}
}
