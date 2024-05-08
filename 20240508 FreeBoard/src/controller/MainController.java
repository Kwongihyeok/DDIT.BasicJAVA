package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import service.FreeService;
import service.MemberService;
import util.ScanUtil;
import util.View;
import view.Print;
import vo.FreeVo;
import vo.MemberVo;

public class MainController extends Print {
	
	static public Map<String, Object> sessionStorage = new HashMap<>();
	FreeService freeService = FreeService.getInstance();
	MemberService memberService = MemberService.getInstance();
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
			case ADMIN:
				view = home();
				break;
			case MEMBER_LOGIN:
				view = member_login();
				break;
			case ADMIN_FREEBOARD_LIST:
				view = home();
				break;
			case ADMIN_FREEBOARD_MANAGEMENT:
				view = home();
				break;
			case ADMIN_FREEBOARD_DETAIL:
				view = home();
				break;
			case ADMIN_FREEBOARD_FAULTY:
				view = home();
				break;
			case MEMBER_FREEBOARD_LIST:
				view = member_freeboard_list();
				break;
			case MEMBER_FREEBOARD_DETAIL:
				view = member_freeboard_detail();
				break;
			case MEMBER_FREEBOARD_UPDATE:
				view = member_freeboard_update();
				break;
//			case MEMBER_FREEBOARD_DELETE:
//				view = member_freeboard_delete();
//				break;
			case MEMBER_FREEBOARD_ADD:
				view = home();
				break;
			default:
				break;
			}
		}
	}

	private View home() {
		//홈
		//HEADER
		printLine();
		System.out.print("홈");
		printNewLine();
		//BODY
		System.out.println("1. 전체 게시판 조회");
		System.out.println("2. 게시판 등록");
		
		int sel = scanMenu();
		
		if (sel == 1) {
			// 전체 게시판 조회
			return View.MEMBER_FREEBOARD_LIST;
		}else if(sel == 2) {
			// 게시판 등록
			return View.MEMBER_FREEBOARD_ADD;
		}else if(sel == 0) {
			//ADMIN PAGE
			return View.ADMIN;
		}
		return View.HOME;	
	}
	
	private View member_login() {
		String id = ScanUtil.nextLine("ID: ");
		String pw = ScanUtil.nextLine("PW: ");
		
		List<Object> param = new ArrayList<Object>();
		param.add(id);
		param.add(pw);
		param.add(1);
		boolean loginChk = memberService.login(param, 1);
		if(!loginChk) {
			System.out.println("1. 재로그인");
			System.out.println("2. 회원가입");
			System.out.println("3. 홈");
			return View.MEMBER_LOGIN;
		}
		View view = (View) sessionStorage.get("view");
		if(view == null) {
			return View.MEMBER_LOGIN;
		}
		else {
			return view;	
		}
		
	}
	
	private View admin() {
		//ADMIN PAGE
		//Header
		printLine();
		System.out.print("관리자");
		printNewLine();
		
		//Body
		System.out.println("1. 게시판 관리");
		System.out.println("2. 회원 관리");
		
		int sel = scanMenu();
		
		if (sel == 1) {
			return View.MEMBER_FREEBOARD_LIST;
		}else if (sel == 2) {
			
		}
		
		return View.ADMIN;
	}
	
	private View member_freeboard_list() {
		List<FreeVo> freeList = freeService.member_free_list();
		for (FreeVo freeVo : freeList) {
			int no = freeVo.getNo();
			String name = freeVo.getName();
			String content = freeVo.getContent();
			String writer = freeVo.getWriter();
			String regdate = freeVo.getRegdate();
			System.out.println(no+"\t"+name+"\t"+content+"\t"+writer+"\t"+regdate);
		}
		System.out.println("1. 게시판 상세 조회");
		System.out.println("2. 홈");
		int sel = scanMenu();
		if (sel == 1) {
			int boardNo = ScanUtil.nextInt("게시판 번호 >> ");
			sessionStorage.put("boardNo", boardNo);
			return View.MEMBER_FREEBOARD_DETAIL;
		}else if(sel == 2) {
			return View.HOME;
		}else {
			return View.MEMBER_FREEBOARD_LIST;
		}
	}
	
	private View member_freeboard_detail() {
		int boardNo = (int)sessionStorage.get("boardNo");
		List<Object> param = new ArrayList();
		
		param.add(boardNo);
		
		FreeVo freeVo = freeService.member_free_Detail(param);
		
		int no = freeVo.getNo();
		String name = freeVo.getName();
		String content = freeVo.getContent();
		String writer = freeVo.getWriter();
		String regdate = freeVo.getRegdate();
		System.out.println(no+"\t"+name+"\t"+content+"\t"+writer+"\t"+regdate);
		
		System.out.println("<이전글 \t 다음글>");
		System.out.println("1. 게시판 변경");
		System.out.println("2. 게시판 삭제");
		System.out.println("3. 전체 게시판 조회");
	
		String sel = ScanUtil.nextLine("메뉴 >> ");
		if (sel.equals("1")) {
			return View.MEMBER_FREEBOARD_UPDATE;
		}else if (sel.equals("2")) {
			return View.MEMBER_FREEBOARD_DELETE;
		}else if (sel.equals("3")) {
			return View.MEMBER_FREEBOARD_LIST;
		}else if (sel.equals("<")) {
			boardNo = freeVo.getPrevno();
			if (boardNo == 0) {
				System.out.println("이전 게시글 X");
			}else {
				sessionStorage.put("boardNo", boardNo);
			}
			return View.MEMBER_FREEBOARD_DETAIL;
		}else if (sel.equals(">")) {
			boardNo = freeVo.getNextno();
			if (boardNo == 0) {
				System.out.println("다음 게시글 X");
			}else {
				sessionStorage.put("boardNo", boardNo);
			}
			return View.MEMBER_FREEBOARD_DETAIL;
		}
		
		return View.MEMBER_FREEBOARD_DETAIL;
	}
	
	private View member_freeboard_update() {
		if (!sessionStorage.containsKey("member")) {
			sessionStorage.put("view", View.MEMBER_FREEBOARD_UPDATE);
			return View.MEMBER_LOGIN;	
		}
		int boardNo = (int)sessionStorage.get("boardNo");
		List<Object> param = new ArrayList();
		
		param.add(boardNo);
		
		FreeVo freeVo = freeService.member_free_Detail(param);
		freeVo.getMem_no();
		MemberVo member = (MemberVo) sessionStorage.get("member");
		
		if(freeVo.getMem_no() != member.getMem_no()) {
			System.out.println("해당 게시글 변경 권한이 없습니다.");
			return View.MEMBER_FREEBOARD_DETAIL;
		}
		
		String content = ScanUtil.nextLine("내용 : ");
		List<Object> param2 = new ArrayList<Object>();
		param2.add(content);
		param2.add(boardNo);
		freeService.member_free_update(param2);
		return View.MEMBER_FREEBOARD_LIST;
	}
}
