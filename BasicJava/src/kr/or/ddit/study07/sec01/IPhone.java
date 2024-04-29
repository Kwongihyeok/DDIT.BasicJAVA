package kr.or.ddit.study07.sec01;

public class IPhone extends SmartPhone{
	public void apstore() {
		System.out.println("앱스토어 사용");
	}
	
	public void camera() {
		super.camera();
		System.out.println("1000만화소 카메라");
	}
	
}
