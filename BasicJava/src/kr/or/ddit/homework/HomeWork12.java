package kr.or.ddit.homework;

import java.awt.print.Paper;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HomeWork12 {
	
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		HomeWork12 obj = new HomeWork12();
		obj.process();
	}

	public void process() {
		//로또 범위를 1~8로 바꾸고 당첨을 확인
		//
		
		int money = 100000;
		while(true) {
			System.out.println("구매할 로또 금액을 입력");
			int buy = sc.nextInt();
			int[] winning = generateLotto();
			Arrays.sort(winning);
			//구매한 로또와 winning 번호를 비교 값이 같다면
			//3만원 상금
			//money 100만원을 넘거나 0원이 되면 종료
			money -= buy;
			int[][][] bundle = lottoBundle(buy);
			System.out.println(bundle.length);
			if(money >= buy) {
				if(buy < 5000) {
						for (int q = 0; q < lottoPaper().length; q++) {
							int result = 0;
							for (int j = 0; j < 6; j++) {
								if (bundle[0][q][j] == winning[j]) {
									result++;
								}
							}
							if(result == 6) {
								System.out.println("당첨");
								money += 30000;
							}else {
								System.out.println("낙첨");
							}
						}					
				}else if(buy >= 5000) {
					for (int i = 0; i < bundle.length; i++) {
						for (int q = 0; q < lottoPaper().length; q++) {
							int result = 0;
							for (int j = 0; j < 6; j++) {
				
								if (bundle[i][q][j] == winning[j]) {
									result++;
								}
							}
							if(result == 6) {
								System.out.println("당첨");
								money += 30000;
							}else {
								System.out.println("낙첨");
							}
						}
					
				}
				System.out.println(money);
				if(money > 1000000 || money < 0) {
					break;
				}
				}else if(money < buy) {
					System.out.println("돈 부족");
				}
			
			}
		}
		
		
	
	
	}
	
	public void printBundel(int[][][]bundle) {
		for(int[][] paper : bundle) {
			System.out.println("==============================================");
			for (int[] lotto : paper) {
				System.out.println(array2String(lotto));
			}
			System.out.println("==============================================");
		}
	}
	
	public int[][][] lottoBundle(int money) {
		int papers = money/5000;
		if(money%5000!=0) papers++;
		int[][][] bundle = new int[papers][5][6];
		for (int i = 0; i < bundle.length; i++) {
			bundle[i] = lottoPaper();
		}
		if (money % 5000 != 0) {
			bundle[bundle.length-1] = lottoPaper((money % 5000)/1000); 
		}
		return bundle;
	}
	
	public int[][] lottoPaper(int num){
		int[][] paper = new int[num][6];
		for (int pz = 0; pz < paper.length; pz++) {
			paper[pz] = generateLotto();
		}
		return paper;
	}
	public int[][] lottoPaper(){
		return lottoPaper(5);
	}
	
//	public int[][] lottoPaper() {
//		int[][] paper = new int [5][6];
//		for (int i = 0; i < 5; i++) {
////			paper[i] = generateLotto();
////		}
////		for (int i = 0; i < 5; i++) {
////			for (int j = 0; j < 6; j++) {
////				System.out.print(paper[i][j]+"\t");
////			}System.out.println();
////		}
////					
//		paper[i] = generateLotto();
//		
//		}
//		return paper;
//	}
	
	public int[] generateLotto() {
		int[] lotto = new int [6];	
	
		for (int i = 0; i < lotto.length; i++) {
			int ran = new Random().nextInt(8)+1;
			lotto[i] = ran;
			for (int j = 0; j < i; j++) {
				if (lotto[j] == ran) {
					i--;
					break;
				}
			}
		}
		int[] sort_lotto = new int[6];
		for (int i = 0; i < sort_lotto.length; i++) {
			sort_lotto[i] = lotto[i];
		}
//		Arrays.sort(sort_lotto);
		Arrays.sort(lotto);
//		//System.out.println(Arrays.toString(lotto));
//		System.out.println(array2String(lotto));
//		System.out.println(array2String(sort_lotto));
		return lotto;
	}
	
	public String array2String(int[] arr) { 
		String result = "(";
		
		for (int i = 0; i < arr.length; i++) {
			if(i == arr.length-1) {result += arr[i]+")";}
			else{result += arr[i]+",\t";}
		}
		return result;
	}
}
