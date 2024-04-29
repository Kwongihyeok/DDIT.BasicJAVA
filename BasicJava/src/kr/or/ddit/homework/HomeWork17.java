package kr.or.ddit.homework;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HomeWork17 {
	Scanner sc = new Scanner(System.in);
	int cur = 0;
	Member[] memList = new Member[100];
	Member mem = new Member();
	public static void main(String[] args) {
		HomeWork17 obj = new HomeWork17();
		obj.process();
	}

	public void process() {
		while(true) {
			try {
				System.out.println("1. 회원 가입.");
				System.out.println("2. 회원 탈퇴.");
				System.out.println("3. 정보 수정.");
				System.out.println("4. 회원 전체 정보 출력.");
				int sel = sc.nextInt();
				if(sel==1) {
					addMember();
				}
				if(sel==2) {
					removeMember();
				}
				if(sel==3) {
					updateMember();
				}
				if(sel==4) {
					printMemberList();
				}
			} catch (Exception e) {
				System.err.println("없는 번호 입력");
				sc.nextLine();
				continue;
			}
		}
	}
	
	
	public void addMember() {
		// id 입력시 4~8자 입력 받을것.
		
		String id; 
		while(true) {
			try {
				System.out.println("아이디를 입력하세요.");
				id = sc.next();
				idCheck(id);
				break;
			} catch (Exception e) {
				System.err.println(e.getMessage());
				continue;
			}
			
		}
		while(true) {
			try {
				System.out.println("비밀번호를 입력하세요.");
				String str_pass = sc.next();
				passCheck(str_pass);
				break;
			} catch (Exception e) {
				System.err.println(e.getMessage());
				continue;
			}
			
		}
		while(true) {
			try {
			
				System.out.println("이름을 입력하세요.");
				String str_name = sc.next();
				nameCheck(str_name);
				break;
			} catch (Exception e) {
				System.err.println(e.getMessage());
			
				continue;
			}
			
		}
		while(true) {
			try {
				System.out.println("닉네임을 입력하세요.");
				String str_nickName = sc.next();
				NicknameCheck(str_nickName);
				break;
			} catch (Exception e) {
				System.err.println(e.getMessage());
				continue;
			}
			
		}
		while(true) {
			try {
				System.out.println("나이를 입력하세요.");
				ageCheck();

				memList[cur] = mem;
				cur++;
				System.out.println("회원가입 성공");
				break;
			}catch (InputMismatchException e) {
				System.out.println("숫자를 입력해주세요.");
			} 
			catch (Exception e) {
//				e.printStackTrace();
				System.out.println(e);
				System.err.println(e.getMessage());
				continue;
				
			}
		}
		// pass 입력시 4~ 8자 입력 
		// name 입력시 2~5자 입력 
		// nickName 입력시 욕설등 금지어 체크
		// age 숫자 입력 체크
	}
	
	public void idCheck(String id) throws Exception {
		if(id.length() < 4 || id.length() > 8) {
			throw new Exception("아이디가 잘못입력되었습니다. 다시 입력해주세요");
			
		}
		for (int i = 0; i < cur; i++) {
			if(memList[i].getId() == id) {
				throw new Exception("아이디가 이미 사용중입니다.");

			}
		}
		mem.setId(id);
		System.out.println("아이디 입력 성공");
		
	}
	
	public void passCheck(String str_pass) throws Exception {
		if(str_pass.length() < 4 || str_pass.length() > 8) {
			throw new Exception("비밀번호가 잘못입력되었습니다. 다시 입력해주세요");
		}
		mem.setPass(str_pass);
		System.out.println("비밀번호 입력 성공");
	}
	
	public void nameCheck(String str_name) throws Exception {
		if(str_name.length() < 2 || str_name.length() >5) {
			throw new Exception("이름이 잘못입력되었습니다. 다시 입력해주세요");
		}
		mem.setName(str_name);
		System.out.println("이름 입력 성공");
	}
	
	public void NicknameCheck(String str_nickName) throws Exception {
		String[] Swear_words = {"fuck", "병신"};
		for (int i = 0; i < Swear_words.length; i++) {
			if (str_nickName.contains(Swear_words[i])) {
				throw new Exception("닉네임에 욕설이 포함되어있습니다.");
			}
		}
		mem.setNickName(str_nickName);
		System.out.println("닉네임 입력 성공");
		
	}
	
	public void ageCheck() throws Exception {
		try{
			int int_age = sc.nextInt();
			mem.setAge(int_age);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("나이 입력이 잘못 되었습니다.");
		}
	}
	
	
	public void removeMember() {
		Member[] temp = new Member[100];
		printMemberList();
		System.out.println("삭제할 회원번호를 입력하세요");
		int num = sc.nextInt();
		int add = 0;
		for (int i = 0; i < cur; i++) {
			if (i==num) {
				add++;
			}
			temp[i] = memList[i+add];
		}
		memList = temp;
		cur--;
		printMemberList();
	}
	

	public void updateMember() {
		printMemberList();
		
		System.out.print("수정할 회원 번호 입력.");
		int num = sc.nextInt();
		Member mem = memList[num];
		/*
		 *  정보 수정.
		 */
		System.out.println("수정한 아이디를 입력하세요.");
		String id = sc.next();
		System.out.println("수정한 비밀번호를 입력하세요.");
		String pass = sc.next();
		System.out.println("수정한 이름을 입력하세요.");
		String name = sc.next();
		System.out.println("수정한 나이를 입력하세요.");
		int age = sc.nextInt();
		mem.setId(id);
		mem.setPass(pass);
		mem.setName(name);
		mem.setAge(age);
	}
	
	public void printMemberList() {
		System.out.println("회원번호\t아이디\t비밀번호\t이름\t나이");
		for (int i=0; i<cur; i++) {
			Member mem = memList[i];
			//get메소드를 이용해서 출력
			System.out.println(i+"\t"+mem.getId()+"\t"+mem.getPass()+"\t"+mem.getName()+"\t"+mem.getAge()+"\t");
		
		}
	}

	
}

class Member{
	private String id;
	private String pass;
	private String name;
	private String nickName;
	private int age;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	
}

