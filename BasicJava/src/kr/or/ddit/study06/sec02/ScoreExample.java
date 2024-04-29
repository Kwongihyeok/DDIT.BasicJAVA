package kr.or.ddit.study06.sec02;

public class ScoreExample {
	
	public static void main(String[] args) {
		//2명의 score 객체를 생성하고 국영수 값을 각각 넣어보시오.
		Score p1 = new Score();
		Score p2 = new Score();
		
		p1.kor = 70;
		p1.eng = 80;
		p1.math = 75;
		p1.avg = (p1.kor + p1.eng + p1.math)/3.0;
		
		
		p2.kor = 60;
		p2.eng = 90;
		p2.math = 85;
		p2.avg = (p2.kor + p2.eng + p2.math)/3.0;
		
		System.out.println("p1 평균: "+p1.avg);
		System.out.println("p2 평균: "+p2.avg);
		
	}
}
