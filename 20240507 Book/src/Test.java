import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import util.JDBCUtil;

public class Test {
	public static void main(String[] args) {
		Test test =new Test();
		test.method4();
	}
	Scanner sc = new Scanner(System.in);

	JDBCUtil jdbc = JDBCUtil.getInstance();
	
	public  void method1() {
		//selectOne(String sql) -- 한줄 가져오기!
		//selectList(String sql)  -- 여러줄 가져오기!
		//update(String sql) -- 자바에서 정보 업데이트 하기!

		String sql = "SELECT * FROM member";
		List<Map<String, Object>> list = jdbc.selectList(sql);
		for (Map<String, Object> map : list) {
			System.out.println(map);
			
		}		
	}
	
	public  void method2() {
		String sql ="SELECT * \r\n" + 
				"FROM member\r\n" + 
				"where mem_id = 'a001'\r\n" + 
				"and mem_pass = 'asdfasdf'";
		
		Map<String, Object> map = jdbc.selectOne(sql);
		System.out.println(map);
			
	}
	
	public  void method3() {
		String sql ="SELECT * \r\n" + 
			"FROM member\r\n" + 
			"where mem_id = ? \r\n" +   //이이디 ? 로 구멍 뚫기!! 넣을 데이터 입력 방법
			"and mem_pass = ?";			//비번 ? 로 구멍 뚫기!! 넣을 데이터 입력 방법
			
			System.out.println("아이디");
			String id = sc.next();	
			System.out.println("비번");
			String pw = sc.next();	
			
			
			List<Object> param =new ArrayList(); // 리스트 에 담는다
			param.add(id);
			param.add(pw);
			
		
	Map<String, Object> map = jdbc.selectOne(sql,param);
	System.out.println(map);
	}
	
	public  void method4() {
		String sql = "UPDATE member\r\n" + 
				"set mem_pass = '1234'\r\n" + 
				"where mem_id = 'a001'";
		
		jdbc.update(sql);
	
		
	}
	
	
}
