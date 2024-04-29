package kr.or.ddit.homework;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class HomeWork18 {
	public static void main(String[] args) {
		HomeWork18 hw = new HomeWork18();
		hw.process();
	}
	public void process() {
		printHistoGram(10000);
	}
	public int oneDice() {
		int ran = new Random().nextInt(6)+1;
		return ran;
	}
	public int twoDice() {
		
		int int_sum = oneDice() + oneDice();
		return int_sum;
	}
	public Map<Integer, Integer> trialNtimes(int n) {
		Map<Integer, Integer> map = new HashMap();
		for (int i = 0; i < n; i++) {
			map.put(i, twoDice());
		}
		return map;
	}
	
	public void printHistoGram(int num) {
		Map<Integer, Integer> resultMap = trialNtimes(num); 
		Set<Integer> keySet = resultMap.keySet();
		Iterator<Integer> it = keySet.iterator();
		
		for (int i = 1; i < 13; i++){
			System.out.print(i +"\t:");
			int cnt = 0;
			for (int j = 0; j < num; j++) {
				if (resultMap.get(j) == i) {
					cnt++;
					if(cnt == 100) {
						System.out.print("■");
						cnt = 0;
					}
				}
			}System.out.println();
		}
		
	}
}
