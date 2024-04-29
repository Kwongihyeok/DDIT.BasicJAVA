package kr.or.ddit.study13.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * <p> HashMap </p>
 * <p> Key와 Value로 구성되어있음</p>
 * <p> Key 값은 중복을 허용하지 않고 순서가 보장되지 않음.</p> 
 * <p> </p>
 * <p> Map 타입의 대표 컬렉션</p>
 * <p> </p>
 * <p> 주요 메소드 </p>
 * <p>   .put(key, value)   : 데이터 입력 key 값은 중복되지 않음, value는 중복 될 수 있음. </p> 
 * <p> 	 .get(key)  		: 입력 받은 value 값은 key 값을 통해 가져올 수 있음</p>
 * <p>   .keySet()          : key로 이루어진 hashSet 값을 가져옴.</p>
 * <p>   .containsKey(key)  : key 값이 있는지 확인</p>
 */


public class MapExample {	
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap();
		map.put("홍길동", 90);
		map.put("이순신", 75);
		map.put("정몽주", 84);
		map.put("이성계", 93);
		
//		//이성계 점수 출력하기
//		System.out.println(map.get("이성계"));
//		
//		//홍길동 점수 5점 추가하기
//		int n = map.get("홍길동")+5;
//		map.put("홍길동", n);
//		
//		
//		//전체출력하기
//		Set<String> keySet = map.keySet();
//		Iterator<String> it = keySet.iterator();
//		while(it.hasNext()){
//			String key = it.next();
//			System.out.println(key + ": " + map.get(key));
//		}
		int score = map.get("홍길동2");
	}
}
