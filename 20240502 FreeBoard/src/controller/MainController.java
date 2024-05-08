package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import service.FreeService;
import util.ScanUtil;
import util.View;
import view.Print;

/**
 * controller 화면 이동 service 기능 dao db 연동
 * 
 * 
 */
public class MainController extends Print {

	static public Map<String, Object> sessionStorage = new HashMap<>();
	
	boolean debug = true;
	
	FreeService freeService = FreeService.getInstance();
	
	
	public static void main(String[] args) {
		new MainController().start();
	}

	private void start() {
		View view = View.HOME;
		while (true) {
			switch (view) {
			case HOME:
				view = home();
				break;
			case FreeBoard_print:
				view = freeboard_print();
				break;
			case Add_FreeBoard:
				view = add_freeboard();
				break;
			case FreeBoard_check:
				view = freeboard_check();
				break;
			case FreeBoard_Delete:
				view = freeboard_del();
				break;
			case FreeBoard_midify:
				view = freeboard_modify();
				break;
			default:
				break;
			}
		}
	}
	
	// 게시판 전체 출력
	private View freeboard_print() {
		if(debug) System.err.println("게시판 전체 출력\n");
		List<Map<String, Object>> list = freeService.list();
		System.out.println("번호\t제목\t내용\t");
		for (Map<String, Object> map : list) {
			System.out.println(map.get("NO")+"\t"+map.get("NAME")+"\t"+map.get("CONTENT"));
		}
		System.out.println("1. 게시판 상세 조회");
		System.out.println("2. 홈");
		int sel = ScanUtil.menu();
		if (sel == 1) {
			int boardNO = ScanUtil.nextInt("게시판 번호 입력: ");
			sessionStorage.put("boardNo", boardNO);
			return View.FreeBoard_check;
		}
		else if (sel == 2) return View.HOME;
		
		return View.FreeBoard_print;
		
	}
	
	// 게시판 상세 조회
	private View freeboard_check() {
		if(debug) System.err.println("게시판 상세 조회\n");
		
		int boardNo = (int)sessionStorage.get("boardNo");
		
		List<Object> param = new ArrayList<Object>();
		param.add(boardNo);
		Map<String, Object> detail = freeService.detail(param);
		System.out.println(detail);
		
		System.out.println("1. 게시판 수정");
		System.out.println("2. 게시판 삭제");
		System.out.println("3. 게시판 전체 출력");
		int sel = ScanUtil.menu();
		if (sel == 1) return View.FreeBoard_midify;
		else if (sel == 2) return View.FreeBoard_Delete;
		else if (sel == 3) return View.FreeBoard_print;
		
		return View.FreeBoard_check;
	}
	
	// 게시판 수정
	private View freeboard_modify() {
		
		System.out.println("게시판 수정");
		int sel = ScanUtil.nextInt("1. 게시판 상세조회");
		if (sel == 1) return View.FreeBoard_check;
		
		return View.FreeBoard_midify;
	}
	
	
	// 게시판 삭제
	private View freeboard_del() {
		System.out.println("게시판 삭제");
		
		int boardNo = (int) sessionStorage.get("boardNo");
		List<Object> param = new ArrayList();
		param.add(boardNo);
		freeService.delete(param);
		
		
		int sel = ScanUtil.nextInt("메뉴 선택 : ");
		if (sel == 1) return View.HOME;
		
		
		return View.FreeBoard_Delete;
	}
	
	
	// 게시판 추가
	private View add_freeboard() {
		System.out.println("게시판 추가");
		
		String name = ScanUtil.nextLine("제목");
		String content = ScanUtil.nextLine("내용");
		String writer = ScanUtil.nextLine("작성자");
		
		List<Object> param = new ArrayList<Object>();
		param.add(name);
		param.add(content);
		param.add(writer);
		
		freeService.insert(param);
		
		return View.FreeBoard_print;
	}
	
	
	
	
	// 메인 홈
	private View home() {

		System.out.println("1. 게시판 전체 출력");
		System.out.println("2. 게시판 추가");
		
		int sel = ScanUtil.menu();
		if (sel == 1) return View.FreeBoard_print;
		else if (sel == 2) return View.Add_FreeBoard;
		else return View.HOME;
		
	}

}
