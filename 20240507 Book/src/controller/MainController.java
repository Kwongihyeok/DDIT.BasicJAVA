package controller;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import service.BookService;
import service.MemberService;
import util.ScanUtil;
import util.View;
import view.Print;

public class MainController extends Print {

	static public Map<String, Object> sessionStorage = new HashMap<>();
	MemberService memberService = MemberService.getInstance();
	BookService bookService = BookService.getInstance();
	boolean debug = true;
	

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
			case MANAGER:
				view = MANAGER();
				break;	
			case MEMBER:
				view = MEMBER();
				break;	
			case BOOK_information:
				view = BOOK_information();
				break;	
			case BOOK_possession:
				view = BOOK_possession();
				break;
			case BOOK_TOTAL:
				view = BOOK_TOTAL();
				break;
//			case BOOK_INSERT:
//				view = BOOK_INSERT();
//				break;

//			case BOOK_DELETE:
//				view = BOOK_DELETE();
//				break;
//			case BOOK_BUY:
//				view = BOOK_BUY();
//				break;
//			case BOOK_discard:
//				view = BOOK_discard();
//				break;
//			case BOOK_have_out:
//				view = BOOK_have_out();
//				break;
			case MY_BOOK_list:
				view = MY_BOOK_list();
				break;
			case BOOK_Loans:
				view = BOOK_Loans();
				break;
			case LOGIN:
				view = LOGIN();
				break;
			case BOOK_UPDATE:
				view = bookList();
				break;
			case HOLD_LIST:
				view = holdList();
				
			
				
