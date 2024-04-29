package kr.or.ddit.study08;

public class ClassA {
	int a = 10;
	public static void main(String[] args) {
		//ClassA 에  a값 호출
			ClassA cla = new ClassA();
			int classa = cla.a;
		//ClassB 에  b값 호출
			ClassB clb = cla.new ClassB();
			int classb = clb.b;
			
		//ClassC 에  c값 호출
			ClassC clc = new ClassC();
			int classc = clc.c;
			System.out.println(classc);
	}
	
	class ClassB{
		int b = 11;
	}
	static class ClassC{
		int c = 12;
	}
	
}
