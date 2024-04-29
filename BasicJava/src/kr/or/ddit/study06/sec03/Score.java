package kr.or.ddit.study06.sec03;

public class Score {
	int kor;
	int eng;
	int math;
	int sum;
	double avg;
	
	public Score() {
		
	}
	public Score(int kor, int eng, int math) {
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.sum = kor + eng + math;
		this.avg = sum/3.0;
	}
	
	@Override
	public String toString() {
		return "Score [kor=" + kor + ", eng=" + eng + ", math=" + math + ", sum=" + sum + ", avg=" + avg + "]";
	}
	
	
}
