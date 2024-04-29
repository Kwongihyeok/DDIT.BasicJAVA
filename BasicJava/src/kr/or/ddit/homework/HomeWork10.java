package kr.or.ddit.homework;

import java.util.Scanner;

public class HomeWork10 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		HomeWork10 obj = new HomeWork10();
		obj.process();
	}

	public void process() {
		Student[] stuList = new Student[100];
		int cur = 0;
		
		
		while (true) {
			System.out.println("1. 학생 추가");
			System.out.println("2. 전체 출력");
			System.out.println("3. 종료");
			int sel = sc.nextInt();
			Student stu;
			if(sel == 1) {
				//1. 학생추가
				//지역을 입력 받고 지역이 대전이라면 
				//파라미터 [이름, 나이] 인 생성자
				//지역이 대전이 아니라면 [지역, 이름, 나이]인 생성자 호출
				// v
				/* 1.Scanner -> 지역
				 * 2. 지역 = 대전 > Scanner -> 이름, 나이
				 * 3. 지역 != 대전 > Scanner -> 지역, 이름, 나이
				 * 4. 상황에 맞는 생성자 호출
				*/
				System.out.print("지역, 이름, 나이 순으로 입력 :");
				String region = sc.next();
				if(region.equals("대전")) {
					String name = sc.next();
					int age = sc.nextInt();
					stu= new Student(name, age);
				}else {
					String name = sc.next();
					int age = sc.nextInt();
					stu= new Student(region, name, age);
					
				}
				stuList[cur++] = stu;
				
			}
			if(sel == 2) {
				//2. 전체 출력
				//stulist길이만큼 for문 진행 -> 전체 출력
				for (int i = 0; i < cur; i++) {
					System.out.println(stuList[i]);
				}
				
			}
			if(sel == 3) {
				//3. 종료
				break;
			}
		}
	}
}

class Student{
	//나라, 지역, 이름, 나이 -> 필드 입력
	String nation; //국가
	String region; //지역
	String name;   //이름
	int age;	   //나이

	public Student(String nation, String region, String name, int age) {
        this.nation = nation;
        this.region = region;
        this.name = name;
        this.age = age;
    }

    public Student(String name, int age) {
        this("대한민국", "대전", name, age);
    }
		
	public Student(String region, String name, int age) {
		this("대한민국",region, name, age);
	}
	//toString 메소드 만들기

	@Override
	public String toString() {
		return "Student [nation=" + nation + ", region=" + region + ", name=" + name + ", age=" + age + "]";
	}
	
}