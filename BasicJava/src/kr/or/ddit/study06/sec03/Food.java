package kr.or.ddit.study06.sec03;



public class Food {
	//제조일
	int manuyear;
	int lastyear;
	String name;
	int price;
	
	public Food() {}
	
	public Food(int manuyear, String name, int price) {
		this.manuyear = manuyear;
		this.name = name;
		this.price = price;
		this.lastyear = manuyear + 3;
		
	}

	@Override
	public String toString() {
		return "Food [manuyear=" + manuyear + ", lastyear=" + lastyear + ", name=" + name + ", price=" + price + "]";
	}
	
	
	
}
