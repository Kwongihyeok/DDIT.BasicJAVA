package kr.or.ddit.homework;

import java.util.Random;
import java.util.Scanner;

public class HomeWork11 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		HomeWork11 obj = new HomeWork11();
		obj.process();
	}

	public void process() {
		Deck deck = new Deck();
		//deck.printCardList();
		deck.suffle();
		//deck.printCardList();
		
		//내 카드랑 랜덤 카드랑 비교해서 숫자가 높다면 이김
		Card myCard = deck.getCard(0);
		// 컴퓨터 카드는 랜덤으로
		int ran_com = new Random().nextInt(52);
		Card comCard = deck.getCard(ran_com);
		print(myCard, comCard);
	}
	
	public void print(Card myCard, Card comCard) {
		//결과 출력
		String result = "Lose";
		int my_num = myCard.num;
		int com_num = comCard.num;
		if(my_num > com_num) {
			result = "Win";
		}else if (my_num == com_num) {
			result = "draw";
		}
		System.out.println("내카드 : " + myCard + "  컴퓨터 카드 : " +comCard+"  결과 : "+result);
		
		
	}
}
class Card{
	String type;
	int num;
	public Card(String type, int num) {
		super();
		this.type = type;
		this.num = num;
	}
	//생성자 type, num 입력할것
	
	@Override
	public String toString() {
		String result = type + num;
		if (num == 1) {
			result = type + "A";
		}else if(num == 11) {
			result = type + "J";
		}else if(num == 12) {
			result = type + "Q";
		}else if(num == 13) {
			result = type + "K";
		}
		//type 카드 모양
		//num 1~13
		//1=>a로 출력
		//11 ==> J, 12->Q, 13 -> K
		return result;
	}
	
}

class Deck{
	Card[] cardList;
	public Deck() {
		cardList = new Card[52];
		String[] type = {"♤","♧","♡","♢"};
		int cnt = 0;
		for(String t : type) {
			for (int i = 1; i <= 13; i++) {
				Card card = new Card(t,i);
				cardList[cnt++] = card;
			}
		}
	}
	public void suffle() {
		Card[] sample = new Card[1];
		for (int i = 0; i < 10000000; i++) {
			int ran2 = new Random().nextInt(cardList.length);
			sample[0] = cardList[0];
			cardList[0] = cardList[ran2];
			cardList[ran2] = sample[0];		
		}
	}
	
	
	public void printCardList() {
		for (int i = 0; i < cardList.length; i++) {
			System.out.println(cardList[i]+"  ");
			if(i%10 == 0 && i != 0) {
				System.out.println();
			}
		}
	}
	
	public Card getCard(int ran) {
		
		return cardList[ran];
	}
}