			default:
				break;
			}
		}
	}		
	
	private View holdList() {
		
		int page = 1;
		if(sessionStorage.containsKey("page")) page = (int) sessionStorage.get("page");
		int startNo = 1 + (page-1)*5;
		int endNO = page*5;
		
		List<Object> param = new ArrayList();
		param.add(startNo);
		param.add(endNO);
		
		List<Map<String, Object>> list = bookService.holdList(param);
		for (Map<String, Object> map : list) {
			System.out.println(map);
		}
		System.out.println("<이전페이지\t다음페이지>");
		System.out.println("1.홈");
		
		String sel = ScanUtil.nextLine("메뉴 : ");
		if (sel.equals("<")) {
			if (page != 1) page --;
			sessionStorage.put("page", page);
			return View.HOLD_LIST;
		}
		else if(sel.equals(">")){
			page++;
			sessionStorage.put("page", page);
			return View.HOLD_LIST;
		}
		else if(sel.equals("1")) {
			return View.HOME;
		}
		else return View.HOLD_LIST;
	}
	
	private View bookList() {
		List<Map<String, Object>> bookList = bookService.bookList();
		bookListPrint(bookList);
		
		int bookNo = ScanUtil.nextInt("책 번호 선택");
		System.out.println("1. 제목");
		System.out.println("2. 내용");
		System.err.println("3. 전체");
		
		int sel = ScanUtil.menu();
		
		List<Object> param = new ArrayList();
		
		if (sel == 1 || sel == 3) {
			String title = ScanUtil.nextLine("제목 :  ");
			param.add(title);
		}
		if(sel == 2 || sel == 3) {
			String content = ScanUtil.nextLine("내용 : ");
			param.add(content);
		}
		param.add(bookNo);
		bookService.bookUpdate(param, sel);
		
		
		return View.BOOK_information;
			
	
	}
	
	private View BOOK_TOTAL() {

		List<Map<String, Object>> bookList = bookService.bookList();
		for (Map<String, Object> map : bookList) {
			BigDecimal bookNo = (BigDecimal) map.get("BOOK_NO");
			String title = (String) map.get("TITLE");
			String content = (String) map.get("CONTENT");
			String pubdate = (String) map.get("PUBDATE");
			System.out.println(bookNo+"\t"+title+"\t"+content+"\t"+pubdate);
		}
		
		
		return View.BOOK_information;
	}

	private View home() {
		if (debug)
			System.out.println("===============홈===============");
		
		printHome();
		
		int sel = ScanUtil.menu();
		if (sel == 1)
			return View.MANAGER;
		else if (sel == 2)
			return View.MEMBER;

		else
			return View.HOME;
	}


	
	
	private View MANAGER() {
		if (debug)
			System.out.println("===============홈===============");
		
		if(!sessionStorage.containsKey("admin")) {     //// 관리자 로그인 확인!!
			sessionStorage.put("role", 2);
			return View.LOGIN;
			}
		
		printAdmin();
		int sel = ScanUtil.menu();
		if (sel == 1)return View.BOOK_information; 
		else if (sel == 2)return View.BOOK_possession;
		else return View.MANAGER;
	}
	
	private View BOOK_information() {
		if (debug)
			System.out.println("=============1.도서 정보===========");

		System.out.println("1. 도서 정보 전체 출력");
		System.out.println("2. 도서 정보 추가");
		System.out.println("3. 도서 정보 변경");
		System.out.println("4. 도서 정보 삭제");
		System.out.println("5. 관리자 홈");
		System.out.println("6. holdlist");
		int sel = ScanUtil.menu();
		if (sel == 1) return View.BOOK_TOTAL;               // list - 도서 정보 전체 출력
		else if (sel == 2)return View.BOOK_INSERT;
		else if (sel == 3)return View.BOOK_CHANGE;          // update - 도서 정보 변경
		else if (sel == 4)return View.BOOK_DELETE;
		else if (sel == 5)return View.MANAGER;
		else if (sel == 6)return View.HOLD_LIST;
		else return View.HOME;
	}
	

	private View BOOK_possession() {
		if (debug)
			System.out.println("=============2. 도서 보유===========");

		System.out.println("1. 도서 구매");
		System.out.println("2. 도서 폐기");
		System.out.println("3. 보유도서 출력");
		System.out.println("4. 관리자 홈");
	
		int sel = ScanUtil.menu();
		if (sel == 1) return View.BOOK_BUY;
		else if (sel == 2)return View.BOOK_discard;
		else if (sel == 3)return View.BOOK_have_out;
		else if (sel == 4)return View.MANAGER;
		else return View.MANAGER;
	}

	private View MEMBER() {
		if (debug)
			System.out.println("==============회원=============");

		System.out.println("1. 내 대여 도서 조회");
		System.out.println("2. 도서 대출");
		int sel = ScanUtil.menu();
		if (sel == 1)return View.MY_BOOK_list;
		else if (sel == 2)return View.BOOK_Loans;
		else return View.MANAGER;
	}
	
	private View MY_BOOK_list() {
		if (debug)
			System.out.println("=========1. 내 대여 도서 조회=========");

		System.out.println("--대여중인 도서 내역--");
		
		System.out.println("1. 도서 대출");
		System.out.println("2. 홈");
		int sel = ScanUtil.menu();
		if (sel == 1)return View.BOOK_Loans;
		else if (sel == 2)return View.HOME;
		else return View.MY_BOOK_list;
	}
	
	private View BOOK_Loans() {
		if (debug)
			System.out.println("=========도서 대출=========");

		System.out.println("--대출 가능 도서--");
		
		return View.MY_BOOK_list;
	}
	
	private View LOGIN() {
		
		
		String id = ScanUtil.nextLine("ID >>");
		String pw = ScanUtil.nextLine("PASS >>");
		int role =(int) sessionStorage.get("role");  //
		List<Object> param = new ArrayList<Object>();
		param.add(id);
		param.add(pw);
		param.add(role);
		
		boolean loginChk = memberService.login(param, role);
		if(!loginChk) {
			System.out.println("로그인 실패");
			return View.LOGIN;
		}
		
		if(role == 1) return View.MEMBER;
		else return View.MANAGER;
				
	}
}
