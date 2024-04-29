package kr.or.ddit.homework;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class HomeWork09 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		HomeWork09 obj = new HomeWork09();
		obj.process();
	}

	public void process() {
		Score s1 = new Score();
		Score s2 = new Score();
		Score s3 = new Score();
		Score s4 = new Score();
		Score s5 = new Score();
		Score s6 = new Score();
		
		
		//s1 데이터
			s1.name = "우기";
			s1.kor = 80;
			s1.eng = 70;
			s1.math = 63;
			
		//s2 데이터
			s2.name = "민니";
			s2.kor = 90;
			s2.eng = 85;
			s2.math = 78;
		//s3 데이터
			s3.name = "소연";
			s3.kor = 90;
			s3.eng = 84;
			s3.math = 75;
		//s4 데이터
			s4.name = "미연";
			s4.kor = 65;
			s4.eng = 75;
			s4.math = 70;
		//s5 데이터
			s5.name = "슈화";
			s5.kor = 77;
			s5.eng = 80;
			s5.math = 70;
		
		
		Score[] scores = {s1,s2,s3,s4,s5};
		
		//1. 총점 / 평균
		for (int i = 0; i < scores.length; i++) {		
			scores[i].sum = (scores[i].kor+scores[i].eng+scores[i].math);
			scores[i].avg = scores[i].sum/3.0;
		}
		
		int[] sum = {s1.sum,s2.sum,s3.sum,s4.sum,s5.sum};
		Arrays.sort(sum);
		System.out.println(sum);
		//2. 등수 구하기
		int rank = 1;
		for (int i = 0; i < scores.length; i++) {
			for (int j = 0; j < scores.length; j++) {
	             if (scores[i].sum < scores[j].sum) {
	                scores[i].rank++;
	             }
		    }
		}     
		//3. 출력
			//System.out.println(Arrays.toString(scores));
		for (int i = 0; i < scores.length; i++) {
			System.out.println(scores[i]);
		}
		//4. 정렬
		Arrays.sort(scores, new Comparator<Score>() {
            @Override
            public int compare(Score score1, Score score2) {
                return Integer.compare(score1.ranks(), score2.ranks());
            }
        });
			
		//5. 출력
		for (int c = 0; c < scores.length; c++) {
			System.out.println(scores[c]);
		}
	}
}
class Score {
	//이름 국영수 총점 평균 등수
	//toString 사용
	
	//이름
	String name;
	
	//국 영 수
	int kor;
	int eng;
	int math;
	
	//총점
	int sum;
	
	//평균
	double avg;
	
	//등수
	
	int rank=1;
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "이름 : "+name+", 국어 : "+kor+", 영어 : "+eng+", 수학 : "+math+", 총점 : "+sum+", 평균 : "+avg+", 등수 : "+rank;
	}
	
	public int ranks() {
		
		return rank;
		
	}
}