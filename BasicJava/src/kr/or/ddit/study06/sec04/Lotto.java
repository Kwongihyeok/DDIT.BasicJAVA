package kr.or.ddit.study06.sec04;

import java.awt.print.Paper;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lotto {
	
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Lotto obj = new Lotto();
		obj.process();
	}

	public void process() {
		int money = sc.nextInt();
		int[][][] bundle = lottoBundle(money);
		printBundel(bundle);
	
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
			int ran = new Random().nextInt(45)+1;
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
