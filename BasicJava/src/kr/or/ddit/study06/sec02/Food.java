package kr.or.ddit.study06.sec02;

public class Food {
	//제조일
	String year = "2024.02.20";
	String name;
	int price;
	
	{
		year = "2024.04.01";
	}
	
	
	@Override
	public String toString() {
		return "Food [year=" + year + ", name=" + name + ", price=" + price + "]";
	}
	
	
//	@Override
//	public String toString() {
//		// TODO Auto-generated method stub
//		return "제조일자: "+year+", 이름: "+name+", 가격: "+price;
//	}
//	
	
	
}
