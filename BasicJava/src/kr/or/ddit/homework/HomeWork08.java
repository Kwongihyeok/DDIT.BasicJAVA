package kr.or.ddit.homework;

import java.util.Scanner;

public class HomeWork08 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		HomeWork08 obj = new HomeWork08();
		obj.process();
	}

	public void process() {
		String[] stuName = {"우기", "민니","소연", "미연", "슈화"};
		
		//국 영 수 충점 평균 등수
		int[][] score = 
			{
					{80,70,63,0,0,1},
					{90,85,78,0,0,1},
					{90,84,75,0,0,1},
					{65,75,70,0,0,1},
					{77,80,70,0,0,1}
			};
		
		
		//1. 총점/평균 계산
		//2. 등수 구하기
		//3. 출력
		//4. 정렬 후 출력하기
		for (int i = 0; i < score.length; i++) {
			int sum = 0;
			int avg = 0;
			for (int j = 0; j < score[i].length; j++) {
				sum += score[i][j];
			}
			score[i][3] = sum;
			
			avg = sum / 3;
			score[i][4] = avg;
		}

		int[] ex = new int[6];
		String ex_name = null;
		for (int i = 0; i < score.length-1; i++) {
			boolean flag = true;
			for (int j = 0; j < score.length-1; j++) {
				if(score[j][4]<score[j+1][4]) { 
					
					System.arraycopy(score[j], 0, ex, 0, 6);
					ex_name = stuName[j];
					
					System.arraycopy(score[j+1], 0, score[j], 0, 6);
					stuName[j] = stuName[j+1];
					
					System.arraycopy(ex, 0, score[j+1], 0, 6);
					stuName[j+1] = ex_name;
					flag = false;
				}
			}
			if(flag) break;
		}
		
		int rank = 1;
		for (int i = 0; i < score.length; i++) {
			for (int j = 0; j < score[i].length; j++) {
				score[i][5] = rank;
				
			}rank++;
		}
		
		
		
		//출력
		for (int i = 0; i < score.length; i++) {
			System.out.print(stuName[i] + " : ");
			for (int j = 0; j < score[i].length; j++) {
				System.out.print(score[i][j]+" ");
			}
			System.out.println();
		}
		
	}
}
