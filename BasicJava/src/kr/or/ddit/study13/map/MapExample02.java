package kr.or.ddit.study13.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import oracle.net.aso.i;

public class MapExample02 {
	
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		MapExample02 obj = new MapExample02();
		obj.process();
	}

	public void process() {
		List<Map<String,Object>> emplist = inputData();
		int max = getMaxSalary(emplist);
		System.out.println("월급 최대값은 " + max);
		int min = getMinSalary(emplist);
		System.out.println("월급 최소값은 " + min);
		printAll(emplist);
		addDeptSal(emplist);
		increaseDept(emplist);
		
	}
	
	public void increaseDept(List<Map<String,Object>> emplist) {
		printAll(emplist);
		System.out.println("인상할 부서 번호를 입력하세요");
		int deptno = sc.nextInt();
		
		for (Map<String, Object> map : emplist) {
			int dpno = (int)map.get("DEPTNO");
			if (dpno != deptno) continue;
			
			int sal = (int)map.get("SAL");
			map.put("SAL", (int)(sal*1.1));

		}
		printAll(emplist);
	}
	
	public void addDeptSal(List<Map<String,Object>> emplist) {
		Map<Integer, Integer> resultMap = new HashMap<Integer, Integer>();
		
		for (Map<String, Object> map : emplist) {
			int deptno = (int)map.get("DEPTNO");
			int sal = (int)map.get("SAL");
			if(resultMap.containsKey(deptno)){
				sal += resultMap.get(deptno);
			
			}
			resultMap.put(deptno, sal);
			
		}
		System.out.println(resultMap);
	}
	
	public void printAll(List<Map<String,Object>> emplist) {
//		for (int i = 0; i < emplist.size(); i++) {
//			System.out.println(emplist.get(i));
//		}
		System.out.println("EMPNO\tENAME\tJOB\tSAL\tDEPTNO");
		for (Map<String, Object> map : emplist) {
			String empno = (String) map.get("EMPNO");
			String ename = (String) map.get("ENAME");
			String job = (String) map.get("JOB");
			int sal = (int) map.get("SAL");
			int deptno = (int) map.get("DEPTNO");
			System.out.println(empno+"\t"+ename+"\t"+job+"\t"+sal+"\t"+deptno);
		}
		
	}
	
	public int getMinSalary(List<Map<String,Object>> emplist) {
		int min = Integer.MAX_VALUE;
		for (Map<String, Object> map : emplist) {
			int sal = (int)map.get("SAL");
			if (min > sal) {
				min = sal;
			}
		}
		
		return min;
	}
	
	public int getMaxSalary(List<Map<String,Object>> emplist) {
		//int max = 0;
//		for (int i = 0; i < emplist.size(); i++) {
//			if((int)emplist.get(i).get("SAL") > max) {
//				max = (int)emplist.get(i).get("SAL");
//			}
//		}
		int max = Integer.MIN_VALUE;
		for (Map<String, Object> map : emplist) {
			int sal = (int)map.get("SAL");
			if(max < sal ) max = sal;
		}
		
		
		return max;
	}
	
	public List<Map<String,Object>> inputData() {
		Map<String, Object> map1 = new HashMap();
		map1.put("EMPNO", "7369");
		map1.put("ENAME", "장길동");
		map1.put("JOB", "프로그래머");
		map1.put("SAL", 600); 
		map1.put("DEPTNO", 50);
		
		Map<String, Object> map2 = new HashMap();
		map2.put("EMPNO", "7499");
		map2.put("ENAME", "고영우");
		map2.put("JOB", "시장조사");
		map2.put("SAL", 550); 
		map2.put("DEPTNO", 20);
		
		Map<String, Object> map3 = new HashMap();
		map3.put("EMPNO", "7521");
		map3.put("ENAME", "구기현");
		map3.put("JOB", "영업사원");
		map3.put("SAL", 250); 
		map3.put("DEPTNO", 30);

		Map<String, Object> map4 = new HashMap();
		map4.put("EMPNO", "7566");
		map4.put("ENAME", "김동혁");
		map4.put("JOB", "관리자");
		map4.put("SAL", 375); 
		map4.put("DEPTNO", 40);
						
		Map<String, Object> map5 = new HashMap();
		map5.put("EMPNO", "7654");
		map5.put("ENAME", "김민욱");
		map5.put("JOB", "영업사원");
		map5.put("SAL", 350); 
		map5.put("DEPTNO", 30);
		
		List<Map<String,Object>> list = new ArrayList();
		list.add(map1);
		list.add(map2);
		list.add(map3);
		list.add(map4);
		list.add(map5);
		
		
		
		return list;
		
	}
}
