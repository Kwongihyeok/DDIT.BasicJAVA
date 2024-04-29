package kr.or.ddit.study06.sec02;

public class FoodExample {
	public static void main(String[] args) {
		//객체 2개 생성 후 적절한 값을 넣어보시오.
		Food f1 = new Food();
		Food f2 = new Food();
		
		
		f1.name = "딸기";
		f1.price = 1000;
		
		f2.name = "귤";
		f2.price = 500;
		System.out.println(f1.toString());
		System.out.println(f1.name + ", " + f1.price + ", "+f1.year);
		System.out.println(f2.name + ", " + f2.price + ", "+f2.year);
	}
}
