package kr.or.ddit.homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class HomeWork19 {

	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		HomeWork19 obj = new HomeWork19();
		obj.process();
	}

	public void process() {
		List<Map<String, Object>> parkList = inputDate();
		printAll(parkList);
//		parkTime(parkList);
//		System.err.println(parkTime(parkList));
//		parkPay(parkTime(parkList));

	}

	// 요금 계산하기.
	public void parkPay(List parkTime) {
		// 기본시간(분) 기본요금(원) 단위시간(분) 단위요금(원)
		// 180 5000 10 600
		List<Map<String, Object>> list = parkTime;
		for (int i = 0; i < list.size(); i++) {
			String carno = (String) list.get(i).get("carno");
			int time = (int) list.get(i).get("parkingtime");
			int fare = 0;
			if (time < 180) {
				fare = 5000;
			} else {
				fare = 5000 + (time - 180) / 10 * 600;
			}

			System.out.println("차량번호: " + carno + "\t주차시간: " + time + "\t주차요금:" + fare);
		}

	}

	// 차량별 주차 시간 구하기.
	public List parkTime(List<Map<String, Object>> parkList) {

		String time2 = null;

		Map<String, Integer> parktime = new HashMap<String, Integer>();
		List parkinglist = new ArrayList();
		Map parking = null;
		for (int i = 0; i < parkList.size(); i++) {
			String carno1 = (String) parkList.get(i).get("차량번호");
			String state1 = (String) parkList.get(i).get("내역");
			String time1 = (String) parkList.get(i).get("시각");
			if (state1.equals("입차")) {
				for (int j = i + 1; j < parkList.size(); j++) {
					String carno2 = (String) parkList.get(j).get("차량번호");
					String state2 = (String) parkList.get(j).get("내역");
					if (carno1.equals(carno2) && state2.equals("출차")) {
						time2 = (String) parkList.get(j).get("시각");

						break;
					}
				}

				int time1_getMin = getMin(time1);
				int time2_getMin = getMin(time2);
				int parking_time = time2_getMin - time1_getMin;

				parking = new HashMap();
				parking.put("cnt", i);
				parking.put("carno", carno1);
				parking.put("parkingtime", parking_time);
				parkinglist.add(parking);

			}
		}

		return parkinglist;
	}

	public int getMin(String time) {
		String[] tokens = time.split(":");
		int hour = Integer.parseInt(tokens[0]);
		int min = Integer.parseInt(tokens[1]);
		return hour * 60 + min;
	}

	public void printAll(List<Map<String, Object>> parkList) {
		for (Map<String, Object> map : parkList) {
			System.out.println(map);
		}
	}

	public List<Map<String, Object>> inputDate() {
//      시각     차량번호     내역
//     05:34    5961   	   입차
//     06:00    0000       입차
//     06:34    0000       출차
//     07:59    5961       출차
//     07:59    0148       입차
//     18:59    0000       입차
//     19:09    0148       출차
//     22:59    5961       입차
//     23:00    5961       출차
		Map<String, Object> park1 = new HashMap();
		park1.put("시각", "05:34");
		park1.put("차량번호", "5961");
		park1.put("내역", "입차");

		Map<String, Object> park2 = new HashMap();
		park2.put("시각", "06:00");
		park2.put("차량번호", "0000");
		park2.put("내역", "입차");

		Map<String, Object> park3 = new HashMap();
		park3.put("시각", "06:34");
		park3.put("차량번호", "0000");
		park3.put("내역", "출차");

		Map<String, Object> park4 = new HashMap();
		park4.put("시각", "07:59");
		park4.put("차량번호", "5961");
		park4.put("내역", "출차");

		Map<String, Object> park5 = new HashMap();
		park5.put("시각", "07:59");
		park5.put("차량번호", "0148");
		park5.put("내역", "입차");

		Map<String, Object> park6 = new HashMap();
		park6.put("시각", "18:59");
		park6.put("차량번호", "0000");
		park6.put("내역", "입차");

		Map<String, Object> park7 = new HashMap();
		park7.put("시각", "19:09");
		park7.put("차량번호", "0148");
		park7.put("내역", "출차");

		Map<String, Object> park8 = new HashMap();
		park8.put("시각", "22:59");
		park8.put("차량번호", "5961");
		park8.put("내역", "입차");

		Map<String, Object> park9 = new HashMap();
		park9.put("시각", "23:00");
		park9.put("차량번호", "5961");
		park9.put("내역", "출차");

		Map<String, Object> park10 = new HashMap();
		park10.put("시각", "23:00");
		park10.put("차량번호", "0000");
		park10.put("내역", "출차");

		List<Map<String, Object>> list = new ArrayList();
		list.add(park1);
		list.add(park2);
		list.add(park3);
		list.add(park4);
		list.add(park5);
		list.add(park6);
		list.add(park7);
		list.add(park8);
		list.add(park9);
		list.add(park10);

		return list;

	}
}
