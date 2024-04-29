package kr.or.ddit.study06.sec06;

public class SingMain {
	public static void main(String[] args) {
		Sing s1 = new Sing();
		s1.setTitle("Love wins all");
		s1.setLyrics("Dearest, darling, my universe\n"
				+ "날 데려가 줄래?\n"
				+ "나의 이 가난한 상상력으론\n"
				+ "떠올릴 수 없는 곳으로");
		s1.setPubYear("2024");
		s1.setSinger("IU");
		
		System.out.println("제목 : " + s1.getTitle() + "\t가수 : "+s1.getSinger()+ "\t 발행년도 : "+ s1.getPubYear());
		System.out.println(s1.getLyrics());
	}
}
