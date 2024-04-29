package kr.or.ddit.study13.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import oracle.net.aso.l;

public class ArrayListExample02 {
	
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		ArrayListExample02 obj = new ArrayListExample02();
		obj.process();
	}

	public void process() {
		method3();
	}
	
	public void method3() {
		List<Member> memberlist = new ArrayList();
		
		while(true) {
			System.out.println("1. 회원가입");
			System.out.println("2. 회원삭제");
			System.out.println("3. 회원 정보 수정");
			System.out.println("4. 전체 출력");
			int sel = sc.nextInt();
			if (sel == 1) {
				Member member = new Member();
				
				System.out.print("ID : ");
				String id = sc.next();
				
				System.out.print("Name : ");
				String Name = sc.next();
				member.setId(id);
				member.setName(Name);
				memberlist.add(member);
			}
			if (sel == 2) {
				for (int i = 0; i < memberlist.size(); i++) {
					Member member = memberlist.get(i);
					System.out.println(i+", "+member.getId()+", "+member.getName());
				}
				System.out.print("삭제할 회원 번호 입력 : ");
				int num = sc.nextInt();
				Member member = memberlist.remove(num);
				System.out.println(member.getId());
			}
			if (sel == 3) {
				
			}
			if (sel == 4) {
				for (int i = 0; i < memberlist.size(); i++) {
					Member member = memberlist.get(i);
					System.out.println(i+", "+member.getId()+","+member.getName());
				}
			}
		}
	}
	
	public void method2(){
		//입력하는 문자를 list에 저장하시오.
		List<String> list = new ArrayList<String>();
		
		while(true){
			String word = sc.next();
			if(word.equals("end")) break;
			list.add(word);
		}
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	
	public void method1() {
		System.out.println("숫자를 입력하세요.");
		int num = sc.nextInt();
		
//		//num의 약수 값을 ArrayList에 담으시어.
//		
//		int cur = 0;
//		for (int i = 0; i <= num; i++) {
//			if(num%i == 0) cur++;
//		}
//		cur = 0;
//		int[] array = new int crr;
//		
		List<Integer> list  = new ArrayList();
		for (int i = 1; i <=num; i++) {
			if(num % i == 0) list.add(i);
		}
		
		for (int i = 0; i < list.size(); i++) {
			int n = list.get(i);	
		}
	}
	
	
	
}
